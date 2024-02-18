package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.dto.ProductDto;
import com.cosmetica.cosmetica.dto.UserDto;
import com.cosmetica.cosmetica.model.Cart;
import com.cosmetica.cosmetica.model.CartItem;
import com.cosmetica.cosmetica.model.Product;
import com.cosmetica.cosmetica.repository.CartItemRepo;
import com.cosmetica.cosmetica.repository.CartRepo;
import com.cosmetica.cosmetica.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;

    @Autowired
    public CartServiceImpl(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @Override
    public void addProductToCart(UserDto user, ProductDto productDto, int quantity) {
        Cart cart = cartRepo.findByUserUserId(user.getUserId())
                .orElse(new Cart());

        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productDto.getProductId()))
                .findFirst();

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setCart(cart);

            Product product = new Product();
            product.setProductId(productDto.getProductId());
            cartItem.setProduct(product);

            cart.getCartItems().add(cartItem);
        }

        cartRepo.save(cart);
    }



    @Override
    public void removeProductFromCart(UserDto user, ProductDto productDto) {
        Cart cart = cartRepo.findByUserUserId(user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User does not have a cart"));

        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productDto.getProductId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product is not in the cart"));

        cart.getCartItems().remove(cartItem);

        cartRepo.save(cart);
    }
}
