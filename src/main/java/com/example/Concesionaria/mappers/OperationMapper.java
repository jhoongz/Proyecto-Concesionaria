package com.example.Concesionaria.mappers;

import com.example.Concesionaria.dtos.responses.OperationResponse;
import com.example.Concesionaria.dtos.responses.OperationResponseID;
import com.example.Concesionaria.dtos.responses.SaveOperationResponse;
import com.example.Concesionaria.models.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMapper {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    public OperationResponse toOperationResponse(Operation operation) {
        return OperationResponse.builder()
                .id(operation.getId())
                .sellersResponse(sellerMapper.toSellerResponse(operation.getSeller()))
                .vehicleResponse(vehicleMapper.toVehicleResponse(operation.getVehicle()))
                .build();
    }

    // ---------------------------------------------------------------
    // Hice este metodo porque me tiraba un bucle de Listas, le tuve que preguntar a ChatGPT y me dio esto. Funciona.

    public List<OperationResponse> toOperationResponseList(List<Operation> operations) {

        List<OperationResponse> responses = new ArrayList<>();

        for (Operation operation : operations) {
            responses.add(toOperationResponse(operation));
        }

        return responses;
    }

    // Quiero saber si hay una mejor opcion.
    // --------------------------------------------------------------------

    public OperationResponseID toOperationResponseID(Operation operation) {
        return OperationResponseID.builder()
                .id(operation.getId())
                .sellersResponse(sellerMapper.toSellerResponse(operation.getSeller()))
                .vehicleResponse(vehicleMapper.toVehicleResponse(operation.getVehicle()))
                .build();
    }

    public SaveOperationResponse toSaveOperationResponse(Operation operation) {
        return SaveOperationResponse.builder()
                .id(operation.getId())
                .sellersResponse(sellerMapper.toSellerResponse(operation.getSeller()))
                .vehicleResponse(vehicleMapper.toVehicleResponse(operation.getVehicle()))
                .build();
    }
}
