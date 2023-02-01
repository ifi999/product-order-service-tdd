package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.DiscountPolicy;
import com.example.productorderservicetdd.product.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);

        int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(2000);
    }

}