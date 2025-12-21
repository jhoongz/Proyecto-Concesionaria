package com.example.Concesionaria.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSellerByIdResponse {
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
}
