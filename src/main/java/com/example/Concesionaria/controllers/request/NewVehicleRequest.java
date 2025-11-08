package com.example.Concesionaria.controllers.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewVehicleRequest {

    @NotNull
    @NotBlank
    private String brand;

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private String colour;

    @NotNull
    @NotBlank
    private Double price;

    @NotNull
    @NotBlank
    private Integer yearV;
}
