package com.example.Concesionaria.controllers.requests;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FixSellerRequest {
    @Id
    private Long id;

    private String firstName;
    private String lastName;

    @Email
    private String email;

    @Min(value = 1000000000)
    private Long phone;
}
