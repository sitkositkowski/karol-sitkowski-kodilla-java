package com.kodilla.good.patterns.food2door;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Food2DoorRunner {
    public static void main (String[] args){

        InformationService informationService = new InformationServiceExample();
        OrderRepository orderRepository = new OrderRepositoryExample();

        Shop shop1 = new ShopType1("ExtraFoodShop", informationService, orderRepository);
        Shop shop2 = new ShopType2("HealthyShop", informationService, orderRepository);

        Product product1 = new Product("oil");
        Product product2 = new Product("bread");
        Product product3 = new Product("cheese");
        Product product4 = new Product("ham");
        Product product5 = new Product("cucumber");

        Map<Product,Integer> productOffer1 = new HashMap<>();
        productOffer1.put(product1,10);
        productOffer1.put(product2,10);
        productOffer1.put(product3,10);
        productOffer1.put(product4,10);
        productOffer1.put(product5,10);

        Map<Product,Integer> productOffer2 = new HashMap<>();
        productOffer2.put(product1,10);
        productOffer2.put(product2,10);
        productOffer2.put(product3,10);
        productOffer2.put(product4,10);
        productOffer2.put(product5,10);

        shop1.setProductOffer(productOffer1);
        shop2.setProductOffer(productOffer2);

        Buyer buyer1 = new Buyer("John");
        Order order1a = new Order(1, buyer1, product1, 5);
        Order order1b = new Order(2, buyer1, product2, 12);
        Order order2a = new Order(3, buyer1, product3, 10);
        Order order2b = new Order(4, buyer1, product4, 100);

        for (Order order : Arrays.asList(order1a, order1b)) shop1.addOrder(order);
        for (Order order : Arrays.asList(order2a, order2b)) shop2.addOrder(order);

        shop1.process();
        shop2.process();

        System.out.println(shop1.getProductOffer());
        System.out.println(shop2.getProductOffer());

        shop2.addProduct(product4, 100);

        System.out.println(shop2.getProductOffer());

        shop2.process();

    }
}
