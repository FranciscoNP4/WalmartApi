package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    private  final ProductService productRepository;
    private final CustomObjectMapper <ProductEntity, Product> productMapper;

    public ProductService(ProductService productRepository, CustomObjectMapper<ProductEntity, Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public Product saveProduct(Product product) {

        ProductEntity newProduct = productMapper.mapToEntity(product);
        ProductEntity savedEntity = productRepository.save(newProduct);
        Product savedProduct = new Product();

        return productMapper.mapToDto(savedEntity);
    }

    private ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public Product getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isEmpty()){
            throw new NotFound("Product not found");
        }
        return productMapper.mapToDto(product.get());
    }

}
