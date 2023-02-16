package com.turgutcanozdemir.android.library.geonames.country.data.service.mapper.di.module

import com.turgutcanozdemir.android.library.geonames.country.data.service.mapper.CountryMapper
import com.turgutcanozdemir.android.library.geonames.country.data.service.mapper.ICountryMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CountryMapperModule {
    @Binds
    abstract fun bindCountryMapper(countryMapper: CountryMapper) : ICountryMapper
}