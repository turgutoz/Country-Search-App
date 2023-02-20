package com.turgutcanozdemir.android.library.geonames.country.data.service.dto

class CountryDTO(
    var capital: String? = null,
    var countryCode: String? = null,
    var languages: String? = null,
    var population: String? = null,
    var countryName: String? = null,
    var continentName: String? = null,
    var currency: String? = null) : java.io.Serializable
{
    override fun toString(): String {
        return "$countryName $capital $currency"
    }
}