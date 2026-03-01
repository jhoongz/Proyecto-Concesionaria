package com.example.Concesionaria.mappers;

import com.example.Concesionaria.repositories.VehicleRepository;
import com.example.Concesionaria.dtos.requests.NewVehicleRequest;
import com.example.Concesionaria.dtos.requests.PatchVehicleRequest;
import com.example.Concesionaria.dtos.requests.UpdateVehicleRequest;
import com.example.Concesionaria.dtos.responses.*;
import com.example.Concesionaria.models.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    private final VehicleRepository vehicleRepository;

    public VehicleMapper(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle toVehicle(NewVehicleRequest request) {
        return Vehicle.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .colour(request.getColour())
                .price(request.getPrice())
                .yearV(request.getYearV())
                .build();
    }

    public SaveVehicleResponse toSaveVehicleResponse (Vehicle vehicle) {
        return SaveVehicleResponse.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .colour(vehicle.getColour())
                .price(vehicle.getPrice())
                .yearV(vehicle.getYearV())
                .operations(vehicle.getOperations())
                .build();
    }

    public VehicleResponse toGetVehicleByIdResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .colour(vehicle.getColour())
                .price(vehicle.getPrice())
                .yearV(vehicle.getYearV())
                .build();
    }

    public VehicleResponse toVehicleResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .colour(vehicle.getColour())
                .price(vehicle.getPrice())
                .yearV(vehicle.getYearV())
                .build();
    }

    public void updateVehicle(Vehicle updateVehicle, UpdateVehicleRequest request) {
        updateVehicle.setBrand(request.getBrand());
        updateVehicle.setModel(request.getModel());
        updateVehicle.setColour(request.getColour());
        updateVehicle.setPrice(request.getPrice());
        updateVehicle.setYearV(request.getYearV());
    }

    public UpdateVehicleByIdResponse toUpdateSellerByIdResponse(Vehicle vehicle) {
        return UpdateVehicleByIdResponse.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .colour(vehicle.getColour())
                .price(vehicle.getPrice())
                .yearV(vehicle.getYearV())
                .build();
    }

    public void fixVehicle(Vehicle fixVehicle, PatchVehicleRequest  request) {
        if (request.getBrand() != null) {
            fixVehicle.setBrand(request.getBrand());
        }
        if (request.getModel() != null) {
            fixVehicle.setModel(request.getModel());
        }
        if (request.getColour() != null) {
            fixVehicle.setColour(request.getColour());
        }
        if (request.getYearV() != null) {
            fixVehicle.setPrice(request.getPrice());
        }
        if (request.getYearV() != null) {
            fixVehicle.setYearV(request.getYearV());
        }
    }

    public PatchVehicleByIdResponse toPatchVehicleByIdResponse(Vehicle vehicle){
        return PatchVehicleByIdResponse.builder()
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .colour(vehicle.getColour())
                .price(vehicle.getPrice())
                .yearV(vehicle.getYearV())
                .build();
    }
}
