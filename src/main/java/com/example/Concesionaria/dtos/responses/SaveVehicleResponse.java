package com.example.Concesionaria.dtos.responses;

import com.example.Concesionaria.models.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveVehicleResponse {
    private Long id;

    private String brand;
    private String model;
    private String colour;
    private Double price;
    private Integer yearV;

    private Operation operations;
}
