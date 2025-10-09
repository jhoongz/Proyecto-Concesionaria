package com.example.Concesionaria.controllers;

import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.controllers.requests.SellerRequest;
import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Seller> addSeller(@Valid @RequestBody NewSellerRequest request){
        Seller newSeller = sellerService.addNewSeller(request);
        return new ResponseEntity<>(newSeller, HttpStatus.CREATED);
    }

    @GetMapping("/sellers")
    public ResponseEntity<List<Seller>> getAllSellers() {
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping("/sellers/{id}")
    public ResponseEntity<Optional<Seller>> getSellersById(@PathVariable Long id) {
        return new ResponseEntity<>(sellerService.getSellerById(id), HttpStatus.OK);
    }

    @PutMapping("/sellers/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody SellerRequest request) {
        return new ResponseEntity<>(sellerService.updateSeller(id, request), HttpStatus.OK);
    }


}
