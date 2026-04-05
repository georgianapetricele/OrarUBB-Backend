package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.ClassTypeLocale;
import com.example.orarubb.backend.repository.ClassTypeLocaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassTypeLocaleService {
    private final ClassTypeLocaleRepository classTypeLocaleRepository;

    public ClassTypeLocaleService(ClassTypeLocaleRepository classTypeLocaleRepository) {
        this.classTypeLocaleRepository = classTypeLocaleRepository;
    }

    public Optional<ClassTypeLocale> getClassTypeLocale(int classTypeId, String languageTag) {
        return classTypeLocaleRepository.findByClassTypeIdAndLanguageTag(classTypeId, languageTag);
    }

    public List<ClassTypeLocale> getLocalesByClassTypeId(int classTypeId) {
        return classTypeLocaleRepository.findAllByClassTypeId(classTypeId);
    }
}
