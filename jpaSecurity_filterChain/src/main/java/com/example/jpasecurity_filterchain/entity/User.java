package com.example.jpasecurity_filterchain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
}
