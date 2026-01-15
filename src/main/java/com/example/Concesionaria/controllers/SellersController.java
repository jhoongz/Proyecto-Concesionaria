package com.example.Concesionaria.controllers;

import com.example.Concesionaria.dtos.requests.PatchSellerRequest;
import com.example.Concesionaria.dtos.requests.NewSellerRequest;
import com.example.Concesionaria.dtos.requests.UpdateSellerRequest;
import com.example.Concesionaria.dtos.responses.*;
import com.example.Concesionaria.mappers.SellerMapper;
import com.example.Concesionaria.models.Seller;
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

public class SellersController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerMapper sellerMapper;

    // ----------------------------------------
    // ------------- Historia 2 ---------------
    // ----------------------------------------

    @GetMapping()
    public ResponseEntity<List<Seller>> getAllSellers() {
        return new ResponseEntity<>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerResponse> getSellersById(@PathVariable Long id) {
        return new ResponseEntity<>(sellerMapper.toSellerResponse(sellerService.getSellerById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SaveSellerResponse> addSeller(@Valid @RequestBody NewSellerRequest request){
        Seller newSeller = sellerService.addNewSeller(request);
        return new ResponseEntity<>(sellerMapper.toSaveSellerResponse(newSeller), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSellerByIdResponse> updateSellerById(@PathVariable Long id, @RequestBody UpdateSellerRequest request) {
        Seller updateSeller = sellerService.updateSellerById(id, request);
        return new ResponseEntity<>(sellerMapper.toUpdateSellerByIdResponse(updateSeller), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchSellerByIdResponse> patchSellerById(@PathVariable Long id, @RequestBody PatchSellerRequest request) {
        Seller patchSeller = sellerService.patchSellerById(id, request);
        return new ResponseEntity<>(sellerMapper.toPatchSellerByIdResponse(patchSeller), HttpStatus.OK);
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
    public ResponseEntity<SellersResponse> importSellers(@PathVariable Long value){
        List<Seller> imported = sellerService.importSellers(value);
        return new ResponseEntity<>(sellerMapper.toImportSellerResponse(imported), HttpStatus.CREATED);
    }
}
