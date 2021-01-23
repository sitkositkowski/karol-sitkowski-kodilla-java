package com.kodilla.good.patterns.service;

public class NileOrderService implements OrderService{
    @Override
    public boolean rent(int id, User user, Product product) {
        System.out.println("Order id" + id + " product: " + product + " for: " + user.getLogin());

        return true;
    }
}
