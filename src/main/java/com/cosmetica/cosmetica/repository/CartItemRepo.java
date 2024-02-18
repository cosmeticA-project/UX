package com.cosmetica.cosmetica.repository;

import com.cosmetica.cosmetica.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository <CartItem, Long> {
}
