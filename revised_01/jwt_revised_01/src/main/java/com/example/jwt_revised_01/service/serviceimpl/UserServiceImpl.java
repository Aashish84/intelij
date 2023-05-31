package com.example.jwt_revised_01.service.serviceimpl;

import com.example.jwt_revised_01.entity.User;
import com.example.jwt_revised_01.repo.UserRepo;
import com.example.jwt_revised_01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public List<User> allUser() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
