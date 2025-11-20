package com.example.Concesionaria.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Operation {
    @Id
    @GeneratedValue
    private UUID id;

    //@Setter
    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    //@Setter
    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
