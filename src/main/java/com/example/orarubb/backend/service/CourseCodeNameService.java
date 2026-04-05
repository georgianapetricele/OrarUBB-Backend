package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.CourseCodeName;
import com.example.orarubb.backend.repository.CourseCodeNameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseCodeNameService {
    private final CourseCodeNameRepository courseCodeNameRepository;

    public CourseCodeNameService(CourseCodeNameRepository courseCodeNameRepository) {
        this.courseCodeNameRepository = courseCodeNameRepository;
    }

    public Optional<CourseCodeName> getCourseCodeNameByName(String courseName) {
        return courseCodeNameRepository.findByCourseName(courseName);
    }

    public Optional<CourseCodeName> getCourseCodeNameByAbbreviation(String abbreviation) {
        return courseCodeNameRepository.findByCourseNameAbbreviation(abbreviation);
    }

    public CourseCodeName saveCourseCodeName(CourseCodeName courseCodeName) {
        return courseCodeNameRepository.save(courseCodeName);
    }
}
