package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private List<Country> countryList = new ArrayList<>();

    public Continent() {
        this.countryList = countryList;
    }


    public void addCountry(Country country){
        countryList.add(country);
    }

    public void removeCountry(Country country){
        countryList.remove(country);
    }
    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
