package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.ProductService;
import com.example.productorderservicetdd.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    // ProductServiceTest와 마찬가지로 API 테스트부터는 이 serviceTest 내용이 굳이 필요없어지나보다
//    @Test
//    public void 상품주문() {
//        productService.addProduct(ProductSteps.상품등록요청_생성());
//
//        CreateOrderRequest request = 상품주문요청_생성();
//
//        orderService.createOrder(request);
//    }

    public static CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

}
