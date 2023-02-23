package com.example.server01.service;

import com.example.server01.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRole();
    Role addRole(Role role);
}
