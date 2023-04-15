package com.example.onetomany_demo.service;

import com.example.onetomany_demo.entity.Connection;

import java.util.List;

public interface ConnectionService {
    List<Connection> getAllOrderItem();
    Connection saveOrderItem(Connection connection);
}
