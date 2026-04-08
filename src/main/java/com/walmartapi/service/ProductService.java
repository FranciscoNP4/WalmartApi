package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private ProductService productRepository;

    public ProductService(ProductService productRepository) {
        this.productRepository = productRepository;
    }
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        ProductEntity savedEntity = productRepository.save(productEntity);
        // map POJO to entity
        // Call DB
        // map entity to POJO
        product.setName(savedEntity.getName());
        product.setId(savedEntity.getId());
        product.setPrice(product.getPrice());
        product.setDescription(savedEntity.getDescription());

        return product;
    }

    private ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }


}
