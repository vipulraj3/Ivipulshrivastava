package com.ivipulshrivastava.backend.service;

import com.ivipulshrivastava.backend.dto.ApplicationRequest;
import com.ivipulshrivastava.backend.dto.ApplicationResponse;
import com.ivipulshrivastava.backend.model.CalculationResult;
import com.ivipulshrivastava.backend.repository.CalculationResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Main service to manage and execute applications
 */
@Service
public class ApplicationService {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);
    
    @Autowired
    private CalculationResultRepository resultRepository;
    
    @Autowired
    private ApplicationRegistry applicationRegistry;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    /**
     * Execute an application based on the request
     */
    public ApplicationResponse executeApplication(ApplicationRequest request, String clientIp) {
        try {
            logger.debug("Executing application: {} with input: {}", request.getApplicationType(), request.getInputData());
            
            ApplicationExecutor executor = applicationRegistry.getExecutor(request.getApplicationType());
            if (executor == null) {
                return ApplicationResponse.error(request.getApplicationType(), 
                    "Application type not found: " + request.getApplicationType());
            }
            
            // Validate input
            executor.validateInput(request.getInputData());
            
            // Execute application
            Map<String, Object> outputData = executor.execute(request.getInputData());
            
            // Create response
            ApplicationResponse response = ApplicationResponse.success(
                request.getApplicationType(), 
                request.getInputData(), 
                outputData
            );
            
            // Save result to database
            CalculationResult result = saveResult(request, outputData, clientIp);
            response.setResultId(result.getId());
            
            logger.debug("Application executed successfully: {}", request.getApplicationType());
            return response;
            
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid input for application {}: {}", request.getApplicationType(), e.getMessage());
            return ApplicationResponse.error(request.getApplicationType(), "Invalid input: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error executing application {}: {}", request.getApplicationType(), e.getMessage(), e);
            return ApplicationResponse.error(request.getApplicationType(), "Execution error: " + e.getMessage());
        }
    }
    
    /**
     * Get list of available applications
     */
    public Map<String, Object> getAvailableApplications() {
        Map<String, Object> applications = new HashMap<>();
        for (ApplicationExecutor executor : applicationRegistry.getAllExecutors()) {
            Map<String, String> appInfo = new HashMap<>();
            appInfo.put("type", executor.getApplicationType());
            appInfo.put("description", executor.getDescription());
            applications.put(executor.getApplicationType(), appInfo);
        }
        return applications;
    }
    
    /**
     * Get execution history
     */
    public List<CalculationResult> getExecutionHistory(String applicationType) {
        if (applicationType != null && !applicationType.isEmpty()) {
            return resultRepository.findByApplicationType(applicationType);
        }
        return resultRepository.findAll();
    }
    
    /**
     * Get result by ID
     */
    public Optional<CalculationResult> getResultById(Long id) {
        return resultRepository.findById(id);
    }
    
    /**
     * Save calculation result to database
     */
    private CalculationResult saveResult(ApplicationRequest request, Map<String, Object> outputData, String clientIp) {
        try {
            String inputJson = objectMapper.writeValueAsString(request.getInputData());
            String outputJson = objectMapper.writeValueAsString(outputData);
            
            CalculationResult result = new CalculationResult(
                request.getApplicationType(),
                inputJson,
                outputJson
            );
            result.setClientIp(clientIp);
            
            return resultRepository.save(result);
        } catch (Exception e) {
            logger.error("Error saving result to database: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to save result", e);
        }
    }
}