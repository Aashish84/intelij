package com.asis.blog.service;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.exception.CustomException;

import java.util.List;

public interface BlogService {
    List<BlogDto> getAllBlog();
    BlogDto addBlog(Blog blog);
    String deleteBlog(Long id);
    BlogDto updateBlog(Long id ,Blog bLog) throws CustomException;
    boolean deleteCommentFromParentBlog (Long childCommentId) throws CustomException;
    Blog findBlogById(Long blogId)throws CustomException;
}
