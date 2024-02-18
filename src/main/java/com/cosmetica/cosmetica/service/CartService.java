package com.cosmetica.cosmetica.service;

import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.dto.UserDto;

public interface CartService {
    void addProductToCart(UserDto user, ProductDto product, int quantity);
    void removeProductFromCart(UserDto user, ProductDto product);
}
