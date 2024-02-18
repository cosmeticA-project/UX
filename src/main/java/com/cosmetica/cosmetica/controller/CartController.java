package com.cosmetica.cosmetica.controller;
import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.dto.UserDto;
import com.cosmetica.cosmetica.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<Void> addProductsToCart(@PathVariable Long userId, @RequestBody List<ProductDto> productDtoList) {
        UserDto user = new UserDto();
        user.setUserId(userId);

        for (ProductDto productDto : productDtoList) {
            cartService.addProductToCart(user, productDto, 1);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{userId}/remove")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long userId, @RequestBody ProductDto productDto) {
        UserDto user = new UserDto();
        user.setUserId(userId);
        cartService.removeProductFromCart(user, productDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
