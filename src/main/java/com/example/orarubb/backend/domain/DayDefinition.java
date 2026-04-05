package com.example.orarubb.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayDefinition {

    @Id
    @Column(name = "day_definition_id")
    private int dayId;

    @Column(name = "day_name", nullable = false)
    private String dayName; 
}
