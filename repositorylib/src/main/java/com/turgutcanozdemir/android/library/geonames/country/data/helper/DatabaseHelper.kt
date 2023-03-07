package com.turgutcanozdemir.android.library.geonames.country.data.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.karandev.util.data.repository.exception.RepositoryException
import dagger.hilt.android.qualifiers.ApplicationContext
import java.sql.SQLException
import javax.inject.Inject

private const val DATABASE_NAME = "countryappdb"
private const val DATABASE_VERSION = 1

private const val CREATE_COUNTRY_INFO = """
    CREATE TABLE country_info (
        country_code TEXT,
        query_count INTEGER default(1) not null,
        query_date_time INTEGER not null,
        save_date_time INTEGER not null,
        source_service TEXT not null,
        CONSTRAINT country_info_PK PRIMARY KEY(country_code)
    );
"""

private const val CREATE_COUNTRIES = """
    CREATE TABLE countries (
    country_id INTEGER primary key AUTOINCREMENT,
    country_code TEXT,
    capital TEXT,
    languages TEXT,
    population TEXT,
    country_name TEXT,
    continent_name TEXT,
    currency TEXT,
    CONSTRAINT countries_FK FOREIGN KEY (country_code) REFERENCES country_info(country_code)
    );
"""

private const val DROP_COUNTRY_INFO = "DROP TABLE country_info"
private const val DROP_COUNTRIES = "DROP TABLE countries"

class DatabaseHelper @Inject constructor(@ApplicationContext var context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        try {
            db.execSQL(CREATE_COUNTRY_INFO)
            db.execSQL(CREATE_COUNTRIES)
        }
        catch (ex: SQLException) {
            throw RepositoryException("DatabaseHelperException.onCreate")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        try {
            db.execSQL(DROP_COUNTRIES)
            db.execSQL(DROP_COUNTRY_INFO)
            onCreate(db)
        }
        catch (ex: SQLException) {
            throw RepositoryException("DatabaseHelper.onUpgrade")
        }
    }
}