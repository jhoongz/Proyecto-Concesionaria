package com.example.Concesionaria.dtos;

import com.example.Concesionaria.dtos.responses.GetRandomUserResponseEmail;
import com.example.Concesionaria.dtos.responses.GetRandomUserResponseName;
import com.example.Concesionaria.dtos.responses.GetRandomUserResponsePhone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomApiUser {
    private GetRandomUserResponseName name;
    private GetRandomUserResponseEmail email;
    private GetRandomUserResponsePhone phone;
}
