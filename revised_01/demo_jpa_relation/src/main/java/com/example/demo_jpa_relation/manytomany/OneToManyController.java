package com.example.demo_jpa_relation.manytomany;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OneToManyController {
    private final UserRepo userRepo;
    @GetMapping("/user")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userRepo.findAll());
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUsers(@RequestBody User user){
        return ResponseEntity.ok(userRepo.save(user));
    }
}
