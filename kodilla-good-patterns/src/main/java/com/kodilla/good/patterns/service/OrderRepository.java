package com.kodilla.good.patterns.service;

public interface OrderRepository {
    void createOrder(int id, User user, Product product);
}
