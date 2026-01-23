package com.example.Concesionaria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveOperationResponse {

    private UUID id;

    private SellerResponse sellersResponse;

    private VehicleResponse vehicleResponse;
}
