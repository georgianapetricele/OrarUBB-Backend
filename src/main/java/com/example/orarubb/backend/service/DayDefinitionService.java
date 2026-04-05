package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.DayDefinition;
import com.example.orarubb.backend.repository.DayDefinitionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DayDefinitionService {
    private final DayDefinitionRepository dayDefinitionRepository;

    public DayDefinitionService(DayDefinitionRepository dayDefinitionRepository) {
        this.dayDefinitionRepository = dayDefinitionRepository;
    }

    public Optional<DayDefinition> getDayDefinitionByName(String dayName) {
        return dayDefinitionRepository.findByDayName(dayName);
    }
}
