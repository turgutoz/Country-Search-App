package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Countries {
    @SerializedName("geonames")
    public List<Country> countries;
}
