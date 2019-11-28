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



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getOne(@PathVariable String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable String id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        user.setName(updatedUser.getFirstName());
        user.setName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        userRepository.delete(user);
    }

    @GetMapping("/searchByEmail")
    public User searchByEmail(@RequestParam(name = "email") String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException());

    }
    

    
    @GetMapping("/searchByName")
    public List<User> searchByName(@RequestParam(name = "firstName") String firstName) {
        List<User> result = new ArrayList<>();
        
        result = userRepository.findBygfirstName(firstName);
        
        return result;
    }
    
    
    
//    public User searchByName(User user) {
//    	Query query = new Query();
//    	query.addCriteria
//       }
      

    

}