package com.kodilla.exception.test;

import java.io.IOException;

public class ExceptionHandling {

    public static void main(String[] args) {
        //(x >= 2 || x < 1 || y == 1.5)
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyIWillThrowException(1.0,1.0);
            System.out.println(result);
        } catch (Exception e){
            System.out.println("Args are out of limits");
        }
    }
}
