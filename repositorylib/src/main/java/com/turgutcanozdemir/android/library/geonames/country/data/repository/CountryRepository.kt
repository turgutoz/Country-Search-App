package com.turgutcanozdemir.android.library.geonames.country.data.repository

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import com.turgutcanozdemir.android.library.geonames.country.data.entity.Countries
import com.turgutcanozdemir.android.library.geonames.country.data.entity.Country
import java.util.*
import javax.inject.Inject

private const val COUNTRY_ID = "country_id"
private const val COUNTRY_CODE = "country_code"
private const val CAPITAL = "capital"
private const val LANGUAGES = "languages"
private const val POPULATION = "population"
private const val COUNTRY_NAME = "country_name"
private const val CONTINENT_NAME = "continent_name"
private const val CURRENCY = "currency"

private const val TABLE_NAME = "countries"

class CountryRepository @Inject constructor() : ICountryRepository {
    @Inject
    lateinit var db : SQLiteDatabase

    private fun createCountry(cursor: Cursor) : Country
    {
        val countryCode: String = cursor.getString(0)
        val capital : String = cursor.getString(1)
        val languages : String = cursor.getString(2)
        val population : String = cursor.getString(3)
        val countryName: String = cursor.getString(4)
        val continentName: String = cursor.getString(5)
        val currency: String = cursor.getString(6)

        return Country(countryCode, capital, languages, population, countryName, continentName, currency)
    }

    override fun <S: Country?> save(country: S) : S
    {
        val cv = ContentValues()

        cv.put(COUNTRY_CODE, country?.countryCode)
        cv.put(CAPITAL, country?.capital)
        cv.put(LANGUAGES, country?.languages)
        cv.put(POPULATION, country?.population)
        cv.put(COUNTRY_NAME, country?.countryName)
        cv.put(CONTINENT_NAME, country?.continentName)
        cv.put(CURRENCY, country?.currency)

        val countryId = db.insert(TABLE_NAME, null, cv)

        if (countryId == -1L)
            throw SQLiteException("CountryRepository.save")

        return country.also { it?.id = countryId }
    }

    override fun findByCountry(countryCode: String): MutableIterable<Country> {
        val countries = mutableListOf<Country>()
        val projection = arrayOf(COUNTRY_CODE, CAPITAL, LANGUAGES, POPULATION, COUNTRY_NAME, CONTINENT_NAME, CURRENCY)
        val cursor = db.query(TABLE_NAME, projection, "$COUNTRY_CODE = ?", arrayOf(countryCode), null, null, null)
        with(cursor) {
            while (moveToNext()) {
                val country = createCountry(cursor)
                countries.add(country)
            }
        }
        cursor.close()
        return countries
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Country?) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Country>?) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Int>?) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int?) {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<Country> {
        TODO("Not yet implemented")
    }

    override fun findAllById(id: MutableIterable<Int>?): MutableIterable<Country> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int?): Optional<Country> {
        TODO("Not yet implemented")
    }

    override fun <S : Country?> saveAll(entities: MutableIterable<S>?): MutableIterable<S> {
        TODO("Not yet implemented")
    }
}