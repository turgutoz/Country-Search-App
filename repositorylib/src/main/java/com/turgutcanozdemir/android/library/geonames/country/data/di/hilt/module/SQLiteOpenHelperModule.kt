package com.turgutcanozdemir.android.library.geonames.country.data.di.hilt.module

import android.database.sqlite.SQLiteOpenHelper
import com.turgutcanozdemir.android.library.geonames.country.data.helper.DatabaseHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SQLiteOpenHelperModule {
    @Binds
    @Singleton
    abstract fun bindSQLiteOpenHelper(databaseHelper: DatabaseHelper) : SQLiteOpenHelper
}