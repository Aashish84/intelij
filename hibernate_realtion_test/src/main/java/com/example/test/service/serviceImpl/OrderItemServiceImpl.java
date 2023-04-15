package com.example.test.service.serviceImpl;

import com.example.test.entity.OrderItem;
import com.example.test.repository.OrderItemRepository;
import com.example.test.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    @Override
    public List<OrderItem> getAllOrders() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem saveOrder(OrderItem order) {
        return orderItemRepository.save(order);
    }
}
