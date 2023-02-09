package com.asis.blog.mapper;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = {CommentMapper.class} , componentModel = "spring")
public interface BlogMapper {
    @Mapping(source = "blog.id" , target = "blogId")
    @Mapping(source = "blog.comments", target = "commentDtos")
    @Mapping(source ="blog.user" ,target = "userDto" , qualifiedByName = "customUserBlogMapper")
    BlogDto entityToDto (Blog blog);
    List<BlogDto> entitiesToDto (List<Blog> blogs);

//    custom entityToUser
    @Named("customUserBlogMapper")
    @Mapping(source ="user.id" , target ="userId" )
    @Mapping(target = "email" , ignore = true)
//    @Mapping(source = "user.blogs",target = "blogDtos")
    /*
    * above line will bring StackOverflowError as when adding blog to user it will go on loop
    * */
    UserDto entityToDtoUser (User user);
}
