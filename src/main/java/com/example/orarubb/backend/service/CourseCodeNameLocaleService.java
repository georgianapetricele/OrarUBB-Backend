package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.CourseCodeNameLocale;
import com.example.orarubb.backend.repository.CourseCodeNameLocaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseCodeNameLocaleService {
    private final CourseCodeNameLocaleRepository courseCodeNameLocaleRepository;

    public CourseCodeNameLocaleService(CourseCodeNameLocaleRepository courseCodeNameLocaleRepository) {
        this.courseCodeNameLocaleRepository = courseCodeNameLocaleRepository;
    }

    public Optional<CourseCodeNameLocale> getLocalizedCourseName(int courseCodeNameId, String languageTag) {
        return courseCodeNameLocaleRepository.findByCourseCodeNameIdAndLanguageTag(courseCodeNameId, languageTag);
    }

    public List<CourseCodeNameLocale> getAllLocalesForCourse(int courseCodeNameId) {
        return courseCodeNameLocaleRepository.findAllByCourseCodeNameId(courseCodeNameId);
    }
}
