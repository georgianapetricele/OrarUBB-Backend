package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.DayDefinitionLocale;
import com.example.orarubb.backend.repository.DayDefinitionLocaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayDefinitionLocaleService {
    private final DayDefinitionLocaleRepository dayDefinitionLocaleRepository;

    public DayDefinitionLocaleService(DayDefinitionLocaleRepository dayDefinitionLocaleRepository) {
        this.dayDefinitionLocaleRepository = dayDefinitionLocaleRepository;
    }

    public DayDefinitionLocale getLocaleByDayIdAndLanguage(int dayId, String languageTag) {
        return dayDefinitionLocaleRepository.findByDayIdAndLanguageTag(dayId, languageTag);
    }

    public List<DayDefinitionLocale> getLocalesByDayId(int dayId) {
        return dayDefinitionLocaleRepository.findAllByDayId(dayId);
    }
}
