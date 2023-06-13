package com.example.demo_jpa_relation.onetomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String studentName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private List<Course> courses;
}