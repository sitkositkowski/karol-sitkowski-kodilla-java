package com.kodilla.good.patterns.service;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isRented = orderService.rent(orderRequest.getOrderId(),orderRequest.getUser(), orderRequest.getProduct());

        if (isRented) {
            informationService.inform(orderRequest.getUser(), orderRequest);
            orderRepository.createOrder(orderRequest.getOrderId(),orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
