package com.example.Concesionaria.dtos.responses;

import com.example.Concesionaria.dtos.OperationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllOperationResponse {
    private List<OperationDto> operations;
}
