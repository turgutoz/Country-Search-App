package com.turgutcanozdemir.android.library.geonames.country.data.repository

import com.karandev.util.data.repository.ICrudRepository
import com.turgutcanozdemir.android.library.geonames.country.data.entity.Country

interface ICountryRepository : ICrudRepository<Country, Int> {
    fun findByCountry(country: String) : MutableIterable<Country>
}