package com.kodilla.patterns.strategy.customers.predictors;

import com.kodilla.patterns.strategy.customers.BuyPredictor;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}