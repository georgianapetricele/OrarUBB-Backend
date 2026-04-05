package com.example.orarubb.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ClassTypeResponse {
    private UUID classTypeId;
    private String classType;
}