package com.example.Concesionaria.controllers;

import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")

public class SellersControllers {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/sellers")
    public void addSeller(@Valid @RequestBody NewSellerRequest request) {
        sellerService.addNewSeller(request);
    }

    @GetMapping("/sellers")
    public ResponseEntity<List<Seller>> getAllSellers() {
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/sellers/{id}")
    public ResponseEntity<Optional<Seller>> getSellersById(@PathVariable Long id) {
        return new ResponseEntity<>(sellerService.getSellerById(id), HttpStatusCode.valueOf(200));
    }
}
