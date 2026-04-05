package com.example.orarubb.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CourseCodeNameResponse {
    private UUID courseCodeNameId;
    private String courseName;
    private String courseNameAbbreviation;
}