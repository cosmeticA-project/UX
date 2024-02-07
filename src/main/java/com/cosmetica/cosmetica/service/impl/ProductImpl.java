package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.model.Product;
import com.cosmetica.cosmetica.model.User;
import com.cosmetica.cosmetica.model.UserRole;
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
    public void addProduct(ProductDto productDto, User user) {
        // Vérifier si l'utilisateur a les autorisations nécessaires
        if (user != null && user.getRole() == UserRole.ADMIN) {
            Product product = new Product();
            product.setProductName(productDto.getProductName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setStock(productDto.getStock());

            productRepo.save(product);
        } else {
            throw new RuntimeException("Only admins can add products.");
        }
    }

    @Override
    public void deleteProduct(Long productId, User user) {
        if (user != null && user.getRole() == UserRole.ADMIN) {
            productRepo.deleteById(productId);
        } else {
            throw new RuntimeException("Only admins can delete products.");
        }
    }
}
