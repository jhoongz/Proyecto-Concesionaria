package com.example.Concesionaria.controllers.requests;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateVehicleRequest {
    @Id
    @NotNull
    @NotBlank
    private Long id;

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
    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double price;

    @NotNull
    @Min(value = 1980, message = "El año no puede ser menor a 1980")
    @Max(value = 2030, message = "El año no puede ser mayor a 2030")
    private Integer yearV;
}
