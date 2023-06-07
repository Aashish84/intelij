package com.example.jwt_revised_01.service.serviceimpl;

import com.example.jwt_revised_01.entity.AuthUser;
import com.example.jwt_revised_01.repo.AuthUserRepo;
import com.example.jwt_revised_01.service.AuthUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserRepo authUserRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<AuthUser> fetchAllAuthUsers() {
        return authUserRepo.findAll();
    }

    @Override
    public AuthUser createAuthUser(AuthUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authUserRepo.save(user);
    }
}
