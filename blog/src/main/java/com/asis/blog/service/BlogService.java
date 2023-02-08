package com.asis.blog.service;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<BlogDto> getAllBlog();
    BlogDto addBlog(Blog blog);
    String deleteBlog(Long id);
}
