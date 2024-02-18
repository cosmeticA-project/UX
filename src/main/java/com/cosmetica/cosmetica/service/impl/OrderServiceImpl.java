package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.model.Cart;
import com.cosmetica.cosmetica.model.Order;
import com.cosmetica.cosmetica.service.OrderService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setAddress(order.getAddress());
    }
}
