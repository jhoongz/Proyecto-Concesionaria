package com.example.Concesionaria.controllers.requests;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateSellerRequest {
    @Id
    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @Min(value = 1000000000)
    @NotNull
    @NotBlank
    private Long phone;
}
