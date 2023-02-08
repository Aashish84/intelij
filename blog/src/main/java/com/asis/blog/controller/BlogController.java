package com.asis.blog.controller;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;
    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlog(){
        return new ResponseEntity<>(blogService.getAllBlog() , HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<?> addBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.addBlog(blog) , HttpStatus.CREATED);
    }
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<?> deleteBLog(@PathVariable("id") Long id){
        return new ResponseEntity<>( blogService.deleteBlog(id), HttpStatus.OK);
    }
}
