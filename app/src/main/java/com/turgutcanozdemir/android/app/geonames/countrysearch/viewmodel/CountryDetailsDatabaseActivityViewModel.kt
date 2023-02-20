package com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel

import com.turgutcanozdemir.android.app.geonames.countrysearch.CountryDetailsDatabaseActivity
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO

class CountryDetailsDatabaseActivityViewModel constructor(var activity: CountryDetailsDatabaseActivity) {
    var countryDTO: CountryDTO = CountryDTO("", "", "", "", "", "")
    fun handleExitButtonClick() = activity.exitButtonClickCallback()
}