package com.example.orarubb.backend.controller;

import com.example.orarubb.backend.domain.AcademicSpecializationLocale;
import com.example.orarubb.backend.dto.AcademicSpecializationLocaleResponse;
import com.example.orarubb.backend.service.AcademicSpecializationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academic-specializations")
public class AcademicSpecializationController {
    private final AcademicSpecializationService academicSpecializationService;

    public AcademicSpecializationController(AcademicSpecializationService academicSpecializationService) {
        this.academicSpecializationService = academicSpecializationService;
    }

    @GetMapping("/{level}/{language}")
    public List<AcademicSpecializationLocaleResponse> getAllAcademicSpecializationsForLevelAndLanguage(@PathVariable String level, @PathVariable String language) {
        return academicSpecializationService.getAllAcademicSpecializationsForLevelAndLanguage(level, language);
    }

    @GetMapping("/{abbreviation}")
    public Integer getIdForAcademicSpecializationAbbreviation(@PathVariable String abbreviation) {
        List<AcademicSpecializationLocale> academicSpecializationLocale = academicSpecializationService.getAcademicSpecializationWithAbbrev(abbreviation);
        return academicSpecializationLocale.getFirst().getAcademicSpecializationId();
    }
}
