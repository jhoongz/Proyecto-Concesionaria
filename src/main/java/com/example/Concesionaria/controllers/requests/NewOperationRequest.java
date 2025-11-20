package com.example.Concesionaria.controllers.requests;

import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.models.Vehicle;
import lombok.Data;

@Data
public class NewOperationRequest {

    private Seller seller;

    private Vehicle vehicle;

    public Seller setSeller(Seller seller) {
        return this.seller = seller;
    }

    public Vehicle setVehicle(Vehicle vehicle) {
        return this.vehicle = vehicle;
    }
}
