package com.kodilla.testing.shape;

public class Circle implements Shape{

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return "Circle r = " + r;
    }

    @Override
    public double getField() {
        return Math.PI * r * r;
    }
}
