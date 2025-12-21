package com.example.Concesionaria.mappers;

import com.example.Concesionaria.OperationRepository;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {

    private final OperationRepository operationRepository;

    public OperationMapper(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

}
