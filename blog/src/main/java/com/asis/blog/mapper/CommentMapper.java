package com.asis.blog.mapper;

import com.asis.blog.dto.CommentDto;
import com.asis.blog.dto.UserDto;
import com.asis.blog.entity.Comment;
import com.asis.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "comment.id", target = "commentId")
    @Mapping(source = "comment.user", target = "userDto", qualifiedByName = "customUserMapper_EntityToDtoUser")
    @Mapping(source = "comment.comments", target = "commentDtos")
    CommentDto entityToDto(Comment comment);
    @Mapping(source = "commentDto.commentId", target = "id")
    @Mapping(source = "commentDto.userDto", target = "user", qualifiedByName = "customUserMapper_DtoToEntityUser")
    @Mapping(source = "commentDto.commentDtos", target = "comments")
    Comment dtoToEntity(CommentDto commentDto);
    List<CommentDto> entitiesToDtos(List<Comment> comments);

    //    custom user mapper
    @Named("customUserMapper_EntityToDtoUser")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "user.email", ignore = true)
    UserDto entityToDtoUser(User user);
    @Named("customUserMapper_DtoToEntityUser")
    @Mapping(source = "userDto.userId", target = "id")
    User dtoToEntityUser(UserDto userDto);
}
