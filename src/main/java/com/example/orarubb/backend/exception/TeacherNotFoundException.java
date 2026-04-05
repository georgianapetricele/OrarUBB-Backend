package com.example.orarubb.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String message) {
        super(message);
    }

    public static TeacherNotFoundException byId(UUID teacherId, String languageTag) {
        return new TeacherNotFoundException("Teacher with id " + teacherId + " not found for language " + languageTag);
    }

    public static TeacherNotFoundException byCodeName(String codeName, String languageTag) {
        return new TeacherNotFoundException("Teacher with code name " + codeName + " not found for language " + languageTag);
    }
}
