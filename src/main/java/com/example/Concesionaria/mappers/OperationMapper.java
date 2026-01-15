package com.example.Concesionaria.mappers;

import com.example.Concesionaria.dtos.responses.SaveOperationResponse;
import com.example.Concesionaria.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    public SaveOperationResponse toSaveOperationReponse (Operation operation) {
        return SaveOperationResponse.builder()
                .id(operation.getId())
                .sellersResponse(sellerMapper.toSellerResponse(operation.getSeller()))
                .vehicleResponse(vehicleMapper.toVehicleResponse(operation.getVehicle()))
                .build();
    }
}
