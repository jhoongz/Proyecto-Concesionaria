package com.example.Concesionaria.services;

import com.example.Concesionaria.SellerRepository;
import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.models.Seller;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public void addNewSeller(NewSellerRequest request) {

        Seller newSeller = Seller.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
        newSeller = sellerRepository.save(newSeller);
        System.out.println("New Seller: " + newSeller.getId());

    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public List<Seller> getSellersById(Long id) {
        List<Seller> sellerList = List.of(
                Seller.builder()
                        .firstName("Juan")
                        .lastName("Gomez")
                        .email("juan.gomez@nuevo.com")
                        .phone(1123659865L)
                        .build(),
                Seller.builder()
                        .firstName("Ana")
                        .lastName("Lopez")
                        .email("ana.lopez@ejemplo.com")
                        .phone(1167894321L)
                        .build()
        );
        sellerRepository.saveAll(sellerList);
        System.out.println("All Sellers has been save: " + sellerList.size());
        return sellerList;
    }

    @PostConstruct
    public void initializeSellers() {
        if (sellerRepository.count() == 0) {
            getSellersById(1L);
            System.out.println("Default sellers inserted automatically.");
        }
    }
}
