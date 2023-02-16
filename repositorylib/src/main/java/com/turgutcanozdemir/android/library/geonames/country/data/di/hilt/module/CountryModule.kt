package com.turgutcanozdemir.android.library.geonames.country.data.di.hilt.module

import com.turgutcanozdemir.android.library.geonames.country.data.repository.CountryInfoRepository
import com.turgutcanozdemir.android.library.geonames.country.data.repository.CountryRepository
import com.turgutcanozdemir.android.library.geonames.country.data.repository.ICountryInfoRepository
import com.turgutcanozdemir.android.library.geonames.country.data.repository.ICountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CountryModule {
    @Binds
    @Singleton
    abstract fun bindCountryInfoRepository(countryInfoRepository: CountryInfoRepository) : ICountryInfoRepository

    @Binds
    @Singleton
    abstract fun bindCountryRepository(countryRepository: CountryRepository) : ICountryRepository
}