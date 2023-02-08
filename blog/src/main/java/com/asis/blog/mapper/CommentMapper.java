package com.asis.blog.mapper;

import com.asis.blog.dto.CommentDto;
import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CustomUserMapper.class , CommentMapper.class} , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    @Mapping(source = "comment.id" , target = "commentId")
    @Mapping(source = "comment.user" , target = "userDto")
    @Mapping(source = "comment.comments" , target = "commentDtos")
    CommentDto entityToDto (Comment comment);
    @Mapping(source = "commentDto.commentId" , target = "id")
    @Mapping(source = "commentDto.userDto" , target = "user")
    @Mapping(source = "commentDto.commentDtos" , target = "comments")
    Comment dtoToEntity (CommentDto commentDto);
    List<CommentDto> entitiesToDtos (List<Comment> comments);
}
