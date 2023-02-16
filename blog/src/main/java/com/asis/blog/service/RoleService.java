package com.asis.blog.service;

import com.asis.blog.dto.RoleDto;
import com.asis.blog.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> allRole();
    RoleDto addRole(Role role);
}
