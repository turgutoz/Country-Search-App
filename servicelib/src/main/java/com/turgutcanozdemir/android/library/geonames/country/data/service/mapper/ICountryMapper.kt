package com.turgutcanozdemir.android.library.geonames.country.data.service.mapper

import com.turgutcanozdemir.android.library.geonames.country.data.entity.Country
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO

interface ICountryMapper {
    fun toCountry(countrySaveDTO: CountrySaveDTO) : Country
    fun toCountryDTO(country: Country) : CountryDTO
}