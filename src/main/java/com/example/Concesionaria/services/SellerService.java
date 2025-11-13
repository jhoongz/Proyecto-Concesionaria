package com.example.Concesionaria.services;

import com.example.Concesionaria.SellerRepository;
import com.example.Concesionaria.clients.RandomUserClient;
import com.example.Concesionaria.controllers.requests.PatchSellerRequest;
import com.example.Concesionaria.controllers.requests.NewSellerRequest;
import com.example.Concesionaria.controllers.requests.UpdateSellerRequest;
import com.example.Concesionaria.dtos.GetRandomUserResponse;
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

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

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

    public Seller updateSellerById(Long id, UpdateSellerRequest request) {
        Seller updateSeller = sellerRepository.findById(id).get();
        updateSeller.setFirstName(request.getFirstName());
        updateSeller.setLastName(request.getLastName());
        updateSeller.setEmail(request.getEmail());
        updateSeller.setPhone(request.getPhone());
        return sellerRepository.save(updateSeller);
    }

    public Seller patchSellerById(Long id, PatchSellerRequest request) {
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
