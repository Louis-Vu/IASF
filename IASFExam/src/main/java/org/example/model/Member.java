package org.example.model;


import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    private String userId;
    private String password;
    private boolean isActive;

    public void isActive() {
    }

    public String getUserId() {
        return null;
    }

    public void getPassword() {

    }

    public void setPassword(String encode) {
    }

    public void setActive(boolean b) {

    }

    // Getters and Setters
}
