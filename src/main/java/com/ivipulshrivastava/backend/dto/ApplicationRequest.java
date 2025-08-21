package com.ivipulshrivastava.backend.dto;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

/**
 * Data Transfer Object for application execution requests
 */
public class ApplicationRequest {
    
    @NotNull(message = "Application type is required")
    private String applicationType;
    
    private Map<String, Object> inputData;
    
    // Constructors
    public ApplicationRequest() {}
    
    public ApplicationRequest(String applicationType, Map<String, Object> inputData) {
        this.applicationType = applicationType;
        this.inputData = inputData;
    }
    
    // Getters and Setters
    public String getApplicationType() {
        return applicationType;
    }
    
    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
    
    public Map<String, Object> getInputData() {
        return inputData;
    }
    
    public void setInputData(Map<String, Object> inputData) {
        this.inputData = inputData;
    }
}