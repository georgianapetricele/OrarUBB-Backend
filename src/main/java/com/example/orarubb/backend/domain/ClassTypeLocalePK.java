package com.example.orarubb.backend.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ClassTypeLocalePK implements Serializable {
    private int classTypeId;
    private String languageTag;
}