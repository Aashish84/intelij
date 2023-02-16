package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.RoleDto;
import com.asis.blog.entity.Role;
import com.asis.blog.mapper.RoleMapper;
import com.asis.blog.repository.RoleRepository;
import com.asis.blog.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDto> allRole() {
        List<Role> allRole = roleRepository.findAll();
        return roleMapper.entitiesToDtos(allRole);
    }

    @Override
    public RoleDto addRole(Role role) {
        Role newRole = roleRepository.save(role);
        return roleMapper.entityToDto(newRole);
    }
}
