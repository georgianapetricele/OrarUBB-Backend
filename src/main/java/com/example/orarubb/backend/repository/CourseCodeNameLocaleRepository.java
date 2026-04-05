package com.example.orarubb.backend.repository;

import com.example.orarubb.backend.domain.CourseCodeNameLocale;
import com.example.orarubb.backend.domain.CourseCodeNameLocalePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseCodeNameLocaleRepository extends JpaRepository<CourseCodeNameLocale, CourseCodeNameLocalePK> {

    // Custom query to find a localized course name by courseCodeNameId and languageTag
    Optional<CourseCodeNameLocale> findByCourseCodeNameIdAndLanguageTag(int courseCodeNameId, String languageTag);

    // Custom query to find all locales for a specific courseCodeNameId
    List<CourseCodeNameLocale> findAllByCourseCodeNameId(int courseCodeNameId);
}
