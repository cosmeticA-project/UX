package com.cosmetica.cosmetica.controller;

import com.cosmetica.cosmetica.model.Cart;
import com.cosmetica.cosmetica.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody Cart cart) {
        orderService.saveOrder(cart);
    }
}

