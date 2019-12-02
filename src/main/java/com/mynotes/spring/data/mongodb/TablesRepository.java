package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface TablesRepository extends MongoRepository<Tables, String> {

    Optional<Tables> findByEmail(String email);
    //List<User> findByfirstName(String firstName);


    

}
