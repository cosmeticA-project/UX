package com.cosmetica.cosmetica.controller;

import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.model.User;
import com.cosmetica.cosmetica.service.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/add")
    public String saveProduct(@RequestBody ProductDto productDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        productService.addProduct(productDto, user);
        return "Product added successfully";
    }
    @DeleteMapping(path = "/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        productService.deleteProduct(productId, user);
        return "Product deleted successfully";
    }
}