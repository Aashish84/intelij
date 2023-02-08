package com.example.dto_demo;

import com.example.dto_demo.entity.Student;
import com.example.dto_demo.repository.StudentRepository;
import com.example.dto_demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest
class DtoDemoApplicationTests {
    //    service test
    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;
    @Test
    public void getStudentsTest(){
        Student student = new Student(1,"asis" , "asis@gmail.com","1234","this is desc");
        List<Student> students = new ArrayList<>();
        students.add(student);

        when(studentRepository.findAll()).thenReturn(students);
        assertEquals(1,studentService.getStudents().size());

    }

}
