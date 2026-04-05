package com.example.orarubb.backend.service;

import com.example.orarubb.backend.domain.AcademicRank;
import com.example.orarubb.backend.repository.AcademicRankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicRankService {
    private final AcademicRankRepository academicRankRepository;

    public AcademicRankService(AcademicRankRepository academicRankRepository) {
        this.academicRankRepository = academicRankRepository;
        this.academicRankRepository.save(new AcademicRank(1, "Profesor"));
        this.academicRankRepository.save(new AcademicRank(2, "Conferentiar Universitar"));
    }

    public List<AcademicRank> getAllAcademicRanks() {
        return academicRankRepository.findAll();
    }


}
