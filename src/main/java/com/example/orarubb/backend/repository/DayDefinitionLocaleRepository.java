package com.example.orarubb.backend.repository;

import com.example.orarubb.backend.domain.DayDefinitionLocale;
import com.example.orarubb.backend.domain.DayDefinitionLocalePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayDefinitionLocaleRepository extends JpaRepository<DayDefinitionLocale, DayDefinitionLocalePK> {

    // Custom query to find by dayId and languageTag
    public DayDefinitionLocale findByDayIdAndLanguageTag(int dayId, String languageTag);

    // Custom query to find all locales by dayId
    List<DayDefinitionLocale> findAllByDayId(int dayId);

    @Query("SELECT d.dayNameLocale FROM DayDefinitionLocale d WHERE d.languageTag = :language")
    List<String> findClassDaysByLanguage(@Param("language") String language);
}
