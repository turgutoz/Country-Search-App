package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper

import com.turgutcanozdemir.android.library.geonames.country.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.dto.CountrySaveDTO
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country

interface ICountryMapper {
    fun toCountryDTO(country: Country) : CountryDTO
    fun toCountrySaveDTO(country: Country) : CountrySaveDTO
}