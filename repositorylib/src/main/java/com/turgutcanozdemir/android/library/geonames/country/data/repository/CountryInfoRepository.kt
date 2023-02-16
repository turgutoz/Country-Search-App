package com.turgutcanozdemir.android.library.geonames.country.data.repository

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.karandev.util.datetime.DateTimeConvertUtil
import com.turgutcanozdemir.android.library.geonames.country.data.entity.CountryInfo
import java.util.*
import javax.inject.Inject

private const val COUNTRY_CODE = "country_code"
private const val QUERY_DATE_TIME = "query_date_time"
private const val TABLE_NAME = "country_info"

class CountryInfoRepository @Inject constructor() : ICountryInfoRepository {
    @Inject
    lateinit var db : SQLiteDatabase

    private fun createCountryInfo(cursor: Cursor): CountryInfo
    {
        val countryCode = cursor.getString(0)
        val queryDateTime = cursor.getLong(1)

        return CountryInfo(countryCode, DateTimeConvertUtil.toLocalDateTime(queryDateTime))
    }

    override fun count(): Long {
        db.rawQuery("select count(*) as count from $TABLE_NAME", arrayOf("count")).use {
            it.moveToFirst()
            return it.getLong(0)
        }
    }

    // yazılamadı
    override fun existsById(id: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun findByCountry(country: String): CountryInfo? {
        val projection = arrayOf(COUNTRY_CODE, QUERY_DATE_TIME)
        var cursor: Cursor? = null
        var countryInfo : CountryInfo? = null

        try {
            cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)
            if (cursor != null && cursor.moveToFirst())
                countryInfo = createCountryInfo(cursor)
        }
        finally {
            cursor?.close()
        }

        return countryInfo
    }

    override fun <S: CountryInfo> save (countryInfo: S) : S
    {
        val cv = ContentValues()

        cv.put(COUNTRY_CODE, countryInfo?.countryCode)
        cv.put(QUERY_DATE_TIME, DateTimeConvertUtil.toMilliseconds(countryInfo?.queryDateTime))

        db.insertOrThrow(TABLE_NAME, null, cv)

        return countryInfo
    }

    override fun delete(entity: CountryInfo?) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<CountryInfo>?) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Int>?) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int?) {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<CountryInfo> {
        TODO("Not yet implemented")
    }

    override fun findAllById(id: MutableIterable<Int>?): MutableIterable<CountryInfo> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int?): Optional<CountryInfo> {
        TODO("Not yet implemented")
    }

    override fun <S : CountryInfo?> saveAll(entities: MutableIterable<S>?): MutableIterable<S> {
        TODO("Not yet implemented")
    }
}