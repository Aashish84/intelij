package com.example.server01.controller;

import com.example.server01.entity.Role;
import com.example.server01.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<?> allRole(){
        return new ResponseEntity<>(roleService.allRole() , HttpStatus.OK);
    }

    @PostMapping("/roles")
    public ResponseEntity<?> saveRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.addRole(role) , HttpStatus.CREATED);
    }
}
