package com.example.dto_demo.service;

import com.example.dto_demo.dto.StudentDto;
import com.example.dto_demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
    StudentDto addStudent(Student student);

    StudentDto saveStudent(StudentDto studentDto);
}
