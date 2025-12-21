package com.example.Concesionaria.dtos.responses;

import com.example.Concesionaria.models.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveSellerResponse {
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;

    private List<Operation> operations;
}
