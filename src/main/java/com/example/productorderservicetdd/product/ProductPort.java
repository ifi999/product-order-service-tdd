package com.example.productorderservicetdd.product;

import org.springframework.stereotype.Component;

interface ProductPort {
    void save(Product product);
}
