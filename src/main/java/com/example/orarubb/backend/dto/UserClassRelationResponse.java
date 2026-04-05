package com.example.orarubb.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserClassRelationResponse {
    private ClassInstanceResponse courseInstance;
    private String username;
}
