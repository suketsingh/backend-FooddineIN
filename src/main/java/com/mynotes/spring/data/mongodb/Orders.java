package com.mynotes.spring.data.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Orders {

    @Id
    private String id;
    
    private String datetime;
    
    private String parkingSlot;
    
    private String restaurantName;
    
    private String tablename;
    
    private String [] preOrder; 
    
   
//    @Indexed(unique = true)
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getdatetime() {
        return datetime;
    }

    public void setdatetime(String datetime) {
        this.datetime = datetime;
    }

   
    public String getparkingSlot() {
        return parkingSlot;
    }

    public void setparkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public String getrestaurantName() {
        return restaurantName;
    }

    public void setrestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    
    public String getTableName() {
        return tablename;
    }

    public void setTableName(String tablename) {
        this.tablename = tablename;
    }
    
    public String[] getpreorder() {
        return preOrder;
    }

    public void setpreorder(String[] preOrder) {
        this.preOrder = preOrder;
    }

}
