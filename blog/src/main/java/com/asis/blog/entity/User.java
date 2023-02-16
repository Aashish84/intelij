package com.asis.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Role> roles;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<Blog> blogs;
}
