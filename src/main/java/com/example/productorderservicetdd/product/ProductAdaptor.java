package com.example.productorderservicetdd.product;

import org.springframework.stereotype.Component;

@Component
class ProductAdaptor implements ProductPort {

    private final ProductRepository productRepository;

    public ProductAdaptor(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
