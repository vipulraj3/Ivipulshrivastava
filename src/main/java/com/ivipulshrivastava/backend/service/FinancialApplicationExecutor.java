package com.ivipulshrivastava.backend.service;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Executor for Financial Application calculations (compound interest with monthly deposits)
 */
public class FinancialApplicationExecutor implements ApplicationExecutor {
    
    @Override
    public String getApplicationType() {
        return "financial-application";
    }
    
    @Override
    public String getDescription() {
        return "Calculate compound interest with monthly deposits over specified months";
    }
    
    @Override
    public void validateInput(Map<String, Object> inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        
        if (!inputData.containsKey("months")) {
            throw new IllegalArgumentException("'months' parameter is required");
        }
        
        try {
            int months = Integer.parseInt(inputData.get("months").toString());
            if (months <= 0 || months > 600) {
                throw new IllegalArgumentException("Months must be between 1 and 600");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'months' must be a valid integer");
        }
        
        // Optional parameters validation
        if (inputData.containsKey("monthlyDeposit")) {
            try {
                double deposit = Double.parseDouble(inputData.get("monthlyDeposit").toString());
                if (deposit <= 0) {
                    throw new IllegalArgumentException("Monthly deposit must be positive");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'monthlyDeposit' must be a valid number");
            }
        }
        
        if (inputData.containsKey("annualInterestRate")) {
            try {
                double rate = Double.parseDouble(inputData.get("annualInterestRate").toString());
                if (rate < 0 || rate > 100) {
                    throw new IllegalArgumentException("Annual interest rate must be between 0 and 100");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'annualInterestRate' must be a valid number");
            }
        }
    }
    
    @Override
    public Map<String, Object> execute(Map<String, Object> inputData) {
        int months = Integer.parseInt(inputData.get("months").toString());
        double monthlyDeposit = inputData.containsKey("monthlyDeposit") ? 
            Double.parseDouble(inputData.get("monthlyDeposit").toString()) : 100.0;
        double annualInterestRate = inputData.containsKey("annualInterestRate") ? 
            Double.parseDouble(inputData.get("annualInterestRate").toString()) : 3.75;
        
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        double balance = 0;
        
        List<Map<String, Object>> monthlyDetails = new ArrayList<>();
        
        for (int month = 1; month <= months; month++) {
            balance = (balance + monthlyDeposit) * (1 + monthlyInterestRate);
            
            Map<String, Object> monthDetail = new HashMap<>();
            monthDetail.put("month", month);
            monthDetail.put("balance", Math.round(balance * 100.0) / 100.0);
            monthDetail.put("totalDeposited", month * monthlyDeposit);
            monthDetail.put("interestEarned", Math.round((balance - (month * monthlyDeposit)) * 100.0) / 100.0);
            
            monthlyDetails.add(monthDetail);
        }
        
        Map<String, Object> result = new HashMap<>();
        result.put("finalBalance", Math.round(balance * 100.0) / 100.0);
        result.put("totalDeposited", months * monthlyDeposit);
        result.put("totalInterestEarned", Math.round((balance - (months * monthlyDeposit)) * 100.0) / 100.0);
        result.put("monthlyDetails", monthlyDetails);
        result.put("effectiveAnnualReturn", Math.round(((balance / (months * monthlyDeposit)) - 1) * 100 * 100.0) / 100.0);
        
        return result;
    }
}