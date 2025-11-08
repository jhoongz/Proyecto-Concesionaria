package com.example.Concesionaria.controllers.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatchVehicleRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String colour;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double price;

    @Min(value = 1980, message = "El año no puede ser menor a 1980")
    @Max(value = 2030, message = "El año no puede ser mayor a 2030")
    private Integer yearV;
}
