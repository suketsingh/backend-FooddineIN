package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface OrdersRepository extends MongoRepository<Orders, String> {

    List<Orders> findByEmail(String email);
    //List<User> findByfirstName(String firstName);


    

}
