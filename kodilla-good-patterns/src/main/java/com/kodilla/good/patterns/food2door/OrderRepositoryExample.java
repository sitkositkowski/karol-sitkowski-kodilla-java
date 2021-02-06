package com.kodilla.good.patterns.food2door;

public class OrderRepositoryExample implements OrderRepository{
    @Override
    public void createOrder(Order order, String isRealised) {
        System.out.println(order + ", " + isRealised);
    }
}
