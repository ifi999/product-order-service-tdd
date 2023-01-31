package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.Product;
import org.springframework.stereotype.Component;

@Component
class OrderService {

    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.getProductId());

        Order order = new Order(product, request.getQuantity());

        orderPort.save(order);
    }
}
