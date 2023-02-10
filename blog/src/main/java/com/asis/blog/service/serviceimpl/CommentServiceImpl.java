package com.asis.blog.service.serviceimpl;

import com.asis.blog.dto.BlogDto;
import com.asis.blog.dto.CommentDto;
import com.asis.blog.entity.Blog;
import com.asis.blog.entity.Comment;
import com.asis.blog.exception.CustomException;
import com.asis.blog.helper.ListRemoveHelper;
import com.asis.blog.mapper.CommentMapper;
import com.asis.blog.repository.BlogRepository;
import com.asis.blog.repository.CommentRepository;
import com.asis.blog.service.BlogService;
import com.asis.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BlogService blogService;
   private final CommentMapper commentMapper;
   private final ListRemoveHelper listRemoveHelper;
   private final BlogRepository blogRepository;

    public CommentServiceImpl(CommentRepository commentRepository, BlogService blogService, CommentMapper commentMapper, ListRemoveHelper listRemoveHelper, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogService = blogService;
        this.commentMapper = commentMapper;
        this.listRemoveHelper = listRemoveHelper;
        this.blogRepository = blogRepository;
    }
    @Override
    public List<CommentDto> getAllComment() {
        List<Comment> allComment = commentRepository.findCommentWithoutChild();
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
    public List<CommentDto> addCommentToBlog(Long blogId, CommentDto commentDto) throws CustomException {
        Blog blog = blogService.findBlogById(blogId);
        Comment comment = commentMapper.dtoToEntity(commentDto);
        Comment newComment = commentRepository.save(comment);
        List<Comment> blogComments = blog.getComments();
        blogComments.add(newComment);
        blog.setComments(blogComments);
        BlogDto saveBlogDto = blogService.addBlog(blog);
        return saveBlogDto.getCommentDtos();

    }
    @Override
    public String deleteCommentFromComment(Long id) {
        Comment commentParent = commentRepository.findCommentParent(id);
        System.out.println(commentParent.getId());
        if (commentParent != null) {
//        comments after deleting child
            listRemoveHelper.removeFromList(id, commentParent.getComments());
//            commentParent.setComments(commentList);
            commentRepository.save(commentParent);
        }
        commentRepository.deleteById(id);
        return "comment of id : "+id+" deleted";
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String deleteCommentFromBlog(Long id) throws CustomException {
        boolean isDeletedFromParentBlog = blogService.deleteCommentFromParentBlog(id);
        if(isDeletedFromParentBlog){
        commentRepository.deleteById(id);
        return "comment of id : "+id+" deleted";
        }
        throw new CustomException("could not delete comment from blog of id : "+id);
    }

    @Override
    public CommentDto updateComment(Long id , Comment comment) {
        Optional<Comment> commentById = commentRepository.findById(id);
        if(commentById.isPresent()){
            Comment c = commentById.get();
            comment.setComments(c.getComments());
            comment.setCreatedAt(c.getCreatedAt());
            comment.setId(c.getId());
            comment.setUser(c.getUser());
            Comment newComment = commentRepository.save(comment);
            return commentMapper.entityToDto(newComment);
        }
        return null;
    }

}
