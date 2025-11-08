package com.example.Concesionaria.controllers;

import com.example.Concesionaria.controllers.request.NewVehicleRequest;
import com.example.Concesionaria.controllers.request.PatchVehicleRequest;
import com.example.Concesionaria.controllers.request.UpdateVehicleRequest;
import com.example.Concesionaria.models.Vehicle;
import com.example.Concesionaria.services.VehiclesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// ----------------------------------------
// ------------- Historia 4 ---------------
// ----------------------------------------

@RestController
@RequestMapping("/vehicles")

public class VehiclesControllers {

    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping()
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(vehiclesService.getAllVehicles() ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> getVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(vehiclesService.getVehicleById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody NewVehicleRequest request) {
        Vehicle newVehicle = vehiclesService.addNewVehicle(request);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicleById(@PathVariable Long id, @RequestBody UpdateVehicleRequest request) {
        return new ResponseEntity<>(vehiclesService.updateVehicleById(id, request),HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> patchVehicleById(@PathVariable Long id, @RequestBody PatchVehicleRequest request) {
        return new ResponseEntity<>(vehiclesService.fixVehicleById(id, request),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<Vehicle>> deleteAllVehicles() {
     return new ResponseEntity<>(vehiclesService.deleteAllVehicles(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> deleteVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(vehiclesService.deleteVehicleById(id), HttpStatus.OK);
    }
}
