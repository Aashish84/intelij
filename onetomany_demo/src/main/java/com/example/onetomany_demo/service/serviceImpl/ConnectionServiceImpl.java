package com.example.onetomany_demo.service.serviceImpl;

import com.example.onetomany_demo.entity.Connection;
import com.example.onetomany_demo.reporitory.ConnectionRepository;
import com.example.onetomany_demo.service.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConnectionServiceImpl implements ConnectionService {
    private final ConnectionRepository connectionRepository;
    @Override
    public List<Connection> getAllOrderItem() {
        return connectionRepository.findAll();
    }

    @Override
    public Connection saveOrderItem(Connection connection) {
        return connectionRepository.save(connection);
    }
}
