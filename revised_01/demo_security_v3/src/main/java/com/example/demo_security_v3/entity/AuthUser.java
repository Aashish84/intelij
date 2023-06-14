package com.example.demo_security_v3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Role> roles;
}
