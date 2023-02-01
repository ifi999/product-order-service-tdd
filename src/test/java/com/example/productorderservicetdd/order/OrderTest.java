package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.order.domain.Order;
import com.example.productorderservicetdd.product.domain.DiscountPolicy;
import com.example.productorderservicetdd.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);

        int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(2000);
    }

}