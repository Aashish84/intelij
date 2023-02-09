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
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @CreationTimestamp
    private Timestamp createdAt;

    @OneToMany(cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}
