package com.example.demo_jpa_relation.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_auth_role")
    private List<Role> roles;
}
