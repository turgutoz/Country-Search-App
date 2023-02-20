package com.turgutcanozdemir.android.app.geonames.countrysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.turgutcanozdemir.android.app.geonames.countrysearch.databinding.ActivityCountryDetailsDatabaseBinding
import com.turgutcanozdemir.android.app.geonames.countrysearch.keys.COUNTRYDTO
import com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel.CountryDetailsDatabaseActivityViewModel
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailsDatabaseActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityCountryDetailsDatabaseBinding

    private fun initCountryDTO()
    {
        mBinding.viewModel!!.countryDTO = if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.TIRAMISU)
            intent.getSerializableExtra(COUNTRYDTO) as CountryDTO
        else
            intent.getSerializableExtra(COUNTRYDTO, CountryDTO::class.java)!!
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_country_details_database)
        mBinding.viewModel = CountryDetailsDatabaseActivityViewModel(this)
    }

    private fun setTextViewWikipediaLinks()
    {
        var text = mBinding.viewModel!!.countryDTO.countryName

        //Removes if the country name has a space (United States -> UnitedStates)
        if (text!!.contains(" "))
            text = text!!.replace(" ", "")

        val link = resources.getString(R.string.wiki_base_url) + text

        mBinding.link = link
    }

    private fun initialize()
    {
        initBinding()
        initCountryDTO()
        setTextViewWikipediaLinks()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    fun exitButtonClickCallback() = finish()
}