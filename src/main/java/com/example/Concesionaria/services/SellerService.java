package com.example.Concesionaria.services;

import com.example.Concesionaria.repositories.SellerRepository;
import com.example.Concesionaria.clients.RandomUserClient;
import com.example.Concesionaria.dtos.requests.PatchSellerRequest;
import com.example.Concesionaria.dtos.requests.NewSellerRequest;
import com.example.Concesionaria.dtos.requests.UpdateSellerRequest;
import com.example.Concesionaria.dtos.responses.GetRandomUserResponse;
import com.example.Concesionaria.mappers.SellerMapper;
import com.example.Concesionaria.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private RandomUserClient randomUserClient;

    @Autowired
    private SellerMapper sellerMapper;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    public Seller addNewSeller(NewSellerRequest request) {
        Seller newSeller = sellerMapper.toSeller(request);
        newSeller = sellerRepository.save(newSeller);
        return newSeller;
    }

    public Seller updateSellerById(Long id, UpdateSellerRequest request) {
        Seller seller = sellerRepository.findById(id).get();
        return sellerRepository.save(seller);
    }

    public Seller patchSellerById(Long id, PatchSellerRequest request) {
        Seller seller = sellerRepository.findById(id).get();
        sellerMapper.patchRequestToSeller(seller, request);
        return sellerRepository.save(seller);
    }

    public List<Seller> deleteAllSellers() {
        sellerRepository.deleteAll();
        return sellerRepository.findAll();
    }

    public Optional<Seller> deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
        return sellerRepository.findById(id);
    }

    public List<Seller> importSellers(Long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        GetRandomUserResponse randomUserResponse = randomUserClient.getRandomUsersByQuantity(value);

        // 1) llamar al cliente para obtener los usuarios aleatorios

        if (randomUserResponse == null || randomUserResponse.getResults() == null) {
            throw new RuntimeException("No se pudieron obtener usuarios aleatorios desde la API.");
        }

        // 2) mapear los usuarios aleatorios a entidades Seller

        List<Seller> sellers = randomUserResponse.getResults().stream()
                .map(randomUser -> Seller.builder()
                        .firstName(randomUser.getName().getFirst())
                        .lastName(randomUser.getName().getLast())
                        .email(randomUser.getEmail().getEmail())
                        .phone(Long.parseLong(randomUser.getPhone().getPhone().
                                replaceAll("[^0-9]", "")))
                        .build())
                .toList();

        // 3) guardar las entidades Seller en la base de datos

        sellers.forEach(seller -> {

            sellerRepository.save(seller);
        });

        return sellers;
    }
}
