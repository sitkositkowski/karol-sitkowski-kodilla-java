package com.kodilla.patterns.strategy.customers;

import com.kodilla.patterns.strategy.customers.predictors.BalancedPredictor;

public class CorporateCustomer extends Customer {
    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}