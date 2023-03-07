package com.turgutcanozdemir.android.library.geonames.country.data.entity

import java.time.LocalDateTime

data class CountryInfo(var countryCode : String? = null,
                       var queryCount : Long = 1,
                       var queryDateTime: LocalDateTime = LocalDateTime.now(),
                       var saveDateTime: LocalDateTime = LocalDateTime.now(),
                       var sourceService: String = "geonames") {
}