package com.example.Concesionaria.services;

import com.example.Concesionaria.SellerRepository;
import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.controllers.requests.UpdateSellerRequest;
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

    public Seller updateSellerById(Long id, UpdateSellerRequest request) {
        Seller updateSeller = sellerRepository.findById(id).get();
        updateSeller.setFirstName(request.getFirstName());
        updateSeller.setLastName(request.getLastName());
        updateSeller.setEmail(request.getEmail());
        updateSeller.setPhone(request.getPhone());
        return sellerRepository.save(updateSeller);
    }

    public Seller fixSellerById(Long id, UpdateSellerRequest request) {
        Seller fixSeller = sellerRepository.findById(id).get();
        if (request.getFirstName() != null) {
            fixSeller.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            fixSeller.setLastName(request.getLastName());
        }
        if (request.getEmail() != null) {
            fixSeller.setEmail(request.getEmail());
        }
        if (request.getPhone() != null) {
            fixSeller.setPhone(request.getPhone());
        }
        return sellerRepository.save(fixSeller);
    }

    public List<Seller> deleteAllSellers() {
        sellerRepository.deleteAll();
        return sellerRepository.findAll();
    }

    public Optional<Seller> deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
        return sellerRepository.findById(id);
    }
}
