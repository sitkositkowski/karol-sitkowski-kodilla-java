package com.kodilla.good.patterns.food2door;

import java.util.*;

public class ShopType3 implements Shop {

    private final String name;
    private Map<Product,Integer> productOffer;
    private List<Order> orders;
    private InformationService informationService;
    private OrderRepository orderRepository;

    public ShopType3(String name, InformationService informationService, OrderRepository orderRepository) {
        this.name = name;
        this.orderRepository = orderRepository;
        this.informationService = informationService;
        this.orders = new LinkedList<>();
        this.productOffer = new HashMap<>();
    }

    @Override
    public void setProductOffer(Map<Product, Integer> productOffer) {
        this.productOffer = productOffer;
    }

    public Map<Product, Integer> getProductOffer() {
        return productOffer;
    }

    @Override
    public void addProduct(Product product, int amount) {
        Map<Product, Integer> productOffer = new HashMap<>(getProductOffer());
        if (productOffer.containsKey(product)) {
            productOffer.put(product, amount + productOffer.get(product));
        } else {
            productOffer.put(product,amount);
        }
        setProductOffer(productOffer);
    }

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public void process() {
        final List<Order> temporaryOrders = new LinkedList<>();
        String isRealised;
        for (Order temporaryOrder: this.orders){
            System.out.println(temporaryOrder);
            if (getProductOffer().containsKey(temporaryOrder.getProduct())){
                if (getProductOffer().get(temporaryOrder.getProduct()) >= temporaryOrder.getAmount()){
                    isRealised = "isRealised";
                    addProduct(temporaryOrder.getProduct(), -temporaryOrder.getAmount());
                } else {
                    isRealised = "notEnoughProducts";
                    temporaryOrders.add(temporaryOrder);
                }
            } else {
                isRealised = "noSuchProduct";
                temporaryOrders.add(temporaryOrder);
            }

            informationService.inform(temporaryOrder, isRealised);
            orderRepository.createOrder(temporaryOrder, isRealised);

        }
        this.orders = temporaryOrders;
    }
}
