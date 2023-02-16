package com.turgutcanozdemir.android.library.geonames.countrysearch.retrofit.data.entity;

import java.io.Serializable;

public class Country implements Serializable {
    public String continent;
    public String capital;
    public String languages;
    public int geonameId;
    public double south;
    public String isoAlpha3;
    public double north;
    public String fipsCode;
    public String population;
    public double east;
    public String isoNumeric;
    public String areaInSqKm;
    public String countryCode;
    public double west;
    public String countryName;
    public String postalCodeFormat;
    public String continentName;
    public String currencyCode;

    public Country(String continent, String capital, String languages, int geonameId, double south, String isoAlpha3, double north, String fipsCode, String population, double east, String isoNumeric, String areaInSqKm, String countryCode, double west, String countryName, String postalCodeFormat, String continentName, String currencyCode) {
        this.continent = continent;
        this.capital = capital;
        this.languages = languages;
        this.geonameId = geonameId;
        this.south = south;
        this.isoAlpha3 = isoAlpha3;
        this.north = north;
        this.fipsCode = fipsCode;
        this.population = population;
        this.east = east;
        this.isoNumeric = isoNumeric;
        this.areaInSqKm = areaInSqKm;
        this.countryCode = countryCode;
        this.west = west;
        this.countryName = countryName;
        this.postalCodeFormat = postalCodeFormat;
        this.continentName = continentName;
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return String.format("%s {capital=%s, languages=%s, population=%s, contitent=%s, currency=%s}",
                countryName, capital, languages, population, continentName, currencyCode);
    }
}
