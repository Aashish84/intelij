package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.mapper.BlogMapper;
import com.asis.blog.repository.BlogRepository;
import com.asis.blog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper = BlogMapper.INSTANCE;
    @Override
    public List<BlogDto> getAllBlog() {
        List<Blog> allBlog = blogRepository.findAll();
        return blogMapper.entitiesToDto(allBlog);
    }

    @Override
    public BlogDto addBlog(Blog blog) {
        Blog newBlog = blogRepository.save(blog);
        return blogMapper.entityToDto(newBlog);
    }

    @Override
    public String deleteBlog(Long id) {
        blogRepository.deleteById(id);
        return "blog of id : "+id+" deleted";
    }
}
