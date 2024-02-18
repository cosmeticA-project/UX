package com.cosmetica.cosmetica.repository;

import com.cosmetica.cosmetica.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
}
