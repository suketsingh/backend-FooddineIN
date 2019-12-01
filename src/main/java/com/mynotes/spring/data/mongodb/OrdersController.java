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
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Orders add(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @GetMapping
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Orders getOne(@PathVariable String id) {
        return ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PutMapping(value = "/{id}")
    public Orders update(@PathVariable String id, @RequestBody Orders updatedOrders) {
        Orders order = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        order.setdatetime(updatedOrders.getdatetime());
        order.setparkingSlot(updatedOrders.getparkingSlot());
        order.setpreorder(updatedOrders.getpreorder());
        order.setrestaurantName(updatedOrders.getrestaurantName());
        order.setuserEmail(updatedOrders.getuserEmail());
        
        return ordersRepository.save(order);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Orders order = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        ordersRepository.delete(order);
    }

    @GetMapping("/searchByEmail")
    public Orders searchByEmail(@RequestParam(name = "email") String email) {
        return ordersRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException());

    }
    

    
//    @GetMapping("/searchByName")
//    public List<User> searchByName(@RequestParam(name = "firstName") String firstName) {
//        List<User> result = new ArrayList<>();
//        
//        result = userRepository.findByfirstName(firstName);
//        
//        return result;
//    }
    
    
    
//    public User searchByName(User user) {
//    	Query query = new Query();
//    	query.addCriteria
//       }
      

    

}