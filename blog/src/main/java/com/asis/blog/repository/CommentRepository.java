package com.asis.blog.repository;

import com.asis.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Long> {
    @Query(value = "select * from comment where id = (select comment_id from reply where comments_id = ?)" , nativeQuery = true)
    Comment findCommentParent(Long id);

    @Query(value = "select * from comment where id not in (select comments_id from reply)" , nativeQuery = true)
    List<Comment> findCommentWithoutChild();
}
