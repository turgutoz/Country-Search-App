package com.turgutcanozdemir.android.library.geonames.country.data.service.mapper

import com.turgutcanozdemir.android.library.geonames.country.data.entity.Country
import com.turgutcanozdemir.android.library.geonames.country.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.dto.CountrySaveDTO
import javax.inject.Inject

class CountryMapper @Inject constructor(): ICountryMapper {
    override fun toCountry(countrySaveDTO: CountrySaveDTO): Country {
        return Country().apply {
            countryCode = countrySaveDTO.countryCode
            countryName = countrySaveDTO.countryName
            capital = countrySaveDTO.capital
            languages = countrySaveDTO.languages
            population = countrySaveDTO.population
            continentName = countrySaveDTO.continentName
            currency = countrySaveDTO.currency
        }
    }

    override fun toCountryDTO(country: Country): CountryDTO {
        return CountryDTO().apply {
            countryCode = country.countryCode
            capital = country.capital
            countryName = country.countryName
            continentName = country.continentName
            currency = country.currency
            languages = country.languages
            population = country.population
        }
    }
}