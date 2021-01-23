package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        Map<String,Boolean> flightsMap = new HashMap<>();
        flightsMap.put("London", true);
        flightsMap.put("Warsaw", false);
        flightsMap.put("Frankfurt", true);
        flightsMap.put("Dubai", true);
        flightsMap.put("Rome", false);
        flightsMap.put("Lisbon", false);
        flightsMap.put("Vienna", true);
        flightsMap.put("Oslo", false);

        String arrivalAirport = flight.getArrivalAirport();

        if (flightsMap.keySet().contains(arrivalAirport)){
            return flightsMap.get(arrivalAirport);
        } else {
            throw new RouteNotFoundException("Airport doesn't exist.");
        }
    }
}
