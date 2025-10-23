package com.example.Concesionaria.services;

import com.example.Concesionaria.SellerRepository;
import com.example.Concesionaria.clients.SellerApiClient;
import com.example.Concesionaria.models.Seller;
import com.example.Concesionaria.models.SellerApi;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerApiService {

    private SellerApiClient sellerApiClient;
    private SellerRepository sellerRepository;

    public SellerApiService(SellerApiClient sellerApiClient, SellerRepository sellerRepository) {
        this.sellerApiClient = sellerApiClient;
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> importSellers(Long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        List<SellerApi> apiResults = sellerApiClient.fetchSellers(value);

        List<Seller> sellers = apiResults.stream().map(api -> {
            Seller s = new Seller();
            s.setFirstName(api.getFirstName());
            s.setLastName(api.getLastName());
            s.setEmail(api.getEmail());
            // parseo seguro de phone (puede venir con espacios o guiones)
            try {
                String digits = api.getPhone() != null ? api.getPhone().replaceAll("[^0-9]", "") : null;
                s.setPhone(digits != null && !digits.isEmpty() ? Long.valueOf(digits) : null);
            } catch (NumberFormatException e) {
                s.setPhone(null);
            }
            return s;
        }).collect(Collectors.toList());

        return sellerRepository.saveAll(sellers);
    }
}
