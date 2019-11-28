package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
	Optional<Restaurant> findByEmail(String email);
    //List<Restaurant> findByname(String name);
}
