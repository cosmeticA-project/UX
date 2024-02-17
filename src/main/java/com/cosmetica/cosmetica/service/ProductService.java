package com.cosmetica.cosmetica.service;

import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.model.User;

public interface ProductService {

    void addProduct(ProductDto productDto);

    void deleteProduct(Long productId);
}
