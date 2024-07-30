package com.example.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogapp.models.UserEntity;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.service.UserService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class BlogControllers {
     
   @Autowired
    private UserService userService;

  

    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody @Validated UserEntity user) {

        UserEntity registeredUser = userService.registerUser(user);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> loginUser(@RequestBody @Valid UserEntity user) {

        UserEntity loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        
        return ResponseEntity.ok(loggedInUser);
    }
    
    
    @GetMapping("/")
    public List<UserEntity> getUsers(){
        return userService.userRepository.findAll();
    }

    
}
