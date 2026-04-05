package com.example.orarubb.backend.service;

import com.example.orarubb.backend.SupportedLanguages;
import com.example.orarubb.backend.domain.UserClassRelation;
import com.example.orarubb.backend.dto.ClassInstanceResponse;
import com.example.orarubb.backend.repository.ClassInstanceRepository;
import com.example.orarubb.backend.repository.UserClassRelationRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserClassRelationService {
    private final UserClassRelationRepository userClassRelationRepository;
    private final ClassInstanceRepository classInstanceRepository;
    private final ClassInstanceService classInstanceService;

    public List<ClassInstanceResponse> getClassesForUser(String username, String language) {
        List<ClassInstanceResponse> results = new ArrayList<>();
        List<UserClassRelation> userClasses = userClassRelationRepository.findByUsername(username);
        for (UserClassRelation userClassRelation : userClasses) {
            List<Object[]> classInstance = classInstanceRepository.findClassInstanceByClassId(userClassRelation.getClassId(), language);
            ClassInstanceResponse classInstanceResponse = classInstanceService.mapObjectsToClassInstanceResponse(classInstance).getLast();
            results.add(classInstanceResponse);

        }
        return results;
    }

    public void mapGroupCoursesToUser(String userId, String groupCode) {
        userClassRelationRepository.removeUserClassRelationByUsername(userId);
        List<ClassInstanceResponse> classes = classInstanceService.getClassesForGroup(groupCode, SupportedLanguages.DEFAULT);
        for (ClassInstanceResponse classInstanceResponse : classes) {
            userClassRelationRepository.addUserClassRelation(userId, classInstanceResponse.getClassId());
        }
    }
}