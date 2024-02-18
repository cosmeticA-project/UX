package com.cosmetica.cosmetica.service;

import com.cosmetica.cosmetica.model.Cart;

public interface OrderService {
    void saveOrder(Cart cart);
}
