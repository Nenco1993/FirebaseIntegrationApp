package com.example.neven.firebaseintegrationapp.models;

/**
 * Created by Neven on 26.5.2017..
 */
public class User {


    public String email;
    public String password;

    public User() {

    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
