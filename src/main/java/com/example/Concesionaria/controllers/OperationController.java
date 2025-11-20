package com.example.Concesionaria.controllers;

// ----------------------------------------
// ------------- Historia 5 ---------------
// ----------------------------------------


import com.example.Concesionaria.controllers.requests.NewOperationRequest;
import com.example.Concesionaria.models.Operation;
import com.example.Concesionaria.services.OperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")

public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping()
    public ResponseEntity<List<Operation>> getAllOperations() {
        return new ResponseEntity<>(operationService.getAllOperations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation> getOperationById(@PathVariable UUID id) {
        return new ResponseEntity<>(operationService.getOperationById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Operation> operationRegister(@Valid @RequestBody NewOperationRequest request) {
        Operation newOperation = operationService.newOperationRegister(request);
        return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }
}
