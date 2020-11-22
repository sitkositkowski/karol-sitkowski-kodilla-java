package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAvgTemperature() {
        double result = 0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            result += temperature.getValue();
        }
        return result/temperatures.getTemperatures().entrySet().size();
    }

    public double calculateMedianTemperature() {
        List<Double> resultList = new ArrayList<>();
        if (!temperatures.getTemperatures().isEmpty()){
            for (Map.Entry<String, Double> temperature :
                    temperatures.getTemperatures().entrySet()) {
                resultList.add(temperature.getValue());
            }
        }
        Collections.sort(resultList);
        if (resultList.size() % 2 == 0) {
            return (resultList.get(resultList.size()/2) +
                    resultList.get(resultList.size()/2)-1)/2;
        }
        return resultList.get((int) (Math.floor(resultList.size()/ 2)));
    }
}
