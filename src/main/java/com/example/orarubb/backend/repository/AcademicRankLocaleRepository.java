package com.example.orarubb.backend.repository;

import com.example.orarubb.backend.domain.AcademicRankLocale;
import com.example.orarubb.backend.domain.AcademicRankLocaleKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicRankLocaleRepository extends JpaRepository<AcademicRankLocale, AcademicRankLocaleKey> {
    /*
    AcademicRank_AcademicRankId refers to the academicRankId field in the AcademicRank entity, which is part of the academicRank association in AcademicRankLocale.
    AcademicRankLocaleKey_LanguageTag accesses the languageTag within the embedded AcademicRankLocaleKey field.
     */
    AcademicRankLocale findByAcademicRank_AcademicRankIdAndAcademicRankLocaleKey_LanguageTag(Integer academicRankId, String languageTag);
}
