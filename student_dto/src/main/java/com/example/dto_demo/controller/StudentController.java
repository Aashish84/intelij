package com.example.dto_demo.controller;

import com.example.dto_demo.dto.StudentDto;
import com.example.dto_demo.entity.Student;
import com.example.dto_demo.service.StudentService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents() , HttpStatus.OK);
    }

    @PostMapping("/add-dto")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>( studentService.saveStudent(studentDto), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

//    @GetMapping("/get-withoutnow")
//    public ResponseEntity<?> getStudentsWithoutNow(){
//        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("now");
//        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("studentDtoFilter" , simpleBeanPropertyFilter);
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(studentService.getStudents());
//        mappingJacksonValue.setFilters(filterProvider);
//
//        return new ResponseEntity<>(mappingJacksonValue , HttpStatus.OK);
//    }
}
