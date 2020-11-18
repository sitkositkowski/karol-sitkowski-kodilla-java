package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {
        int a = 10;
        int b = 13;

        Calculator calculator = new Calculator();

        int resultAdd = calculator.add(a, b);
        int resultSubstract = calculator.substract(a, b);

        System.out.println("Test - first unit test:");
        if (resultAdd == a+b) {
            System.out.println("Correct!");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - second unit test:");
        if (resultSubstract == a-b) {
            System.out.println("Correct!");
        } else {
            System.out.println("Error!");
        }

    }
}