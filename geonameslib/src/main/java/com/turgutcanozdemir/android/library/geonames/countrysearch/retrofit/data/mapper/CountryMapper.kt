package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper

import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country
import javax.inject.Inject

class CountryMapper @Inject constructor() : ICountryMapper {
    override fun toCountryDTO(country: Country): com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO {
        return com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO().apply {
            capital = country.capital
            languages = country.languages
            population = country.population
            countryName = country.countryName
            continentName = country.continentName
            currency = country.currencyCode
            countryCode = country.countryCode
        }
    }

    override fun toCountrySaveDTO(country: Country): com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO
    {
        return com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO()
            .apply {
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