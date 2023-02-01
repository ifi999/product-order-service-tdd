package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.order.OrderService;
import com.example.productorderservicetdd.order.OrderSteps;
import com.example.productorderservicetdd.product.ProductService;
import com.example.productorderservicetdd.product.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;

    @Test
    public void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());
        PaymenyRequest request = PaymentSteps.주문결제요청_생성();

        paymentService.payment(request);
    }

}
