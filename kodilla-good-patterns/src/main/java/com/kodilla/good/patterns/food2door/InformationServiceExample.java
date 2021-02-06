package com.kodilla.good.patterns.food2door;

public class InformationServiceExample implements InformationService{

    @Override
    public void inform(Order order, String isRealized) {
        System.out.println(order);
        if (isRealized == "isRealised"){
            System.out.println("Order made. ");
        } else if (isRealized == "notEnoughProducts"){
            System.out.println("Order not made: [Not enough products in the shop.] ");
        } else {
            System.out.println("Order not made: [There is no such product.] ");
        }
    }
}
