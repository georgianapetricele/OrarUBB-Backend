package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.CourseInstance;
import com.example.orarubb.backend.dto.CourseInstanceResponse;
import com.example.orarubb.backend.repository.CourseInstanceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {
    private static final Logger log = LoggerFactory.getLogger(CourseInstanceService.class);

    private final CourseInstanceRepository courseInstanceRepository;

    public CourseInstanceService(CourseInstanceRepository courseInstanceRepository) {
        this.courseInstanceRepository = courseInstanceRepository;
    }


    // Method to get a CourseInstance by courseCode
    public Optional<CourseInstance> getCourseInstanceByCourseCode(String courseCode) {
        return courseInstanceRepository.findByCourseCode(courseCode);
    }

    // Method to get a CourseInstance by courseCodeNameId
    public Optional<CourseInstance> getCourseInstanceByCourseCodeNameId(int courseCodeNameId) {
        return courseInstanceRepository.findByCourseCodeName_CourseCodeNameId(courseCodeNameId);
    }

    // Method to get all instances for a given courseCodeNameId
    public List<CourseInstance> getAllInstancesByCourseCodeNameId(int courseCodeNameId) {
        return courseInstanceRepository.findAllByCourseCodeName_CourseCodeNameId(courseCodeNameId);
    }

    public List<CourseInstanceResponse> getCoursesSmallDetailsInSpecifiedLanguage(String language) {
        long startTime = System.nanoTime();
        List<CourseInstance> courseInstances = courseInstanceRepository.findByLanguage(language);

        List<CourseInstanceResponse> responseDTOs = new ArrayList<>();

        for (CourseInstance courseInstance: courseInstances) {
            CourseInstanceResponse responseDTO = new CourseInstanceResponse(
                courseInstance.getCourseInstanceId(),
                courseInstance.getCourseId(),
                courseInstanceRepository.findCourseNameByCourseInstanceIdAndLanguage(courseInstance.getCourseId(), language),
                courseInstanceRepository.findCourseCodeByCourseInstanceIdAndLanguage(courseInstance.getCourseId(), language)
            );

            responseDTOs.add(responseDTO);
        }
        long endTime = System.nanoTime();
        log.debug("getCoursesSmallDetailsInSpecifiedLanguage(language={}) took {} ns", language, (endTime - startTime));

        return responseDTOs;
    }

    public List<CourseInstanceResponse> getAllCourseInstancesWithCodeAndLocalizedName(String language)
    {
        long startTime = System.nanoTime();
        List <CourseInstanceResponse> courseInstances = courseInstanceRepository.getAllCourseInstancesWithCodeAndLocalizedName(language);
        long endTime = System.nanoTime();
        log.debug("getAllCourseInstancesWithCodeAndLocalizedName(language={}) took {} ns", language, (endTime - startTime));
        return courseInstances;
    }
}
 