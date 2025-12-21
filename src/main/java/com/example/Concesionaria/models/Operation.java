package com.example.Concesionaria.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Operation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public void setSeller(Seller seller) {
    }

    public void setVehicle(Vehicle vehicle) {
    }
}
