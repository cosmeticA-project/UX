package com.cosmetica.cosmetica.service;

import com.cosmetica.cosmetica.dto.CartDto;
import com.cosmetica.cosmetica.response.CartMessage;

public interface CartService {
    CartMessage addToCart(CartDto cartDto);
    CartMessage removeFromCart(Long cartId);
}
