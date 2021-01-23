package com.kodilla.good.patterns.service;

public class OrderRequest {

    private int orderId;
    private User user;
    private Product product;

    public OrderRequest(int orderId, User user, Product product) {
        this.orderId = orderId;
        this.user = user;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
