package com.example.Concesionaria.controllers;

import com.example.Concesionaria.dtos.requests.NewVehicleRequest;
import com.example.Concesionaria.dtos.requests.PatchVehicleRequest;
import com.example.Concesionaria.dtos.requests.UpdateVehicleRequest;
import com.example.Concesionaria.dtos.responses.GetVehicleByIdResponse;
import com.example.Concesionaria.dtos.responses.PatchVehicleByIdResponse;
import com.example.Concesionaria.dtos.responses.SaveVehicleResponse;
import com.example.Concesionaria.dtos.responses.UpdateVehicleByIdResponse;
import com.example.Concesionaria.mappers.VehicleMapper;
import com.example.Concesionaria.models.Vehicle;
import com.example.Concesionaria.services.VehicleService;
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

public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMapper vehicleMapper;

    @GetMapping()
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles() ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetVehicleByIdResponse> getVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleMapper.toGetSellerByIdResponse(vehicleService.getVehicleById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SaveVehicleResponse> addVehicle(@Valid @RequestBody NewVehicleRequest request) {
        Vehicle newVehicle = vehicleService.addNewVehicle(request);
        return new ResponseEntity<>(vehicleMapper.toSaveVehicleResponse(newVehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateVehicleByIdResponse> updateVehicleById(@PathVariable Long id, @RequestBody UpdateVehicleRequest request) {
        Vehicle updateVehicle = vehicleService.updateVehicleById(id, request);
        return new ResponseEntity<>(vehicleMapper.toUpdateSellerByIdResponse(updateVehicle),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchVehicleByIdResponse> patchVehicleById(@PathVariable Long id, @RequestBody PatchVehicleRequest request) {
        Vehicle patchVehicle = vehicleService.fixVehicleById(id, request);
        return new ResponseEntity<>(vehicleMapper.toPatchVehicleByIdResponse(patchVehicle),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<Vehicle>> deleteAllVehicles() {
     return new ResponseEntity<>(vehicleService.deleteAllVehicles(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Vehicle>> deleteVehicleById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteVehicleById(id), HttpStatus.OK);
    }
}
