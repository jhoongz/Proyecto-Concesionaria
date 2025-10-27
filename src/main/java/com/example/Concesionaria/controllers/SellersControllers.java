package com.example.Concesionaria.controllers;

import com.example.Concesionaria.controllers.requests.FixSellerRequest;
import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.controllers.requests.UpdateSellerRequest;
import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.services.RandomApiService;
import com.example.Concesionaria.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// ----------------------------------------
// ------------- Historia 1 ---------------
// ----------------------------------------

@RestController
@RequestMapping("/employees/sellers")

public class SellersControllers {

    @Autowired
    private SellerService sellerService;
    private RandomApiService randomApiService;

    public SellersControllers(RandomApiService randomApiService) {
        this.randomApiService = randomApiService;
    }

    // ----------------------------------------
    // ------------- Historia 2 ---------------
    // ----------------------------------------

    @PostMapping()
    public ResponseEntity<Seller> addSeller(@Valid @RequestBody NewSellerRequest request){
        Seller newSeller = sellerService.addNewSeller(request);
        return new ResponseEntity<>(newSeller, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Seller>> getAllSellers() {
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Seller>> getSellersById(@PathVariable Long id) {
        return new ResponseEntity<>(sellerService.getSellerById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSellerById(@PathVariable Long id, @RequestBody UpdateSellerRequest request) {
        return new ResponseEntity<>(sellerService.updateSellerById(id, request), HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Seller> fixSellerById(@PathVariable Long id, @RequestBody FixSellerRequest request) {
        return new ResponseEntity<>(sellerService.fixSellerById(id, request), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<List<Seller>> deleteAllSellers(){
        return new ResponseEntity<>(sellerService.deleteAllSellers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Seller>> deleteSellerById(@PathVariable Long id){
        return new ResponseEntity<>(sellerService.deleteSellerById(id), HttpStatus.OK);
    }

    // ----------------------------------------
    // ------------- Historia 3 ---------------
    // ----------------------------------------

    @PostMapping("/import/{value}")
    public ResponseEntity<List<Seller>> importSellers(@PathVariable Long value){
        List<Seller> imported = randomApiService.importSellers(value);
        return new ResponseEntity<>(imported, HttpStatus.CREATED);
    }
}

