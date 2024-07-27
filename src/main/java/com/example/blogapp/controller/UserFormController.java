package com.example.blogapp.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.models.UserDetailsEntity;
import com.example.blogapp.repository.UserDetailsRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/userform")
public class UserFormController {
     
    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @PostMapping("/register")
    public ResponseEntity<UserDetailsEntity> getUserForm(@RequestBody @Valid UserDetailsEntity userDetailsEntity){

        UserDetailsEntity user = userDetailsRepo.save(userDetailsEntity);

        return ResponseEntity.ok(user);

    }
}
