package com.kodilla.good.patterns.service;

public class ProductOrderServiceRunner {
    public static void main (String[] args){


        InformationService nileInformationService = new NileInformationService();
        OrderService nileOrderService = new NileOrderService();
        OrderRepository nileOrderRepository = new NileOrderRepository();

        ProductOrderService nile = new ProductOrderService(nileInformationService,nileOrderService,nileOrderRepository);

        User user = new User("John");
        Product product = new Product("Sandals");

        OrderRequest orderRequest = new OrderRequest(1,user,product);

        nile.process(orderRequest);

    }
}
