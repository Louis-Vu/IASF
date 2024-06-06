package com.example.apfastspringboot.repository;


import com.example.apfastspringboot.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
