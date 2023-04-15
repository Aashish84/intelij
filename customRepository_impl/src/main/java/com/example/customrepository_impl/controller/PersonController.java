package com.example.customrepository_impl.controller;

import com.example.customrepository_impl.entity.Person;
import com.example.customrepository_impl.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PersonController {
    private final PersonService personService;
    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(personService.allPerson());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Person person){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.save(person));
    }
}
