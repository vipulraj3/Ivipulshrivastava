package com.ivipulshrivastava.backend.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor for Population Projection calculations
 */
public class PopulationProjectionExecutor implements ApplicationExecutor {
    
    @Override
    public String getApplicationType() {
        return "population-projection";
    }
    
    @Override
    public String getDescription() {
        return "Calculate population projection for given number of years based on birth, death, and immigration rates";
    }
    
    @Override
    public void validateInput(Map<String, Object> inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        
        if (!inputData.containsKey("years")) {
            throw new IllegalArgumentException("'years' parameter is required");
        }
        
        try {
            int years = Integer.parseInt(inputData.get("years").toString());
            if (years <= 0 || years > 50) {
                throw new IllegalArgumentException("Years must be between 1 and 50");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'years' must be a valid integer");
        }
        
        // Optional: current population
        if (inputData.containsKey("currentPopulation")) {
            try {
                double population = Double.parseDouble(inputData.get("currentPopulation").toString());
                if (population <= 0) {
                    throw new IllegalArgumentException("Current population must be positive");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'currentPopulation' must be a valid number");
            }
        }
    }
    
    @Override
    public Map<String, Object> execute(Map<String, Object> inputData) {
        int years = Integer.parseInt(inputData.get("years").toString());
        double currentPopulation = inputData.containsKey("currentPopulation") ? 
            Double.parseDouble(inputData.get("currentPopulation").toString()) : 312032486.0;
        
        double secondPerYear = 365 * 24 * 60 * 60;
        double birthPerYear = secondPerYear / 7;
        double deathPerYear = secondPerYear / 13;
        double immigrantsPerYear = secondPerYear / 45;
        
        Map<String, Object> result = new HashMap<>();
        Map<String, Long> yearlyProjections = new HashMap<>();
        
        double population = currentPopulation;
        
        for (int year = 1; year <= years; year++) {
            population += birthPerYear - deathPerYear + immigrantsPerYear;
            yearlyProjections.put("year" + year, (long) population);
        }
        
        result.put("startingPopulation", (long) currentPopulation);
        result.put("finalPopulation", (long) population);
        result.put("yearlyProjections", yearlyProjections);
        result.put("totalGrowth", (long) (population - currentPopulation));
        result.put("averageAnnualGrowth", (long) ((population - currentPopulation) / years));
        
        return result;
    }
}