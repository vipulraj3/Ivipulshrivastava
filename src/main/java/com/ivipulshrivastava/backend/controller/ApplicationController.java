package com.ivipulshrivastava.backend.controller;

import com.ivipulshrivastava.backend.dto.ApplicationRequest;
import com.ivipulshrivastava.backend.dto.ApplicationResponse;
import com.ivipulshrivastava.backend.model.CalculationResult;
import com.ivipulshrivastava.backend.service.ApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST Controller for the Fundamentals Backend API
 */
@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class ApplicationController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    
    @Autowired
    private ApplicationService applicationService;
    
    /**
     * Get API information and available applications
     */
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getApiInfo() {
        logger.info("API info requested");
        Map<String, Object> info = Map.of(
            "name", "Fundamentals Backend API",
            "version", "1.0.0",
            "description", "Backend API for Java Fundamentals Applications",
            "endpoints", Map.of(
                "applications", "/v1/applications",
                "execute", "/v1/execute",
                "history", "/v1/history",
                "result", "/v1/result/{id}"
            )
        );
        return ResponseEntity.ok(info);
    }
    
    /**
     * Get list of available applications
     */
    @GetMapping("/applications")
    public ResponseEntity<Map<String, Object>> getAvailableApplications() {
        logger.info("Available applications requested");
        Map<String, Object> applications = applicationService.getAvailableApplications();
        return ResponseEntity.ok(Map.of(
            "applications", applications,
            "count", applications.size()
        ));
    }
    
    /**
     * Execute an application
     */
    @PostMapping("/execute")
    public ResponseEntity<ApplicationResponse> executeApplication(
            @Valid @RequestBody ApplicationRequest request,
            HttpServletRequest httpRequest) {
        
        String clientIp = getClientIpAddress(httpRequest);
        logger.info("Executing application: {} from IP: {}", request.getApplicationType(), clientIp);
        
        ApplicationResponse response = applicationService.executeApplication(request, clientIp);
        
        if ("ERROR".equals(response.getStatus())) {
            return ResponseEntity.badRequest().body(response);
        }
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Get execution history
     */
    @GetMapping("/history")
    public ResponseEntity<Map<String, Object>> getExecutionHistory(
            @RequestParam(required = false) String applicationType,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        
        logger.info("Execution history requested for application: {}", applicationType);
        
        List<CalculationResult> history = applicationService.getExecutionHistory(applicationType);
        
        // Simple pagination
        int start = Math.min(page * size, history.size());
        int end = Math.min(start + size, history.size());
        List<CalculationResult> paginatedHistory = history.subList(start, end);
        
        Map<String, Object> response = Map.of(
            "history", paginatedHistory,
            "page", page,
            "size", size,
            "totalElements", history.size(),
            "totalPages", (int) Math.ceil((double) history.size() / size)
        );
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Get specific calculation result by ID
     */
    @GetMapping("/result/{id}")
    public ResponseEntity<CalculationResult> getResultById(@PathVariable Long id) {
        logger.info("Result requested for ID: {}", id);
        
        Optional<CalculationResult> result = applicationService.getResultById(id);
        
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "service", "Fundamentals Backend API"
        ));
    }
    
    /**
     * Extract client IP address from request
     */
    private String getClientIpAddress(HttpServletRequest request) {
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            return xForwardedForHeader.split(",")[0];
        }
    }
}