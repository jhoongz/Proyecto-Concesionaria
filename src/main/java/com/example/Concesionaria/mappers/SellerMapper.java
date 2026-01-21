package com.example.Concesionaria.mappers;

import com.example.Concesionaria.dtos.requests.NewSellerRequest;
import com.example.Concesionaria.dtos.requests.PatchSellerRequest;
import com.example.Concesionaria.dtos.responses.*;
import com.example.Concesionaria.models.Seller;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellerMapper {

    public Seller toSeller(NewSellerRequest request) {
        return Seller.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }

    public SaveSellerResponse toSaveSellerResponse (Seller seller) {
        return SaveSellerResponse.builder()
                .id(seller.getId())
                .firstName(seller.getFirstName())
                .lastName(seller.getLastName())
                .email(seller.getEmail())
                .phone(seller.getPhone())
                .operations(seller.getOperations())
                .build();
    }

    public SellerResponse toSellerResponse(Seller seller) {
        return SellerResponse.builder()
                .firstName(seller.getFirstName())
                .lastName(seller.getLastName())
                .email(seller.getEmail())
                .phone(seller.getPhone())
                .build();
    }

    public UpdateSellerByIdResponse toUpdateSellerByIdResponse(Seller seller) {

        return UpdateSellerByIdResponse.builder()
                .firstName(seller.getFirstName())
                .lastName(seller.getLastName())
                .email(seller.getEmail())
                .phone(seller.getPhone())
                .build();
    }

    public void patchRequestToSeller(Seller seller, PatchSellerRequest request) {
        if (request.getFirstName() != null) {
            seller.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            seller.setLastName(request.getLastName());
        }

        if (request.getEmail() != null) {
            seller.setEmail(request.getEmail());
        }

        if (request.getPhone() != null) {
            seller.setPhone(request.getPhone());
        }
    }

    public PatchSellerByIdResponse toPatchSellerByIdResponse(Seller seller) {
        return PatchSellerByIdResponse.builder()
                .firstName(seller.getFirstName())
                .lastName(seller.getLastName())
                .email(seller.getEmail())
                .phone(seller.getPhone())
                .build();
    }

    public SellersResponse toImportSellerResponse(List<Seller> sellers) {
        return SellersResponse.builder()
                .sellers(sellers.stream().map(seller->{
                    return toSellerResponse(seller);
                }).toList())
                // .sellers(sellers.stream().map(this::toSellerResponse).toList())
                .build();
    }
}