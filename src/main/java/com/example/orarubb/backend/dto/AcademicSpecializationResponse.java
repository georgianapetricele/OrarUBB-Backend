package com.example.orarubb.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AcademicSpecializationResponse {
    private int academicSpecializationId;
    private String internalName;
    private Set<AcademicSpecializationLocaleResponse> locales;
}
