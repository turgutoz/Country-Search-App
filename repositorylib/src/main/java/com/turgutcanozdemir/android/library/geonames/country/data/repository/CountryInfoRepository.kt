package com.turgutcanozdemir.android.library.geonames.country.data.repository

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.karandev.util.datetime.DateTimeConvertUtil
import com.turgutcanozdemir.android.library.geonames.country.data.entity.CountryInfo
import java.util.*
import javax.inject.Inject

private const val COUNTRY_CODE = "country_code"
private const val QUERY_COUNT = "query_count"
private const val QUERY_DATE_TIME = "query_date_time"
private const val SAVE_DATE_TIME = "save_date_time"
private const val SOURCE_SERVICE = "source_service"

private const val TABLE_NAME = "country_info"

class CountryInfoRepository @Inject constructor() : ICountryInfoRepository {
    @Inject
    lateinit var db : SQLiteDatabase

    private fun createCountryInfo(cursor: Cursor): CountryInfo
    {
        val countryCode = cursor.getString(0)
        val queryCount = cursor.getLong(1)
        val queryDateTime = cursor.getLong(2)
        val saveDateTime = cursor.getLong(3)
        val sourceService = cursor.getString(4)

        return CountryInfo(countryCode, queryCount, DateTimeConvertUtil.toLocalDateTime(queryDateTime),
            DateTimeConvertUtil.toLocalDateTime(saveDateTime), sourceService)
    }

    override fun count(): Long {
        db.rawQuery("select count(*) as count from $TABLE_NAME", arrayOf("count")).use {
            it.moveToFirst()
            return it.getLong(0)
        }
    }

    override fun findByCountry(country: String): CountryInfo? {
        val projection = arrayOf(COUNTRY_CODE, QUERY_COUNT, QUERY_DATE_TIME, SAVE_DATE_TIME, SOURCE_SERVICE)
        var cursor: Cursor? = null
        var countryInfo : CountryInfo? = null

        try {
            cursor = db.query(TABLE_NAME, projection, "country = $country", null, null, null, null)
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

        cv.put(COUNTRY_CODE, countryInfo.countryCode)
        cv.put(QUERY_COUNT, 1)
        cv.put(QUERY_DATE_TIME, DateTimeConvertUtil.toMilliseconds(countryInfo.queryDateTime))
        cv.put(SAVE_DATE_TIME, DateTimeConvertUtil.toMilliseconds(countryInfo.saveDateTime))
        cv.put(SOURCE_SERVICE, countryInfo.sourceService)

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

    override fun existsById(id: Int?): Boolean {
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