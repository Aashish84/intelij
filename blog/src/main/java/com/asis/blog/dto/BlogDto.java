package com.asis.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class BlogDto {
    public Long blogId;
    public String title;
    public String description;
    public Timestamp createdAt;
    public List<CommentDto> commentDtos;
    public UserDto userDto;
}