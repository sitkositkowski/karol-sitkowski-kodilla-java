package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigMacTestSuite {

    @Test
    void testBigMacNew() {
        //Given

        BigMac bigMac = new BigMac.BigMacBuilder()
                .ingredient("Onion")
                .ingredient("Pickles")
                .sauce("Secret sauce")
                .bun("Sesame seed bun")
                .burgers(2)
                .ingredient("Lettuce")
                .ingredient("Bacon")
                .burgers(1)
                .ingredient("Tomato")
                .build();

        System.out.println(bigMac);

        // When

        int howManyIngredients = bigMac.getIngredients().size();
        int howManyBurgers= bigMac.getBurgers();

        //Then
        assertEquals(5, howManyIngredients);
        assertEquals(3, howManyBurgers);
    }
}
