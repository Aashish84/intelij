package com.example.server01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String userName;
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Role> roles;
}
