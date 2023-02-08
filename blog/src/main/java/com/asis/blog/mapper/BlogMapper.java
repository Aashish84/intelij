package com.asis.blog.mapper;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CommentMapper.class , CustomUserMapper.class})
public interface BlogMapper {
    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);
    @Mapping(source = "blog.id" , target = "blogId")
    @Mapping(source = "blog.comments", target = "commentDtos")
    @Mapping(source ="blog.user" ,target = "userDto")
    BlogDto entityToDto (Blog blog);
    @Mapping(source = "blogDto.blogId" , target = "id")
    @Mapping(source = "blogDto.commentDtos" , target = "comments")
    @Mapping(source = "blogDto.userDto" ,target = "user")
    Blog dtoToEntity (BlogDto blogDto);

    List<BlogDto> entitiesToDto (List<Blog> blogs);
}
