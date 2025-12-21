package com.example.Concesionaria.services;

import com.example.Concesionaria.OperationRepository;
import com.example.Concesionaria.dtos.requests.NewOperationRequest;
import com.example.Concesionaria.mappers.OperationMapper;
import com.example.Concesionaria.models.Operation;
import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationMapper operationMapper;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private VehicleService vehicleService;


    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Operation getOperationById(UUID id) {
        return operationRepository.findById(id).orElse(null);
    }

    public Operation newOperationRegister(NewOperationRequest request) {

        Seller seller = sellerService.getSellerById(request.getSeller().getId());
        Vehicle vehicle = vehicleService.getVehicleById(request.getVehicle().getId());

        Operation sale = new Operation();
        sale.setSeller(seller);
        sale.setVehicle(vehicle);

        return operationRepository.save(sale);
    }
}
