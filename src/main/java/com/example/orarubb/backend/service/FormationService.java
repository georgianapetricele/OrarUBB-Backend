package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.Formation;
import com.example.orarubb.backend.dto.GroupResponse;
import com.example.orarubb.backend.repository.FormationRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FormationService {
    private final FormationRepository formationRepository;

    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public List<Formation> getAllFormationsForAcademicSpecialization(int academicSpecializationId) {
        return formationRepository.findByAcademicSpecialization_AcademicSpecializationId(academicSpecializationId);
    }

    public GroupResponse getAllGroupsWithAcademicSpecializationIdAndYear(int academicSpecializationId, int year) {
        List<String> formationCodes = formationRepository.getAllGroupsForSpecializationInAYear(academicSpecializationId, year);
        List<String> result = new ArrayList<>(formationCodes);
        
        return new GroupResponse(result);
    }

    public GroupResponse getAllGroupsWithYearCode(String year_code) {
        return new GroupResponse(formationRepository.getAllGroupsWithYearCode(year_code));
    }

    public boolean isYearCode(String code) {
        return this.formationRepository.getYearCode(code).size() == 1;
    }

    public boolean isGroupCode(String code) {
        return this.formationRepository.getGroupCode(code).size() == 1;
    }

    public boolean isSubgroupCode(String code) {
        return this.formationRepository.getSubgroupCode(code).size() == 1;
    }

    public String getYearCodeForGroup(String code) {
        if (isGroupCode(code)) {
            return this.formationRepository.getYearCodeForGroup(code);
        }
        return null;
    }

    public List<String> getComponentsForGroup(String code) {
        if (isGroupCode(code)) {
            List<String> components = new ArrayList<>(Arrays.asList(this.formationRepository.getComponentsForGroup(code).split(";")));
            components.add(code);
            return components;
        }
        return List.of();
    }

    public String getGroupForSubgroup(String code) {
        if (isSubgroupCode(code)) {
            return this.formationRepository.getGroupForSemiGroup(code);
        }
        return null;
    }

    public List<String> getGroupsAndSemigroupsForYear(String yearCode) {
        if (isYearCode(yearCode)) {
            List<String> groupsAndSemiGroups = new ArrayList<>();
            groupsAndSemiGroups.add(yearCode);

            String[] groupsForYear = this.formationRepository.getGroupsForYearCode(yearCode).split(";");

            for (String group : groupsForYear) {
                groupsAndSemiGroups.addAll(this.getComponentsForGroup(group));
            }

            return groupsAndSemiGroups;

        }
        return List.of();
    }
}
