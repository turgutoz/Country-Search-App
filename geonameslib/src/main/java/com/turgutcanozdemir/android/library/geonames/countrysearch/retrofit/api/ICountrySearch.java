package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.api;

import com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity.Countries;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//http://api.geonames.org/countryInfoJSON?formatted=true&country=TR&username=turgutoz

public interface ICountrySearch {
    @GET("/countryInfoJSON")
    Call<Countries> findCountry(@Query("username") String username,
                                @Query("country")String country,
                                @Query("formatted")String formatted);
}