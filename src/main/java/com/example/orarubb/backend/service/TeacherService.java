package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.Teacher;
import com.example.orarubb.backend.dto.TeacherResponse;
import com.example.orarubb.backend.exception.TeacherNotFoundException;
import com.example.orarubb.backend.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {
    private static final Logger log = LoggerFactory.getLogger(TeacherService.class);

    private final TeacherRepository teacherRepository;
    private final AcademicRankLocaleService academicRankLocaleService;

    public TeacherService(TeacherRepository teacherRepository, AcademicRankLocaleService academicRankLocaleService) {
        this.teacherRepository = teacherRepository;
        this.academicRankLocaleService = academicRankLocaleService;
    }

    public List<Teacher> getTeachersByAcademicRankId(Integer id) {
        return teacherRepository.findByAcademicRank_AcademicRankId(id);
    }

    public List<Teacher> getTeachersByFirstNameAndSurname(String firstName, String surname) {
        return teacherRepository.findByFirstNameIgnoreCaseAndSurnameIgnoreCase(firstName, surname);
    }

    public Optional<Teacher> getTeacherById(UUID id) {
        return teacherRepository.findById(id);
    }

    public List<TeacherResponse> getTeachersWithLocalizedNames(String languageTag) {
        List<TeacherResponse> teachers = new ArrayList<>();
        List<List<String>> teacherNameParts = teacherRepository.getAllTeacherRanks_LocalizedNames_CodeNames(languageTag);

        log.debug("Loaded {} teacher name rows for language {}", teacherNameParts.size(), languageTag);
        for (List<String> teacherNamePart : teacherNameParts) {
            String teacherId = teacherNamePart.get(0);
            String teacherAcademicRank = teacherNamePart.get(1);
            String teacherName = teacherNamePart.get(2);
            String teacherSurname = teacherNamePart.get(3);
            String teacherCodeName = teacherNamePart.get(4);
            teachers.add(new TeacherResponse(UUID.fromString(teacherId), teacherAcademicRank + ' ' + teacherName + ' ' + teacherSurname, teacherCodeName));
        }
        return teachers;
    }

    public TeacherResponse getTeacherWithLocalizedNameByCodeName(String codeName, String languageTag) {
        Teacher teacher = teacherRepository.getTeacherLocalizedByCodeName(codeName, languageTag);
        if (teacher == null) {
            throw TeacherNotFoundException.byCodeName(codeName, languageTag);
        }

        String rankAbbreviationLocaleName = this.academicRankLocaleService
                .getAcademicRankLocalesByAcademicRankId(teacher.getAcademicRank().getAcademicRankId(), languageTag)
                .getAcademicRankAbbreviationLocaleName();
        String teacherNameWithRank = rankAbbreviationLocaleName + " " + teacher.getFirstName() + " " + teacher.getSurname();
        return new TeacherResponse(teacher.getTeacherId(), teacherNameWithRank, teacher.getCodeName());
    }

    public TeacherResponse getTeacherWithLocalizedNameById(UUID teacherId, String languageTag) {
        Teacher teacher = teacherRepository.getTeacherLocalizedById(teacherId, languageTag);
        if (teacher == null) {
            throw TeacherNotFoundException.byId(teacherId, languageTag);
        }

        String rankAbbreviationLocaleName = this.academicRankLocaleService
                .getAcademicRankLocalesByAcademicRankId(teacher.getAcademicRank().getAcademicRankId(), languageTag)
                .getAcademicRankAbbreviationLocaleName();
        String teacherNameWithRank = rankAbbreviationLocaleName + " " + teacher.getFirstName() + " " + teacher.getSurname();
        return new TeacherResponse(teacherId, teacherNameWithRank, teacher.getCodeName());
    }
}
