package com.aszqsc.dontforgeteverything.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id_user;
    private String email;
    private String password;
    public User(){
    }
    public User(int id_user, String email, String password){
        this.id_user = id_user;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "id_user=" + id_user +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId_user() {
        return id_user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
