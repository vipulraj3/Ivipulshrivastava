package com.ivipulshrivastava.backend.repository;

import com.ivipulshrivastava.backend.model.CalculationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for CalculationResult entity
 */
@Repository
public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
    
    List<CalculationResult> findByApplicationType(String applicationType);
    
    List<CalculationResult> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT DISTINCT r.applicationType FROM CalculationResult r ORDER BY r.applicationType")
    List<String> findDistinctApplicationTypes();
    
    @Query("SELECT COUNT(r) FROM CalculationResult r WHERE r.applicationType = ?1")
    Long countByApplicationType(String applicationType);
}