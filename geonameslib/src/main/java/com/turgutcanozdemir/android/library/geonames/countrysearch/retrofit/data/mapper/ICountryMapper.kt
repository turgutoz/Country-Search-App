package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper

import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Country

interface ICountryMapper {
    fun toCountryDTO(country: Country) : com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO
    fun toCountrySaveDTO(country: Country) : com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO
}