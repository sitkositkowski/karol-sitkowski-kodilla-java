package com.kodilla.good.patterns.service;

public class NileOrderRepository implements OrderRepository {
    @Override
    public void createOrder(int id, User user, Product product) {
        System.out.println("Order "+ id + ", user: " + user +", product: " + product);
    }
}
