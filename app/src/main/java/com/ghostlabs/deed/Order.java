package com.ghostlabs.deed;

/**
 * Created by Hp on 10-07-2016.
 */
public class Order {

    public String username;
    public String email;
    public String address;
    public String items;
    public String organization;


    public Order() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Order(String username, String email, String address, String items, String organization) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.items = items;
        this.organization = organization;
    }
    public String getUsername() {
    return username;
    }
    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return address;
    }
    public String getItems(){
        return items;
    }
    public String getOrganization(){
        return organization;
    }
    }


