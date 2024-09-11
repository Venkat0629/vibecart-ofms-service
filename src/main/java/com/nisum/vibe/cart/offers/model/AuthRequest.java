package com.nisum.vibe.cart.offers.model;

public class AuthRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public AuthRequest setUserName(String userName) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}