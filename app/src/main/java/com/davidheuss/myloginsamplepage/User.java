package com.davidheuss.myloginsamplepage;

import com.firebase.client.Firebase;

/**
 * Created by david on 11.12.2016.
 */

public class User {



    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;


    public User() {
    }

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


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void saveUser() {
        //Add YOUR Firebase Reference URL instead of the following URL
        Firebase myFirebaseRef = new Firebase("https://myloginsamplepage.firebaseio.com/");
        myFirebaseRef = myFirebaseRef.child("users").child(getId());
        myFirebaseRef.setValue(this);
    }

}
