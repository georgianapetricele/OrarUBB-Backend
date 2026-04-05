package com.example.orarubb.backend.repository;

import com.example.orarubb.backend.domain.AcademicRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicRankRepository extends JpaRepository<AcademicRank, Integer> {

    AcademicRank findByAcademicRankId(Integer academicRankId);
}
