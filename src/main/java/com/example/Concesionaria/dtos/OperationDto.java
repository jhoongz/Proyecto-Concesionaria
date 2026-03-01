package com.example.Concesionaria.dtos;

import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDto {

    private UUID id;

    private Seller seller;

    private Vehicle vehicle;
}
