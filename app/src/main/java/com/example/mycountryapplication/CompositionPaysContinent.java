package com.example.mycountryapplication;

import java.io.Serializable;

public class CompositionPaysContinent implements Serializable {
    private String country;
    private String continent;

    public CompositionPaysContinent(String country, String continent) {
        this.country = country;
        this.continent = continent;
    }

    public CompositionPaysContinent(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    @Override
    public String toString() {
        return "CompositionPaysContinent{" +
                "CountryName='" + country + '\'' +
                ", ContinentName='" + continent + '\'' +
                '}';
    }




}
