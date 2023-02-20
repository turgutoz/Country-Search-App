package com.turgutcanozdemir.android.app.geonames.countrysearch

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karandev.util.retrofit.RetrofitUtil
import com.karandev.util.retrofit.putQueue
import com.turgutcanozdemir.android.app.geonames.countrysearch.databinding.ActivityMainBinding
import com.turgutcanozdemir.android.app.geonames.countrysearch.keys.COUNTRY
import com.turgutcanozdemir.android.app.geonames.countrysearch.keys.COUNTRYDTO
import com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel.MainActivityViewModel
import com.turgutcanozdemir.android.library.geonames.country.data.service.CountryAppService
import com.turgutcanozdemir.android.library.geonames.country.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.api.GEONAMES_BASE_URL
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.api.ICountrySearch
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Countries
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mCountries: List<Country>

    @Inject
    lateinit var countrySearch: ICountrySearch

    @Inject
    lateinit var countryAppService: CountryAppService

    @Inject
    lateinit var countryMapper: com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper.CountryMapper

    private fun responseCallback(response: Response<Countries>)
    {
        val countries = response.body()

        if(countries != null) {
            mCountries = countries.countries

            initCountryListView(countries.countries)

            if (mCountries.isEmpty())
                Toast.makeText(this, R.string.no_country_message, Toast.LENGTH_LONG).show()
            else {
                Thread.sleep(1000)
                alertDialogQuestion()
            }
        }
        else
            Toast.makeText(this, "Problem occurs", Toast.LENGTH_LONG).show()
    }

    private fun failCallback(call: Call<Countries>, ex: Throwable)
    {
        Toast.makeText(this@MainActivity, ex.message, Toast.LENGTH_LONG).show()
        call.cancel()
    }

    private fun alertDialogQuestion()
    {
        //Asks whether save db or not
        AlertDialog.Builder(this)
            .setMessage(R.string.message_text_main_activity_db_save_question)
            .setPositiveButton(R.string.message_text_main_activity_db_yes_button) {_, _ -> saveDatabase()}
            .setNegativeButton(R.string.message_text_main_activity_db_no_button) {_, _ -> ;}
            .create().show()
    }

    private fun saveDatabase()
    {
        val list = mCountries.map { countryMapper.toCountrySaveDTO(it) }
        countryAppService.saveCountry(list)
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
    }

    private fun initCountryListView(countries: List<Country>)
    {
        mBinding.mainActivityListInfoListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)

        mBinding.mainActivityListInfoListView.setOnItemClickListener { _, _, pos, _ -> countryListViewItemClickCallback(pos) }
    }

    private fun initCountryListViewMutableList(countries: MutableList<CountryDTO>)
    {
        mBinding.mainActivityListInfoListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)

        mBinding.mainActivityListInfoListView.setOnItemClickListener { _, _, pos, _ -> countryListViewDatabaseItemClickCallback(pos) }
    }

    private fun countryListViewItemClickCallback(pos: Int)
    {
        Intent(this, CountryDetailsActivity::class.java).apply {
            putExtra(
                COUNTRY,
                mBinding.mainActivityListInfoListView.getItemAtPosition(pos) as Country
            )
            startActivity(this)
        }
    }

    private fun countryListViewDatabaseItemClickCallback(pos: Int)
    {
        Intent(this, CountryDetailsDatabaseActivity::class.java).apply {
            putExtra(
                COUNTRYDTO,
                mBinding.mainActivityListInfoListView.getItemAtPosition(pos) as CountryDTO
            )
            startActivity(this)
        }
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.viewModel = MainActivityViewModel(this)
    }

    private fun initialize()
    {
        initBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        initialize()
    }

    fun listCountryInfoButtonClicked()
    {
        val country = mBinding.viewModel!!.country.countryCode

        val list = countryAppService.findCountriesByCountry(country).toMutableList()

        if(list.isNotEmpty())
            initCountryListViewMutableList(list)
        else {
            val call = countrySearch.findCountry("turgutoz", country, "true")
            call.putQueue({_, r -> responseCallback(r) }) { c, ex -> failCallback(c, ex) }
        }
    }
}