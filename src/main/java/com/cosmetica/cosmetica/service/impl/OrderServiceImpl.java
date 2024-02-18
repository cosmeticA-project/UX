package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.model.Order;
import com.cosmetica.cosmetica.repository.OrderRepo;
import com.cosmetica.cosmetica.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order placeOrder(Order order) {
        // Set the order date to the current timestamp
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));

        // Save the order to the database
        return orderRepo.save(order);
    }
}
