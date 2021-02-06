package com.kodilla.good.patterns.food2door;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ShopType1 implements Shop {

    private final String name;
    private Map<Product,Integer> productOffer;
    private final Deque<Order> orders;
    private final InformationService informationService;
    private final OrderRepository orderRepository;

    public ShopType1(String name, InformationService informationService, OrderRepository orderRepository) {
        this.name = name;
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orders = new ArrayDeque<>();
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
        this.orders.offer(order);
    }

    @Override
    public void process() {
        Order temporaryOrder;
        String isRealised;
        while (orders.size() != 0) {
            temporaryOrder = this.orders.poll();
            if (getProductOffer().containsKey(temporaryOrder.getProduct())){
                if (getProductOffer().get(temporaryOrder.getProduct()) >= temporaryOrder.getAmount()){
                    addProduct(temporaryOrder.getProduct(), -temporaryOrder.getAmount());
                    isRealised = "isRealised";
                } else {
                    isRealised = "notEnoughProducts";
                }
            } else {
                isRealised = "noSuchProduct";
            }
            informationService.inform(temporaryOrder, isRealised);
            orderRepository.createOrder(temporaryOrder, isRealised);
        }
    }
}
