package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.DiscountPolicy;
import com.example.productorderservicetdd.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    public void 상품주문() {
        Long productId = 1L;
        int quantity = 2;
        CreateOrderRequest request = new CreateOrderRequest(productId, quantity);

        orderService.createOrder(request);
    }

    private class OrderService {

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

    private class OrderAdapter implements OrderPort {

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

    private interface ProductRepository extends JpaRepository<Product, Long> {

    }

    private class Order {

        private Long id;
        private Product product;
        private int quantity;

        public Order(Product product, int quantity) {
            Assert.notNull(product, "상품 필수");
            Assert.isTrue(quantity > 0, "수량 0 이상");

            this.product = product;
            this.quantity = quantity;
        }

        public void assignId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    private class OrderRepository {
        private final Map<Long, Order> persistence = new HashMap<>();
        private Long sequence = 0L;
        public void save(Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(), order);
        }
    }

    private interface OrderPort {
        Product getProductById(Long productId);
        void save(Order order);
    }
}
