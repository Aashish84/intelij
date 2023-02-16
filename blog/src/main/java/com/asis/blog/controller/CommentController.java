package com.asis.blog.controller;

import com.asis.blog.dto.CommentDto;
import com.asis.blog.entity.Comment;
import com.asis.blog.exception.CustomException;
import com.asis.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/comments")
    public ResponseEntity<?> getAllComment(){
        return new ResponseEntity<>(commentService.getAllComment() , HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.addComment(comment) , HttpStatus.CREATED);
    }

    @PutMapping("/comments/comment/{id}")
    public ResponseEntity<?> addCommentToComment(@PathVariable("id") Long id , @RequestBody CommentDto commentDto) throws CustomException {
        return new ResponseEntity<>(commentService.addCommentToComment(id,commentDto) , HttpStatus.OK);
    }

    @PutMapping("/comments/blog/{id}")
    public ResponseEntity<?> addCommentToBlog(@PathVariable("id") Long id , @RequestBody CommentDto commentDto) throws CustomException {
        return new ResponseEntity<>(commentService.addCommentToBlog(id,commentDto) , HttpStatus.OK);
    }

    @DeleteMapping("/comments/comment/{id}")
    public ResponseEntity<?> deleteCommentFromComment(@PathVariable("id") Long id){
        return new ResponseEntity<>(commentService.deleteCommentFromComment(id) , HttpStatus.OK);
    }
    @DeleteMapping("/comments/blog/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteCommentFromBlog(@PathVariable("id") Long id) throws CustomException {
        return new ResponseEntity<>(commentService.deleteCommentFromBlog(id) , HttpStatus.OK);
    }

    @PatchMapping("/comments/{id}")
    public ResponseEntity<?> updateComment(@PathVariable("id") Long id , @RequestBody Comment comment){
        return new ResponseEntity<>(commentService.updateComment(id , comment) , HttpStatus.OK);
    }
}
