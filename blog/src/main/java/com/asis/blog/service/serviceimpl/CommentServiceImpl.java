package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.CommentDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.entity.Comment;
import com.asis.blog.exception.CustomException;
import com.asis.blog.mapper.CommentMapper;
import com.asis.blog.repository.BlogRepository;
import com.asis.blog.repository.CommentRepository;
import com.asis.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;
    private final CommentMapper commentMapper = CommentMapper.INSTANCE;

    public CommentServiceImpl(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public List<CommentDto> getAllComment() {
        List<Comment> allComment = commentRepository.findAll();
        return commentMapper.entitiesToDtos(allComment);
    }

    @Override
    public CommentDto addComment(Comment comment) {
        Comment newComment = commentRepository.save(comment);
        return commentMapper.entityToDto(newComment);
    }

    @Override
    public CommentDto addCommentToComment(Long id, CommentDto commentDto) throws CustomException {
//        get comment to add on
        Optional<Comment> findById = commentRepository.findById(id);
        if (!findById.isPresent()) {
            throw new CustomException("no comment found of id :" + id + " to update");
        }

        Comment comment = commentMapper.dtoToEntity(commentDto);

//            add new comment
        Comment newComment = commentRepository.save(comment);

//            get existing comment list
//            add newly saved comment
//            save
//            convert newly saved comment to dto
        Comment existingComment = findById.get();
        List<Comment> modifiedExistingCommentList = existingComment.getComments();
        modifiedExistingCommentList.add(newComment);
        existingComment.setComments(modifiedExistingCommentList);
        return commentMapper.entityToDto(commentRepository.save(existingComment));
    }

    @Override
    public List<CommentDto> addCommentToBlog(Long id, CommentDto commentDto) throws CustomException {
        Optional<Blog> findById = blogRepository.findById(id);
        if (!findById.isPresent()) {
            throw new CustomException("no blog of id : " + id + " to add comment");
        }

        Comment comment = commentMapper.dtoToEntity(commentDto);
        Comment newComment = commentRepository.save(comment);
        Blog blog = findById.get();
        List<Comment> blogComments = blog.getComments();
        blogComments.add(newComment);
        blog.setComments(blogComments);
        Blog saveBlog = blogRepository.save(blog);

        return commentMapper.entitiesToDtos(saveBlog.getComments());

    }
    @Override
    public String deleteCommentFromComment(Long id) {
        Comment findById = commentRepository.findById(id).get();
        for(Comment comment : findById.getComments()){
            deleteCommentFromComment(comment.getId());
        }
            System.out.println(id);
        commentRepository.deleteById(id);
        return "comment and its reply deleted";
    }
}
