package com.asis.blog.service;

import com.asis.blog.dto.CommentDto;
import com.asis.blog.entity.Comment;
import com.asis.blog.exception.CustomException;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComment();
    CommentDto addComment(Comment comment);
    CommentDto addCommentToComment(Long id , CommentDto commentDto) throws CustomException;
    List<CommentDto> addCommentToBlog(Long id , CommentDto commentDto) throws CustomException;
    String deleteCommentFromComment(Long id);
}
