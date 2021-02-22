package com.kodilla.patterns.strategy.customers.predictors;

import com.kodilla.patterns.strategy.customers.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}