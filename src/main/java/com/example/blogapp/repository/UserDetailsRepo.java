package com.example.blogapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.blogapp.models.UserDetailsEntity;
@Repository
public interface UserDetailsRepo extends MongoRepository<UserDetailsEntity,String>{
  

    UserDetailsEntity findByEmail(String email);
    
} 
