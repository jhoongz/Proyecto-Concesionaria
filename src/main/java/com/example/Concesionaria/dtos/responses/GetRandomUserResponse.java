package com.example.Concesionaria.dtos.responses;

import com.example.Concesionaria.dtos.RandomApiUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRandomUserResponse {
    private List<RandomApiUser> results;
}
