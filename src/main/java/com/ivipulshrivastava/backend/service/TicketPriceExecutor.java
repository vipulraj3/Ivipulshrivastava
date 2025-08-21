package com.ivipulshrivastava.backend.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor for Ticket Price calculations based on age
 */
public class TicketPriceExecutor implements ApplicationExecutor {
    
    @Override
    public String getApplicationType() {
        return "ticket-price";
    }
    
    @Override
    public String getDescription() {
        return "Calculate ticket price based on age (under 16: $10, 16 and over: $20)";
    }
    
    @Override
    public void validateInput(Map<String, Object> inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        
        if (!inputData.containsKey("age")) {
            throw new IllegalArgumentException("'age' parameter is required");
        }
        
        try {
            int age = Integer.parseInt(inputData.get("age").toString());
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'age' must be a valid integer");
        }
    }
    
    @Override
    public Map<String, Object> execute(Map<String, Object> inputData) {
        int age = Integer.parseInt(inputData.get("age").toString());
        
        Map<String, Object> result = new HashMap<>();
        
        if (age >= 16) {
            result.put("ticketPrice", 20);
            result.put("category", "Adult");
            result.put("message", "Ticket Price is 20");
        } else {
            result.put("ticketPrice", 10);
            result.put("category", "Child");
            result.put("message", "Ticket price is 10");
        }
        
        result.put("age", age);
        result.put("currency", "USD");
        
        return result;
    }
}