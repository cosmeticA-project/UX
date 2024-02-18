package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.model.Cart;
import com.cosmetica.cosmetica.model.CartItem;
import com.cosmetica.cosmetica.model.Order;
import com.cosmetica.cosmetica.model.OrderDetail;
import com.cosmetica.cosmetica.repository.CartRepo;
import com.cosmetica.cosmetica.repository.OrderDetailRepo;
import com.cosmetica.cosmetica.repository.OrderRepo;
import com.cosmetica.cosmetica.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartRepo cartRepo;

    @Override
    public void saveOrder(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setAddress(order.getAddress());
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));

        orderRepo.save(order);

        for (CartItem item : cart.getCartItems()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setProduct(item.getProduct());

            orderDetailRepo.save(orderDetail);
        }

        cartRepo.save(cart);
    }
}
