package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.order.app.service.OrderService;
import com.example.productorderservicetdd.payment.app.service.PaymentService;
import com.example.productorderservicetdd.product.app.service.ProductService;
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

    // API 테스트로 전환
//    @Test
//    public void 상품주문() {
//        productService.addProduct(ProductSteps.상품등록요청_생성());
//        orderService.createOrder(OrderSteps.상품주문요청_생성());
//        PaymenyRequest request = PaymentSteps.주문결제요청_생성();
//
//        paymentService.payment(request);
//    }

}
