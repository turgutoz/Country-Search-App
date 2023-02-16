package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper

import com.turgutcanozdemir.android.library.geonames.country.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.dto.CountrySaveDTO
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country
import javax.inject.Inject

class CountryMapper @Inject constructor() : ICountryMapper {
    override fun toCountryDTO(country: Country): CountryDTO {
        return CountryDTO().apply {
            capital = country.capital
            languages = country.languages
            population = country.population
            countryName = country.countryName
            continentName = country.continentName
            currency = country.currencyCode
            countryCode = country.countryCode
        }
    }

    override fun toCountrySaveDTO(country: Country): CountrySaveDTO
    {
        return CountrySaveDTO().apply {
            countryCode = country.countryCode
            continentName = country.continentName
            capital = country.capital
            languages = country.languages
            population = country.population
            currency = country.currencyCode
            countryName = country.countryName
        }
    }
}