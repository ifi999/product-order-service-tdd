package com.example.productorderservicetdd.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    // getMapping까지 만들고나서부터는 이 ServiceTest는 필요가 없어진다.
    // 그래서 영상에서는 이 클래스를 삭제해버림

//    @Test
//    public void 상품조회() {
//        // 상품 등록
//        productService.addProduct(ProductSteps.상품등록요청_생성());
//        final long productId = 1L;
//
//        // 상품 조회
//        final GetProductResponse response = productService.getProduct(productId);
//
//        // 상품 응답 검증
//        // 보통 검증을 먼저 만든다고 한다. 내가 생각하던거의 역순
//        assertThat(response).isNotNull();
//    }

}
