package com.example.neven.firebaseintegrationapp.models;

/**
 * Created by Neven on 26.5.2017..
 */
public class User {


    private String email;
    private String password;

    public User() {

    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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
}
