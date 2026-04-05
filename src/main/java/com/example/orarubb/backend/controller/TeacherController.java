package com.example.orarubb.backend.controller;

import com.example.orarubb.backend.dto.TeacherResponse;
import com.example.orarubb.backend.service.TeacherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{language}")
    public List<TeacherResponse> getTeachersByLanguage(@PathVariable("language") String language) {
        List<TeacherResponse> teachers = teacherService.getTeachersWithLocalizedNames(language);
        log.debug("Returning {} teachers for language {}", teachers.size(), language);
        return teachers;
    }

    @GetMapping("/id/{teacher_id}/{language}")
    public TeacherResponse getTeacherById(@PathVariable("teacher_id") UUID teacherId, @PathVariable("language") String language) {
        return teacherService.getTeacherWithLocalizedNameById(teacherId, language);
    }

    @GetMapping("/code/{teacher_code_name}/{language}")
    public TeacherResponse getTeacherByCodeName(@PathVariable("teacher_code_name") String codeName, @PathVariable("language") String language) {
        return teacherService.getTeacherWithLocalizedNameByCodeName(codeName, language);
    }

}
