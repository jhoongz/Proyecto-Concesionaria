package com.example.Concesionaria.dtos;

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
