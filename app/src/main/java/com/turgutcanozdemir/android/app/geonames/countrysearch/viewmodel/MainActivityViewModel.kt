package com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel

import com.turgutcanozdemir.android.app.geonames.countrysearch.MainActivity
import com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel.adapter.CountryListAdapter
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country

class MainActivityViewModel constructor(
    var activity: MainActivity,
    val country: Country = Country("", "", "", 0, 0.0, "", 0.0, "", "", 0.0, "", "", "", 0.0, "", "", "", ""),
    var adapter: CountryListAdapter<Country> = CountryListAdapter(activity)
){
    fun handleListButtonClicked() = activity.listCountryInfoButtonClicked()
}