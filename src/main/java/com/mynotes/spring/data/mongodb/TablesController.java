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
@RequestMapping("/restaurant/tables")
public class TablesController {

    @Autowired
    private TablesRepository tablesRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tables add(@RequestBody Tables table) {
        return tablesRepository.save(table);
    }

    @GetMapping
    public List<Tables> getAll() {
        return tablesRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Tables getOne(@PathVariable String id) {
        return tablesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PutMapping(value = "/{id}")
    public Tables update(@PathVariable String id, @RequestBody Tables updatedTables) {
        Tables table = tablesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        table.setdatetime(updatedTables.getdatetime());
        table.setemail(updatedTables.getemail());
        table.setTableName(updatedTables.getTableName());
        table.settableX(updatedTables.gettableX());
        table.settableY(updatedTables.gettableY());
        
        return tablesRepository.save(table);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Tables table = tablesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        tablesRepository.delete(table);
    }

    @GetMapping("/searchByEmail")
    public Tables searchByEmail(@RequestParam(name = "email") String email) {
        return tablesRepository.findByEmail(email)
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