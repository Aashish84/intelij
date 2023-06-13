package com.example.demo_jpa_relation.onetomany;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestOneController {
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    @GetMapping("/student")
    public ResponseEntity<?> getStudent(){
        return ResponseEntity.ok(studentRepo.findAll());
    }
    @GetMapping("/course")
    public ResponseEntity<?> getCourse(){
        return ResponseEntity.ok(courseRepo.findAll());
    }
    @PostMapping("/student")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentRepo.save(student));
    }
}
