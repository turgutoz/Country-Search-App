package com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel

import com.turgutcanozdemir.android.app.geonames.countrysearch.CountryDetailsActivity
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country

class CountryDetailsActivityViewModel constructor(var activity: CountryDetailsActivity) {
    var country: Country = Country("", "", "", 0, 0.0, "", 0.0, "", "", 0.0, "", "", "", 0.0, "", "", "", "")
    fun handleExitButtonClick() = activity.exitButtonClickCallback()
}