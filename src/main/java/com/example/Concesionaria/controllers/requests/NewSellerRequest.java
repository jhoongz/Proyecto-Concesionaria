package com.example.Concesionaria.controllers.requests;

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
public class NewSellerRequest {

    @NotNull
    @NotBlank(message = "El nombre no puede estar vacio")
    private String firstName;

    @NotNull
    @NotBlank(message = "El apellido no puede estar vacio")
    private String lastName;

    @NotNull
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato valido")
    private String email;

    @NotNull(message = "El telefono es obligatorio")
    @Min(value = 1000000000, message = "El telefono debe tener al menos 10 digitos")
    private Long phone;
}
