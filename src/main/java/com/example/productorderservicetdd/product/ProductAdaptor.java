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

    @Override
    public Product getProduct(final long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않음"));
    }
}
