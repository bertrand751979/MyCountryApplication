package com.example.mycountryapplication;

import java.io.Serializable;

public class Country implements Serializable {

    private String nameOfCountry;

    public Country(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public Country(){}


    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }
}
