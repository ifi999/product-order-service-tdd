package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.Product;

interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}
