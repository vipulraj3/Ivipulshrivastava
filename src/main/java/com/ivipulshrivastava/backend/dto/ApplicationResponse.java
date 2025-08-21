package com.ivipulshrivastava.backend.dto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Data Transfer Object for application execution responses
 */
public class ApplicationResponse {
    
    private String applicationType;
    private Map<String, Object> inputData;
    private Map<String, Object> outputData;
    private LocalDateTime timestamp;
    private String status;
    private String errorMessage;
    private Long resultId;
    
    // Constructors
    public ApplicationResponse() {
        this.timestamp = LocalDateTime.now();
        this.status = "SUCCESS";
    }
    
    public ApplicationResponse(String applicationType, Map<String, Object> inputData, Map<String, Object> outputData) {
        this();
        this.applicationType = applicationType;
        this.inputData = inputData;
        this.outputData = outputData;
    }
    
    // Static factory methods
    public static ApplicationResponse success(String applicationType, Map<String, Object> inputData, Map<String, Object> outputData) {
        return new ApplicationResponse(applicationType, inputData, outputData);
    }
    
    public static ApplicationResponse error(String applicationType, String errorMessage) {
        ApplicationResponse response = new ApplicationResponse();
        response.setApplicationType(applicationType);
        response.setStatus("ERROR");
        response.setErrorMessage(errorMessage);
        return response;
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
    
    public Map<String, Object> getOutputData() {
        return outputData;
    }
    
    public void setOutputData(Map<String, Object> outputData) {
        this.outputData = outputData;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public Long getResultId() {
        return resultId;
    }
    
    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }
}