package com.asis.blog.mapper;

import com.asis.blog.dto.RoleDto;
import com.asis.blog.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(source = "roleDto.roleId" , target = "id")
    Role dtoToEntity (RoleDto roleDto);
    @Mapping(source = "role.id" , target = "roleId")
    RoleDto entityToDto (Role role);
    List<RoleDto> entitiesToDtos (List<Role> roles);
}
