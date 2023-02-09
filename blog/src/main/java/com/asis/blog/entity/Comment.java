package com.asis.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @CreationTimestamp
    private Timestamp createdAt;
    @OneToOne
    private User user;
    @OneToMany(cascade = CascadeType.REMOVE , orphanRemoval = true)
    @JoinTable(
            name = "reply",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "comments_id")
    )
    private List<Comment> comments;
}
