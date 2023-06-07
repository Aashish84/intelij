package com.example.jwt_revised_01.service;

import com.example.jwt_revised_01.entity.AuthUser;

import java.util.List;

public interface AuthUserService {
    List<AuthUser> fetchAllAuthUsers();
    AuthUser createAuthUser(AuthUser user);
}
