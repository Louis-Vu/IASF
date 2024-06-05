package org.example.model;


import jakarta.persistence.*;


@Entity
@IdClass(RoleId.class)
public class Role {

    @Id
    private String userId;

    @Id
    private String role;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private Member member;

    public Role(String userId, String role) {
    }

    public Role() {

    }

    public String getRole() {
        return "";
    }

    // Getters and Setters, equals and hashCode
}

