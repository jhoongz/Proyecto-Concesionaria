package com.example.Concesionaria.services;

import com.example.Concesionaria.SellerRepository;
import com.example.Concesionaria.clients.RandomUserClient;
import com.example.Concesionaria.dtos.GetRandomUserResponse;
import com.example.Concesionaria.models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomApiService {

    @Autowired
    private RandomUserClient randomUserClient;

    @Autowired
    private SellerRepository sellerRepository;

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