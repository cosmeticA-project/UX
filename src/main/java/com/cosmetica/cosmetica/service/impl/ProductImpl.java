package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.model.Product;
import com.cosmetica.cosmetica.repository.ProductRepo;
import com.cosmetica.cosmetica.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }
}