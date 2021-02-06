package com.kodilla.good.patterns.food2door;

public class Order {

    private Integer id;
    private Buyer buyer;
    private Product product;
    private Integer amount;

    public Order(Integer id, Buyer buyer, Product product, Integer amount) {
        this.id = id;
        this.buyer = buyer;
        this.product = product;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }
}
