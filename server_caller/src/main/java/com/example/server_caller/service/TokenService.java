package com.example.server_caller.service;

import com.example.server_caller.pojo.AuthUser;

public interface TokenService {
    String getToken(AuthUser authUser);
}
