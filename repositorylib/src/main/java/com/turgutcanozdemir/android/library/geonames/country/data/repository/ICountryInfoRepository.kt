package com.turgutcanozdemir.android.library.geonames.country.data.repository

import com.karandev.util.data.repository.ICrudRepository
import com.turgutcanozdemir.android.library.geonames.country.data.entity.CountryInfo

interface ICountryInfoRepository: ICrudRepository<CountryInfo, Int> {
    fun findByCountry(country: String) : CountryInfo?
}