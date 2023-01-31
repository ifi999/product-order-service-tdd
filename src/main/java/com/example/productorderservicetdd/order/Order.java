package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.Product;
import org.springframework.util.Assert;

class Order {

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
