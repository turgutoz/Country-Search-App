package com.turgutcanozdemir.android.library.geonames.country.data.service

import com.karandev.util.data.repository.exception.RepositoryException
import com.karandev.util.data.service.DataServiceException
import com.turgutcanozdemir.android.library.geonames.country.data.dal.CountryAppHelper
import com.turgutcanozdemir.android.library.geonames.country.data.entity.CountryInfo
import com.turgutcanozdemir.android.library.geonames.country.data.service.mapper.ICountryMapper
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountryDTO
import com.turgutcanozdemir.android.library.geonames.country.data.service.dto.CountrySaveDTO
import javax.inject.Inject

class CountryAppService @Inject constructor() {
    @Inject
    lateinit var countryAppHelper: CountryAppHelper

    @Inject
    lateinit var countryMapper: ICountryMapper

    fun saveCountry(countrySaveDTOs: List<CountrySaveDTO>) : Boolean
    {
        try {
            if (countrySaveDTOs.isEmpty())
                return false

            val countryCode = countrySaveDTOs[0].countryCode
            val list = countrySaveDTOs.map { countryMapper.toCountry(it) }.toList()

            return countryAppHelper.saveCountry(CountryInfo(countryCode), list)
        }
        catch (ex: RepositoryException) {
            throw DataServiceException("CountryAppService.saveCountry", ex.cause)
        }
    }

    fun findByCountry(country: String) : CountryInfo?
    {
        try {
            return countryAppHelper.findByCountry(country)
        }
        catch (ex: RepositoryException) {
            throw DataServiceException("CountryAppService.findByCountry", ex.cause)
        }
    }

    fun findCountriesByCountry(country: String) : MutableIterable<CountryDTO>
    {
        try {
            return countryAppHelper.findCountriesByCountry(country).map { countryMapper.toCountryDTO(it) }.toMutableList()
        }
        catch (ex: RepositoryException) {
            throw DataServiceException("CountryAppService.findCountriesByCountry", ex.cause)
        }
    }

    fun existById(code: Int) : Boolean
    {
        return TODO("it will be converted")
    }
}