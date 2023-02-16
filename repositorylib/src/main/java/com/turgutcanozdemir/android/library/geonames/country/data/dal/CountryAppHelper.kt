package com.turgutcanozdemir.android.library.geonames.country.data.dal

import com.karandev.util.data.repository.exception.RepositoryException
import com.turgutcanozdemir.android.library.geonames.country.data.entity.Country
import com.turgutcanozdemir.android.library.geonames.country.data.entity.CountryInfo
import com.turgutcanozdemir.android.library.geonames.country.data.repository.ICountryInfoRepository
import com.turgutcanozdemir.android.library.geonames.country.data.repository.ICountryRepository
import java.sql.SQLException
import javax.inject.Inject

class CountryAppHelper @Inject constructor() {
    @Inject
    lateinit var countryRepository: ICountryRepository

    @Inject
    lateinit var countryInfoRepository: ICountryInfoRepository

    fun saveCountry(countryInfo: CountryInfo, countries: Iterable<Country>) : Boolean
    {
        try {
            countryInfoRepository.save(countryInfo)
            countries.forEach{countryRepository.save(it)}

            return true
        }
        catch (ex: SQLException) {
            throw RepositoryException("CountryAppHelper.saveCountry", ex)
        }
    }

    fun findByCountry(country: String) : CountryInfo?
    {
        try {
            return countryInfoRepository.findByCountry(country)
        }
        catch (ex: Exception) {
            throw RepositoryException("CountryAppHelper.findByCountry", ex)
        }
    }

    fun findCountriesByCountry(country : String) : MutableIterable<Country>
    {
        try {
            return countryRepository.findByCountry(country)
        }

        catch (ex: Exception) {
            throw RepositoryException("CountryAppHelper.findCountriesByCountry", ex)
        }
    }

    fun existsById(country: String) : Boolean
    {
        return TODO("not implemented yet")
    }

    //...
}