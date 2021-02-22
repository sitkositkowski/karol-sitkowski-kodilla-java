package com.kodilla.patterns.strategy.customers.predictors;

import com.kodilla.patterns.strategy.customers.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}