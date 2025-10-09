package com.example.Concesionaria.services;

import com.example.Concesionaria.SellerRepository;
import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.controllers.requests.SellerRequest;
import com.example.Concesionaria.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller addNewSeller(NewSellerRequest request) {

        Seller newSeller = Seller.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
        newSeller = sellerRepository.save(newSeller);
        System.out.println("New Seller: " + newSeller.getId());

        return newSeller;
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public Seller updateSeller(Long id, SellerRequest request) {
        Seller updateSeller = sellerRepository.findById(id).get();
        updateSeller.setFirstName(request.getFirstName());
        updateSeller.setLastName(request.getLastName());
        updateSeller.setEmail(request.getEmail());
        updateSeller.setPhone(request.getPhone());
        return sellerRepository.save(updateSeller);
    }
}
