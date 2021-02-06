package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface Shop {

    void process();

    void setProductOffer(Map<Product, Integer> productOffer);

    Map<Product, Integer> getProductOffer();

    void addProduct(Product product, int amount);

    void addOrder(Order order);
}
