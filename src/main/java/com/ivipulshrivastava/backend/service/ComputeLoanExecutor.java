package com.ivipulshrivastava.backend.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor for Loan calculations
 */
public class ComputeLoanExecutor implements ApplicationExecutor {
    
    @Override
    public String getApplicationType() {
        return "compute-loan";
    }
    
    @Override
    public String getDescription() {
        return "Calculate monthly and total loan payments based on interest rate, years, and loan amount";
    }
    
    @Override
    public void validateInput(Map<String, Object> inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        
        // Validate annual interest rate
        if (!inputData.containsKey("annualInterestRate")) {
            throw new IllegalArgumentException("'annualInterestRate' parameter is required");
        }
        try {
            double rate = Double.parseDouble(inputData.get("annualInterestRate").toString());
            if (rate < 0 || rate > 100) {
                throw new IllegalArgumentException("Annual interest rate must be between 0 and 100");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'annualInterestRate' must be a valid number");
        }
        
        // Validate number of years
        if (!inputData.containsKey("numberOfYears")) {
            throw new IllegalArgumentException("'numberOfYears' parameter is required");
        }
        try {
            int years = Integer.parseInt(inputData.get("numberOfYears").toString());
            if (years <= 0 || years > 50) {
                throw new IllegalArgumentException("Number of years must be between 1 and 50");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'numberOfYears' must be a valid integer");
        }
        
        // Validate loan amount
        if (!inputData.containsKey("loanAmount")) {
            throw new IllegalArgumentException("'loanAmount' parameter is required");
        }
        try {
            double amount = Double.parseDouble(inputData.get("loanAmount").toString());
            if (amount <= 0) {
                throw new IllegalArgumentException("Loan amount must be positive");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'loanAmount' must be a valid number");
        }
    }
    
    @Override
    public Map<String, Object> execute(Map<String, Object> inputData) {
        double annualInterestRate = Double.parseDouble(inputData.get("annualInterestRate").toString()) / 100;
        int numberOfYears = Integer.parseInt(inputData.get("numberOfYears").toString());
        double loanAmount = Double.parseDouble(inputData.get("loanAmount").toString());
        
        double monthlyInterestRate = annualInterestRate / 12.0;
        int numberOfPayments = numberOfYears * 12;
        
        // Calculate monthly payment using the loan formula
        double monthlyPayment;
        if (monthlyInterestRate == 0) {
            // Handle case where interest rate is 0
            monthlyPayment = loanAmount / numberOfPayments;
        } else {
            monthlyPayment = loanAmount * monthlyInterestRate / 
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        }
        
        double totalPayment = monthlyPayment * numberOfPayments;
        double totalInterest = totalPayment - loanAmount;
        
        Map<String, Object> result = new HashMap<>();
        result.put("monthlyPayment", Math.round(monthlyPayment * 100.0) / 100.0);
        result.put("totalPayment", Math.round(totalPayment * 100.0) / 100.0);
        result.put("totalInterest", Math.round(totalInterest * 100.0) / 100.0);
        result.put("loanAmount", loanAmount);
        result.put("annualInterestRate", annualInterestRate * 100);
        result.put("numberOfYears", numberOfYears);
        result.put("numberOfPayments", numberOfPayments);
        
        return result;
    }
}