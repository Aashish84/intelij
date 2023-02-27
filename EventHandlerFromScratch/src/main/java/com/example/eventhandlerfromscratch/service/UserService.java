package com.example.eventhandlerfromscratch.service;

import com.example.eventhandlerfromscratch.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    String getAllUser();
    List<User> allUser() throws SQLException;
    int saveUser(User user);
    int updateUser(int id , User user);
    int deleteUser(int id);
}
