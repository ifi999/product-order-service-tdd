package com.example.productorderservicetdd.product.app.port;

import com.example.productorderservicetdd.product.domain.Product;

public interface ProductPort {
    void save(Product product);

    Product getProduct(long productId);
}
