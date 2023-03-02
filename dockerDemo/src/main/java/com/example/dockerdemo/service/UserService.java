package com.example.dockerdemo.service;

import com.example.dockerdemo.database.ServerDatabaseOperation;
import com.example.dockerdemo.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> get() throws SQLException {
        String query = "Select * from user";
        ResultSet rs = new ServerDatabaseOperation().executeQuery(query);
        List<User> list = new ArrayList<>();
        while(rs.next()){
            User ob = new User();
            ob.setId(rs.getInt("id"));
            ob.setName(rs.getString("name"));
            ob.setEmail(rs.getString("email"));
            ob.setAge(rs.getInt("age"));
            list.add(ob);
        }
        return list;
    }
}
