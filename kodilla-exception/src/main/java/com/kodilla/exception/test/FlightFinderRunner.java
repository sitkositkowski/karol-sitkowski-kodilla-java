package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("Moscow", "Cracow");
        FlightFinder flightFinder = new FlightFinder();

        try {
            System.out.println(flightFinder.findFlight(flight));
        } catch (RouteNotFoundException e) {
            System.out.println("Airport doesn't exist, " +
                    "but my program still running very well! ");
        }

        System.out.println("Find other flight!");
    }
}
