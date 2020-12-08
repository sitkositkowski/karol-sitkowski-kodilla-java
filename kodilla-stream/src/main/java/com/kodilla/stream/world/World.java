package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public class World {

    private List<Continent> continentList;

    public World(List<Continent> continentList) {
        this.continentList = continentList;
    }

    public BigDecimal getPeopleQuantity(){
        return continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)                              // [2]
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public void addContinent(Continent continent){
        continentList.add(continent);
    }

    public void removeContinent(Continent continent){
        continentList.remove(continent);
    }
    public List<Continent> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<Continent> countryList) {
        this.continentList = continentList;
    }
}
