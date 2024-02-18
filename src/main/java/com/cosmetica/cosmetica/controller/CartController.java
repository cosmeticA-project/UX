package com.cosmetica.cosmetica.controller;

import com.cosmetica.cosmetica.dto.CartDto;
import com.cosmetica.cosmetica.response.CartMessage;
import com.cosmetica.cosmetica.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<CartMessage> addToCart(@RequestBody CartDto cartDto) {
        CartMessage cartMessage = cartService.addToCart(cartDto);
        return ResponseEntity.ok(cartMessage);
    }

    @DeleteMapping("/{cartId}/remove")
    public ResponseEntity<CartMessage> removeFromCart(@PathVariable Long cartId) {
        CartMessage cartMessage = cartService.removeFromCart(cartId);
        return ResponseEntity.ok(cartMessage);
    }
}
