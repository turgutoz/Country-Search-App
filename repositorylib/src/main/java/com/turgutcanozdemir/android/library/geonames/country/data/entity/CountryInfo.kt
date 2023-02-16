package com.turgutcanozdemir.android.library.geonames.country.data.entity

import java.time.LocalDateTime

data class CountryInfo(var countryCode : String? = null,
                var queryDateTime: LocalDateTime = LocalDateTime.now()) {
}