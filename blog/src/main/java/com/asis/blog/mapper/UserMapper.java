package com.asis.blog.mapper;

import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {AddressMapper.class , BlogMapper.class} , componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id" , target = "userId")
    @Mapping(source = "user.address" , target = "addressDto")
    @Mapping(source = "user.blogs" , target = "blogDtos")
    UserDto entityToDto (User user);
    @Mapping(source = "userId" , target = "id")
    @Mapping(source = "userDto.addressDto" , target = "address")
    @Mapping(source = "userDto.blogDtos" , target = "blogs")
    User dtoToEntity (UserDto userDto);
    List<UserDto> entitiesToDtos (List<User> users);
}
