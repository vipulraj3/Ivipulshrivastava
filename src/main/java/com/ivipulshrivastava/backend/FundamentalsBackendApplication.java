package com.ivipulshrivastava.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for the Fundamentals Backend API
 */
@SpringBootApplication
public class FundamentalsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundamentalsBackendApplication.class, args);
        System.out.println("\n=== Fundamentals Backend API Started ===");
        System.out.println("API Base URL: http://localhost:8080/api");
        System.out.println("H2 Console: http://localhost:8080/api/h2-console");
        System.out.println("==========================================\n");
    }
}