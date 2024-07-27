package com.example.blogapp.repository;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.blogapp.models.UserEntity;
@Repository
public interface UserRepository extends MongoRepository<UserEntity,String>{

    UserEntity findByUsername(String username);

   


}
