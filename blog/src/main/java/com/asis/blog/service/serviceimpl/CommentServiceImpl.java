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

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;
    private final CommentMapper commentMapper = CommentMapper.INSTANCE;

    public CommentServiceImpl(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    private Map<Long , List<Long>> map = new HashMap<>();

    public void test(List<Comment> comments , Long parentId){
        for(int i = 0 ; i < comments.size() ; i++){
            Comment comment = comments.get(i);
            test(comment.getComments() , parentId);
            List<Long> longs = map.get(parentId);
            longs.add(comment.getId());
            map.put(parentId , longs);
        }
    }

    @Override
    public List<CommentDto> getAllComment() {
        List<Comment> allComment = commentRepository.findAll();

        for(int i = 0 ; i < allComment.size() ; i++){
            Long parentId = allComment.get(i).getId();
            map.put(parentId , new ArrayList<>());
            test(allComment.get(i).getComments() , parentId);
        }

//        sorting map on the basis of size map value list
        List<Map.Entry<Long,List<Long>>> mapList = new LinkedList<>(map.entrySet());
        Collections.sort(mapList , new Comparator<Map.Entry<Long, List<Long>>>() {
            @Override
            public int compare(Map.Entry<Long, List<Long>> o1, Map.Entry<Long, List<Long>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        map = new LinkedHashMap<>();
        for(Map.Entry<Long , List<Long>> tmp : mapList){
            map.put(tmp.getKey() , tmp.getValue());
        }
//        sorting complete
        for(Map.Entry<Long , List<Long>> entry : map.entrySet()){
            for(Long id : entry.getValue()){
                for(int i = 0 ; i < allComment.size() ; i++){
                    Long commentId = allComment.get(i).getId();
                    if(id == commentId){
                        allComment.remove(i);
                    }
                }
            }
        }
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
        Comment commentParent = commentRepository.findCommentParent(id);

        if (commentParent != null) {
//        comments after deleting child
            commentParent.setComments(removeFromList(id , commentParent.getComments()));
            commentRepository.save(commentParent);
            commentRepository.deleteById(id);
            return "comment deleted from parent of id : "+id;
        }
        commentRepository.deleteById(id);
        return "comment of id : "+id+" deleted";
    }

    @Override
    public String deleteCommentFromBlog(Long id) {
        Blog blogParent = blogRepository.findCommentParent(id);

        if(blogParent != null){
           blogParent.setComments(removeFromList(id , blogParent.getComments()));
            blogRepository.save(blogParent);
            blogRepository.deleteById(id);
            return "comment deleted from parent of id : "+id;
        }

        commentRepository.deleteById(id);
        return "comment of id : "+id+" deleted";
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

    private List<Comment> removeFromList(Long id , List<Comment> comments){
        for (int i = 0 ; i < comments.size() ; i++){
            if(comments.get(i).getId() == id){
                comments.remove(i);
            }
        }
        return comments;
    }


}
