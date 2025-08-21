package com.ivipulshrivastava.backend.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Registry to manage all available application executors
 */
@Service
public class ApplicationRegistry {
    
    private final Map<String, ApplicationExecutor> executors = new HashMap<>();
    
    @PostConstruct
    public void initializeExecutors() {
        // Register all application executors
        registerExecutor(new PopulationProjectionExecutor());
        registerExecutor(new FinancialApplicationExecutor());
        registerExecutor(new TicketPriceExecutor());
        registerExecutor(new ComputeLoanExecutor());
        registerExecutor(new LotteryExecutor());
        registerExecutor(new ComputeAnglesExecutor());
    }
    
    public void registerExecutor(ApplicationExecutor executor) {
        executors.put(executor.getApplicationType(), executor);
    }
    
    public ApplicationExecutor getExecutor(String applicationType) {
        return executors.get(applicationType);
    }
    
    public List<ApplicationExecutor> getAllExecutors() {
        return List.copyOf(executors.values());
    }
    
    public boolean hasExecutor(String applicationType) {
        return executors.containsKey(applicationType);
    }
}