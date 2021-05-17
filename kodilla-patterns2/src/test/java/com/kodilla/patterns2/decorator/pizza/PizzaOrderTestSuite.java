package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder pizza = new Margherita();
        // When
        BigDecimal calculatedCost = pizza.getCost();
        // Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizza = new Margherita();
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Pomodori, mozzarella", description);
    }

    @Test void testFunghiPizzaOrderGetCost() {
        // Given
        PizzaOrder pizza = new Margherita();
        pizza = new Funghi(pizza);
        // When
        BigDecimal calculatedCost = pizza.getCost();
        // Then
        assertEquals(new BigDecimal(6), calculatedCost);
    }

    @Test
    public void testFunghiPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizza = new Margherita();
        pizza = new Funghi(pizza);
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Pomodori, mozzarella, funghi", description);
    }

    @Test void testCapricciosaPizzaOrderGetCost() {
        // Given
        PizzaOrder pizza = new Margherita();
        pizza = new Prosciutto(pizza);
        pizza = new Funghi(pizza);
        // When
        BigDecimal calculatedCost = pizza.getCost();
        // Then
        assertEquals(new BigDecimal(8), calculatedCost);
    }

    @Test
    public void testCapricciosaPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizza = new Margherita();
        pizza = new Prosciutto(pizza);
        pizza = new Funghi(pizza);
        // When
        String description = pizza.getDescription();
        // Then
        assertEquals("Pomodori, mozzarella, prosciutto, funghi", description);
    }


}
