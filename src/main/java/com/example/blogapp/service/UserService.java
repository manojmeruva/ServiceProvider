package com.example.blogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.blogapp.data.UserEntity;
import com.example.blogapp.repository.UserRepository;

@Service
public class UserService {
     
    @Autowired
    public UserRepository userRepository;

     @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserEntity registerUser(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        return userRepository.save(user);
    }

    public UserEntity loginUser(String username, String password) {


        UserEntity user = userRepository.findByUsername(username);


        if(user == null) throw new RuntimeException("User not found");

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
