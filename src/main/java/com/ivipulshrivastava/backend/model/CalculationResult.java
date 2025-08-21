package com.ivipulshrivastava.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity to store calculation results and execution history
 */
@Entity
@Table(name = "calculation_results")
public class CalculationResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String applicationType;
    
    @Column(columnDefinition = "TEXT")
    private String inputData;
    
    @Column(columnDefinition = "TEXT")
    private String outputData;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    @Column
    private String clientIp;
    
    // Constructors
    public CalculationResult() {
        this.timestamp = LocalDateTime.now();
    }
    
    public CalculationResult(String applicationType, String inputData, String outputData) {
        this();
        this.applicationType = applicationType;
        this.inputData = inputData;
        this.outputData = outputData;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getApplicationType() {
        return applicationType;
    }
    
    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
    
    public String getInputData() {
        return inputData;
    }
    
    public void setInputData(String inputData) {
        this.inputData = inputData;
    }
    
    public String getOutputData() {
        return outputData;
    }
    
    public void setOutputData(String outputData) {
        this.outputData = outputData;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getClientIp() {
        return clientIp;
    }
    
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}