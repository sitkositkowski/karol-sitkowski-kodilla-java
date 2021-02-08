package com.kodilla.good.patterns.flightfinder;

import java.util.Arrays;

public class FlightFinderRunner {
    public static void main (String[] args){

        Flight flight1 = new Flight("Moscow", "Berlin");
        Flight flight2 = new Flight("Paris", "Berlin");
        Flight flight3 = new Flight("Berlin", "Warsaw");
        Flight flight4 = new Flight("Madrid", "Oslo");
        Flight flight5 = new Flight("Lisbon", "Warsaw");
        Flight flight6 = new Flight("Rome", "Warsaw");
        Flight flight7 = new Flight("Lisbon", "London");
        Flight flight8 = new Flight("Prague", "Warsaw");
        Flight flight9 = new Flight("Vienna", "Berlin");
        Flight flight10 = new Flight("Brussels", "Paris");

        FlightFinder flightFinder = new FlightFinder();

        for (Flight flight : Arrays.asList(flight1,flight2,flight3,flight4,flight5,flight6,flight7,flight8,flight9,flight10))
            flightFinder.addFlight(flight);

        flightFinder.findFlightFrom("Lisbon");
        flightFinder.findFlightTo("Warsaw");
        flightFinder.findFlightThrough("Berlin");
    }
}
