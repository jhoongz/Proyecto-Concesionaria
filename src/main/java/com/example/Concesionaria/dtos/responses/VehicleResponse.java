package com.example.Concesionaria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleResponse {
    private String brand;
    private String model;
    private String colour;
    private Double price;
    private Integer yearV;
}
