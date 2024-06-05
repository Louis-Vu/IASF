package org.example.model;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vehicleName;
    private String vehicleModel;
    private int yearOfManufacture;
    private String vehicleColor;

    // Getters and Setters
}