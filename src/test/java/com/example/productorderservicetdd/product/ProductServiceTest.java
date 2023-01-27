package com.example.productorderservicetdd.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdaptor(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    public void 상품등록() {
        //given
        final AddProductRequest request = 상품등록요청_생성();

        productService.addProduct(request);

        //when

        //then

    }

    private static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }

}
