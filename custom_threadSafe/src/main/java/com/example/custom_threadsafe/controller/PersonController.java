package com.example.custom_threadsafe.controller;

import com.example.custom_threadsafe.repo.PersonRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping
    public ResponseEntity<?> getPerson(){
        return ResponseEntity.ok(personRepo.findDemo("row (\"Temperature\",\"2S3-B962\",\"pelican\"), row(\"analog-input_8\",\"2749\",\"bacnet\")" ));
    }

    @GetMapping("/custom")
    public ResponseEntity<?> custom(){
        personRepo.doSomething();
        return ResponseEntity.ok("custom called");
    }
    @GetMapping("/customThreadSafe")
    public ResponseEntity<?> customThreadSafe(){
        personRepo.doSomethingThreadSafe();
        return ResponseEntity.ok("customThreadSafe called");
    }
}
