package com.asis.blog.repository;

import com.asis.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "select * from blog where id = (select id from blog_comments where comments_id = ?)" , nativeQuery = true)
    Blog findCommentParent ( Long id);
}
