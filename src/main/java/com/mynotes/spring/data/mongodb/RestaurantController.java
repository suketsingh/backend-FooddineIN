package com.mynotes.spring.data.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Restaurant add(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Restaurant getOne(@PathVariable String id) {
        return restaurantRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PutMapping(value = "/{id}")
    public Restaurant update(@PathVariable String id, @RequestBody Restaurant updatedRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        restaurant.setName(updatedRestaurant.getName());
        restaurant.setContact(updatedRestaurant.getContact());
        restaurant.setEmail(updatedRestaurant.getEmail());
        return restaurantRepository.save(restaurant);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Restaurant restaurant = restaurantRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        restaurantRepository.delete(restaurant);
    }

    @GetMapping("/searchByEmail")
    public Restaurant searchByEmail(@RequestParam(name = "email") String email) {
        return restaurantRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException());

    }
    

    
//    @GetMapping("/searchByName")
//    public List<Restaurant> searchByName(@RequestParam(name = "name") String name) {
//        List<Restaurant> result = new ArrayList<>();
//        
//        result = restaurantRepository.findByname(name);
//        
//        return result;
//    }
    
    
    
//    public Restaurant searchByName(Restaurant restaurant) {
//    	Query query = new Query();
//    	query.addCriteria
//       }
      

    

}
