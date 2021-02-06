package com.kodilla.good.patterns.food2door;

public class Buyer {

    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                '}';
    }
}
