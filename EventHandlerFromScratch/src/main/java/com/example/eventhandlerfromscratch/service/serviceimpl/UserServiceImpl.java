package com.example.eventhandlerfromscratch.service.serviceimpl;

import com.example.eventhandlerfromscratch.database.ServerDatabaseOperation;
import com.example.eventhandlerfromscratch.model.User;
import com.example.eventhandlerfromscratch.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getAllUser() {
        String query = "select json_arrayagg(json_object(\"id\",id,\"name\",name,\"email\",email,\"age\",age,\"salary\",salary)) data from user;";
        return new ServerDatabaseOperation().executeQeuryString(query);
    }

    @Override
    public List<User> allUser() throws SQLException {
        String query = "select * from user";
        ServerDatabaseOperation serverDatabaseOperation = new ServerDatabaseOperation();
//        ResultSet rs = serverDatabaseOperation.executeQuery(query);
        ResultSet rs = serverDatabaseOperation.executeQueryCache(query);
        List<User> list = new ArrayList<>();

        while (rs.next()) {
            User ob = new User();
            ob.setId(rs.getInt("id"));
            ob.setName(rs.getString("name"));
            ob.setEmail(rs.getString("email"));
            ob.setAge(rs.getInt("age"));
            ob.setSalary(rs.getFloat("salary"));
            list.add(ob);
        }
        return list;
    }

    @Override
    public int saveUser(User user) {
        String query = "insert into user (id , name , email , age , salary) values (?,?,?,?,?)";
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, user.getId());
        map.put(2, user.getName());
        map.put(3, user.getEmail());
        map.put(4, user.getAge());
        map.put(5, user.getSalary());
        return new ServerDatabaseOperation().executeUpdateQuery(query, map);
    }

    @Override
    public int updateUser(int id, User user) {
        String query = "update user set`name`=? , `email`=? , `age`=?,`salary`=? where id=?";
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, user.getName());
        map.put(2, user.getEmail());
        map.put(3, user.getAge());
        map.put(4, user.getSalary());
        map.put(5, id);
        return new ServerDatabaseOperation().executeUpdateQuery(query, map);
    }

    @Override
    public int deleteUser(int id) {
        String query = "delete from user where id=?";
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);
        return new ServerDatabaseOperation().executeUpdateQuery(query, map);
    }
}
