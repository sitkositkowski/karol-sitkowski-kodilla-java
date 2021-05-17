package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Funghi extends AbstractPizzaDecorator {
    public Funghi(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(1));
    }


    @Override
    public String getDescription() {
        return super.getDescription() + ", funghi";
    }
}