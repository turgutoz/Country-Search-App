package com.turgutcanozdemir.android.app.geonames.countrysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.turgutcanozdemir.android.app.geonames.countrysearch.databinding.ActivityCountryDetailsBinding
import com.turgutcanozdemir.android.app.geonames.countrysearch.keys.COUNTRY
import com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel.CountryDetailsActivityViewModel
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityCountryDetailsBinding

    private fun initCountry()
    {
        mBinding.viewModel!!.country = if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.TIRAMISU)
            intent.getSerializableExtra(COUNTRY) as Country
        else
            intent.getSerializableExtra(COUNTRY, Country::class.java)!!
    }

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_country_details)
        mBinding.viewModel = CountryDetailsActivityViewModel(this)
    }

    private fun setTextViewWikipediaLinks()
    {
        var text = mBinding.viewModel!!.country.countryName

        //Removes if the country name has a space (United States -> UnitedStates)
        if (text.contains(" "))
            text = text.replace(" ", "")

        val link = resources.getString(R.string.wiki_base_url) + text

        mBinding.link = link
    }

    private fun initialize()
    {
        initBinding()
        initCountry()
        setTextViewWikipediaLinks()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialize()
    }

    fun exitButtonClickCallback() = finish()
}