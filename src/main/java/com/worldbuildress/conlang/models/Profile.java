package com.worldbuildress.conlang.models;

public class Profile {

    private int id;
    public static int nextId = 1;
    private String username;
    private String email;
    private String password;

    public Profile(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id =nextId;
        nextId++;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }
}
