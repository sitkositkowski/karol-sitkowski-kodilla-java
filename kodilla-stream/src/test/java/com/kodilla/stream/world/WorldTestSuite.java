package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        List<Continent> continents = new ArrayList<>();
        Continent europe = new Continent();
        europe.addCountry(new Country(new BigDecimal("10000000000000000000000000")));
        Continent asia = new Continent();
        for (int i=0; i<10; i++){
            asia.addCountry(new Country(new BigDecimal("10000000000000000000000000")));
        }
        Continent africa = new Continent();
        Continent northAmerica = new Continent();
        Continent southAmerica = new Continent();
        Continent antarctica = new Continent();

        continents.add(europe);
        continents.add(asia);
        continents.add(africa);
        continents.add(northAmerica);
        continents.add(southAmerica);
        continents.add(antarctica);

        World world = new World(continents);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedSand = new BigDecimal("110000000000000000000000000");      // [4]
        assertEquals(expectedSand, totalPeople);                                  // [5]
    }
}
