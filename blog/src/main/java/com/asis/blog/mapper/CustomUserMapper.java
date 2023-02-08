package com.asis.blog.mapper;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomUserMapper {
    CustomUserMapper INSTANCE = Mappers.getMapper(CustomUserMapper.class);

    @Mapping(target = "email", ignore = true)
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "userName")
    UserDto entityToDto(User user);

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "userName", target = "name")
    User dtoToEntity(UserDto userDto);

    List<UserDto> entitiesToDtos(List<User> users);
}
