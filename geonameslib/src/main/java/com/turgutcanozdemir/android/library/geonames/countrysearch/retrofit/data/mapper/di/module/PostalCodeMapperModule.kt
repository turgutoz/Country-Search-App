package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper.di.module

import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper.CountryMapper
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.mapper.ICountryMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PostalCodeMapperModule {
    @Binds
    abstract fun bindCountryMapper(countryMapper: CountryMapper) : ICountryMapper
}