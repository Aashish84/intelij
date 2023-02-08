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
    public Long id;
    public String title;
    public String description;
    @CreationTimestamp
    public Timestamp createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Comment> comments;

    @ManyToOne
    @JoinColumn(nullable = false)
    public User user;
}
