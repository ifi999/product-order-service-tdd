package com.example.productorderservicetdd.order.adapter;

import com.example.productorderservicetdd.order.app.port.OrderPort;
import com.example.productorderservicetdd.order.domain.Order;
import com.example.productorderservicetdd.product.domain.Product;
import com.example.productorderservicetdd.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품 존재하지 않음"));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
