package com.example.orarubb.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orarubb.backend.SupportedLanguages;
import com.example.orarubb.backend.dto.CourseInstanceResponse;
import com.example.orarubb.backend.service.CourseInstanceService;

@RestController
@RequestMapping("/course-instances")
public class CourseInstanceController {
    private final CourseInstanceService courseInstanceService;

    private static final java.util.Set<String> VALID_LANGUAGES = SupportedLanguages.ALL;

    public CourseInstanceController(CourseInstanceService courseInstanceService) {
        this.courseInstanceService = courseInstanceService;
    }

    @GetMapping("/{language}")
    public ResponseEntity<List<CourseInstanceResponse>> getAllCourseInstancesWithCodeAndLocalizedName(@PathVariable("language") String language) {

        if (VALID_LANGUAGES.contains(language)) {
            List<CourseInstanceResponse> classes = courseInstanceService.getAllCourseInstancesWithCodeAndLocalizedName(language);
            return ResponseEntity.ok(classes);
        }

        return ResponseEntity.badRequest().build();
    }

}
