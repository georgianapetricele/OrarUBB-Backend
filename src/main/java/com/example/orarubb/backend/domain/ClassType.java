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
public class ClassType {
    @Id
    @Column(name = "class_type_id")
    private int classTypeId;

    @Column(name = "name", nullable = false)
    private String name;
}
