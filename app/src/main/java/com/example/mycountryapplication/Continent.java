package com.example.mycountryapplication;

import java.io.Serializable;

public class Continent implements Serializable {
    private String nameOfContinent;

    public Continent(String nameOfContinent) {
        this.nameOfContinent = nameOfContinent;
    }

    public Continent(){}

    public String getNameOfContinent() {
        return nameOfContinent;
    }

    public void setNameOfContinent(String nameOfContinent) {
        this.nameOfContinent = nameOfContinent;
    }
}
