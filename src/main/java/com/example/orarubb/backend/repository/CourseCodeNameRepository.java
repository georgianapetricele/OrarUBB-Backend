package com.example.orarubb.backend.repository;

import com.example.orarubb.backend.domain.CourseCodeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseCodeNameRepository extends JpaRepository<CourseCodeName, Integer> {

    // Custom query to find a CourseCodeName by course_name
    Optional<CourseCodeName> findByCourseName(String courseName);

    // Custom query to find a CourseCodeName by its abbreviation
    Optional<CourseCodeName> findByCourseNameAbbreviation(String courseNameAbbreviation);
}
