package com.example.orarubb.backend.domain;

import java.io.Serializable;
import java.util.UUID;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DayDefinitionLocalePK implements Serializable {
    private int dayId;
    private String languageTag;
}