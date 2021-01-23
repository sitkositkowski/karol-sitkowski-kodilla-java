package com.kodilla.good.patterns.service;

public class OrderDto {

    public User user;
    public boolean isRented;

    public OrderDto(final User user, final boolean isRented) {
        this.user = user;
        this.isRented = isRented;
    }

    public User getUser() { return user; }

    public boolean isRented() { return isRented; }
}
