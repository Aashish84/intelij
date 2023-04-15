package com.example.test.service;

import com.example.test.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrders();
    OrderItem saveOrder(OrderItem order);
}
