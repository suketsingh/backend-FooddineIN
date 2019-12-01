package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface OrdersRepository extends MongoRepository<Orders, String> {

    Optional<Orders> findByEmail(String userEmail);
    //List<User> findByfirstName(String firstName);


    

}
