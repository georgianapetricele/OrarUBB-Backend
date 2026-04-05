package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.ClassType;
import com.example.orarubb.backend.repository.ClassTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassTypeService {
    private final ClassTypeRepository classTypeRepository;

    public ClassTypeService(ClassTypeRepository classTypeRepository) {
        this.classTypeRepository = classTypeRepository;
    }

    public Optional<ClassType> getClassTypeByName(String classType) {
        return classTypeRepository.findByClassType(classType);
    }

    public boolean classTypeExists(String classType) {
        return classTypeRepository.existsByClassType(classType);
    }

    public ClassType saveClassType(ClassType classType) {
        return classTypeRepository.save(classType);
    }
}
