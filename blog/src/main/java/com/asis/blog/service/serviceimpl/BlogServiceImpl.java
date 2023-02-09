package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.exception.CustomException;
import com.asis.blog.mapper.BlogMapper;
import com.asis.blog.repository.BlogRepository;
import com.asis.blog.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }
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

    @Override
    public BlogDto updateBlog(Long id , Blog blog) throws CustomException {
        Optional<Blog> blogById = blogRepository.findById(id);
        if(blogById.isPresent()){
            blog.setId(blogById.get().getId());
            blog.setComments(blogById.get().getComments());
            blog.setCreatedAt(blogById.get().getCreatedAt());
            blog.setUser(blogById.get().getUser());
            return blogMapper.entityToDto(blogRepository.save(blog));
        }
        throw new CustomException("cannot update blog of id : "+id);
    }
}
