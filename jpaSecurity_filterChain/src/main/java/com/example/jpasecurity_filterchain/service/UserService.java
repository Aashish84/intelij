package com.example.jpasecurity_filterchain.service;

import com.example.jpasecurity_filterchain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> allUser();
    User saveUser(User user);
}
