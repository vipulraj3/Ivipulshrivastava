package com.ivipulshrivastava.backend.service;

import java.util.Map;

/**
 * Interface for individual application services
 */
public interface ApplicationExecutor {
    
    /**
     * Execute the application with given input data
     * @param inputData Input parameters for the application
     * @return Output data from the application execution
     */
    Map<String, Object> execute(Map<String, Object> inputData);
    
    /**
     * Get the application type identifier
     * @return Application type string
     */
    String getApplicationType();
    
    /**
     * Validate input data for this application
     * @param inputData Input data to validate
     * @throws IllegalArgumentException if input is invalid
     */
    void validateInput(Map<String, Object> inputData);
    
    /**
     * Get description of this application
     * @return Human-readable description
     */
    String getDescription();
}