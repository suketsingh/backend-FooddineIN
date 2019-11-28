package com.mynotes.spring.data.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
public class Restaurant {

    @Id
    private String id;
    
    
    private String name;
    
    private String contactInfo;
   
    @Indexed(unique = true)
    private String email;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContact() {
    	return contactInfo;
    }
    public void setContact(String contactInfo) {
    	this.contactInfo = contactInfo;
    }

}