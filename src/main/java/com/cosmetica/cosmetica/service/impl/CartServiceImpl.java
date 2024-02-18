package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.dto.CartDto;
import com.cosmetica.cosmetica.model.Cart;
import com.cosmetica.cosmetica.model.Product;
import com.cosmetica.cosmetica.model.User;
import com.cosmetica.cosmetica.repository.CartRepo;
import com.cosmetica.cosmetica.repository.ProductRepo;
import com.cosmetica.cosmetica.repository.UserRepo;
import com.cosmetica.cosmetica.response.CartMessage;
import com.cosmetica.cosmetica.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepository;
    private final UserRepo userRepository;
    private final ProductRepo productRepository;

    public CartServiceImpl(CartRepo cartRepository, UserRepo userRepository, ProductRepo productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartMessage addToCart(CartDto cartDto) {
        User user = userRepository.findById(cartDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(cartDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        int quantity = cartDto.getQuantity();

        if (user == null || product == null) {
            throw new RuntimeException("User or product not found");
        }

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);

        cartRepository.save(cart);

        return new CartMessage("Product added to cart", true);
    }

    @Override
    public CartMessage removeFromCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart not found");
        }

        cartRepository.deleteById(cartId);

        return new CartMessage("Product removed from cart", true);
    }
}
