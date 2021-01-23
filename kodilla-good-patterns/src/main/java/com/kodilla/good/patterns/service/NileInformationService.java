package com.kodilla.good.patterns.service;

public class NileInformationService implements InformationService {
    @Override
    public void inform(User user, OrderRequest orderRequest) {
        System.out.println("The user: " + user + " has been informed of the order: " + orderRequest + " by e-mail.");
    }
}
