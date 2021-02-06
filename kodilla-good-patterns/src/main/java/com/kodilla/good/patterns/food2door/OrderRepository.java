package com.kodilla.good.patterns.food2door;

public interface OrderRepository {
    void createOrder(Order order, String isRealised);
}
