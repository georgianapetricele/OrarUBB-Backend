package com.example.orarubb.backend.repository;

import com.example.orarubb.backend.domain.ClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassTypeRepository extends JpaRepository<ClassType, Integer> {

    // Custom query to find a ClassType by its classType name
    Optional<ClassType> findByName(String name);

    // Optional: Custom query to check if a ClassType exists by its classType name
    boolean existsByName(String name);
}
