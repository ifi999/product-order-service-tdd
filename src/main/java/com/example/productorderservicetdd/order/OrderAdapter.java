package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.Product;
import com.example.productorderservicetdd.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {

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
