package com.example.orarubb.backend.dto;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomAvailability {
    private final String classDay;
    private final JsonNode rooms;
    private final int startHour;
}
