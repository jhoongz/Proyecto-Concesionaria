package com.example.Concesionaria.services;

import com.example.Concesionaria.VehicleRepository;
import com.example.Concesionaria.controllers.requests.NewVehicleRequest;
import com.example.Concesionaria.controllers.requests.PatchVehicleRequest;
import com.example.Concesionaria.controllers.requests.UpdateVehicleRequest;
import com.example.Concesionaria.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclesService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) { return vehicleRepository.findById(id);
    }

    public Vehicle addNewVehicle(NewVehicleRequest request) {

        Vehicle newVehicle = Vehicle.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .price(request.getPrice())
                .colour(request.getColour())
                .yearV(request.getYearV())
                .build();
        newVehicle = vehicleRepository.save(newVehicle);
        System.out.println("New Vehicle: " + newVehicle.getId());

        return newVehicle;
    }

    public Vehicle updateVehicleById(Long id, UpdateVehicleRequest request) {
        Vehicle updateVehicle = vehicleRepository.findById(id).get();
        updateVehicle.setBrand(request.getBrand());
        updateVehicle.setModel(request.getModel());
        updateVehicle.setPrice(request.getPrice());
        updateVehicle.setColour(request.getColour());
        updateVehicle.setYearV(request.getYearV());
        return vehicleRepository.save(updateVehicle);
    }

    public Vehicle fixVehicleById(Long id, PatchVehicleRequest request) {
        Vehicle fixVehicle = vehicleRepository.findById(id).get();
        if (request.getBrand() != null) {
            fixVehicle.setBrand(request.getBrand());
        }
        if (request.getModel() != null) {
            fixVehicle.setModel(request.getModel());
        }
        if (request.getPrice() != null) {
            fixVehicle.setPrice(request.getPrice());
        }
        if (request.getColour() != null) {
            fixVehicle.setColour(request.getColour());
        }
        if (request.getYearV() != null) {
            fixVehicle.setYearV(request.getYearV());
        }
        return vehicleRepository.save(fixVehicle);
    }

    public List<Vehicle> deleteAllVehicles() {
        vehicleRepository.deleteAll();
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
        return vehicleRepository.findById(id);
    }
}
