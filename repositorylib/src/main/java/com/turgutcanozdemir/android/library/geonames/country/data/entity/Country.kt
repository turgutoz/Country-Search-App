package com.turgutcanozdemir.android.library.geonames.country.data.entity

class Country(
    var countryCode: String? = null,
    var capital: String? = null,
    var languages: String? = null,
    var population: String? = null,
    var countryName: String? = null,
    var continentName: String? = null,
    var currency: String? = null)
{
    var id : Long = 0L
}