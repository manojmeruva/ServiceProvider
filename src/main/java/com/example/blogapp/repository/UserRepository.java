package com.example.blogapp.repository;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.blogapp.data.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity,String>{

    UserEntity findByUsername(String username);

   


}
