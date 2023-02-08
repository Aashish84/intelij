package com.asis.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class CommentDto {
    private Long commentId;
    private String description;
    private Timestamp createdAt;
    private UserDto userDto;
    private List<CommentDto> commentDtos;
}
