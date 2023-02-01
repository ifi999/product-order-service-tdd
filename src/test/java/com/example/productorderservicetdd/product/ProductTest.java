package com.example.productorderservicetdd.product;

import com.example.productorderservicetdd.product.domain.DiscountPolicy;
import com.example.productorderservicetdd.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductTest {

    @Test
    void update() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    void none_discounted_product() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        int discountedPrice = product.getdisCountPrice();

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void fix_discounted_product() {
        Product product = new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);

        int discountedPrice = product.getdisCountPrice();

        assertThat(discountedPrice).isEqualTo(0);
    }
}