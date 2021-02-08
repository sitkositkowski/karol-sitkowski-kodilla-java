package com.kodilla.good.patterns.flightfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {

    List<Flight> flights;

    public FlightFinder(){
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public void findFlightFrom(String departure){
        this.flights.stream()
                .filter(flight -> (flight.getDeparture().equals(departure)))
                .forEach(System.out::println);
    }

    public void findFlightTo(String arrival){
        this.flights.stream()
                .filter(flight -> (flight.getArrival().equals(arrival)))
                .forEach(System.out::println);
    }

    public void findFlightThrough(String layover){
        this.flights.stream().
                flatMap(flight -> this.flights.stream()
                        .filter(s -> !s.equals(flight))
                        .map(s ->Arrays.asList(flight,s)))
                .filter(flights -> flights.get(0).getArrival().equals(flights.get(1).getDeparture()))
                .filter(flights -> flights.get(0).getArrival().equals(layover))
                .forEach(System.out::println);

    }
}
