package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.api.di.module

import com.karandev.util.retrofit.RetrofitUtil
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.api.GEONAMES_BASE_URL
import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.api.ICountrySearch
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class CountrySearchModule @Inject constructor() {
    @Provides
    fun provideCountrySearch() : ICountrySearch = RetrofitUtil.createRetrofitWithLogging(GEONAMES_BASE_URL)
        .create(ICountrySearch::class.java)
}