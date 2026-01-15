package com.example.Concesionaria.dtos.requests;

import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.models.Vehicle;
import lombok.Data;

@Data
public class NewOperationRequest {

    private Seller seller;

    private Vehicle vehicle;

}
