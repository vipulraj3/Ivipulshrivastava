package com.ivipulshrivastava.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit tests for PopulationProjectionExecutor
 */
class PopulationProjectionExecutorTest {
    
    private PopulationProjectionExecutor executor;
    
    @BeforeEach
    void setUp() {
        executor = new PopulationProjectionExecutor();
    }
    
    @Test
    void testExecute_WithDefaultPopulation() {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("years", 5);
        
        Map<String, Object> result = executor.execute(inputData);
        
        assertNotNull(result);
        assertEquals(312032486L, result.get("startingPopulation"));
        assertEquals(325932969L, result.get("finalPopulation"));
        assertEquals(13900483L, result.get("totalGrowth"));
        
        @SuppressWarnings("unchecked")
        Map<String, Long> yearlyProjections = (Map<String, Long>) result.get("yearlyProjections");
        assertEquals(5, yearlyProjections.size());
        assertEquals(314812582L, yearlyProjections.get("year1"));
        assertEquals(325932969L, yearlyProjections.get("year5"));
    }
    
    @Test
    void testExecute_WithCustomPopulation() {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("years", 3);
        inputData.put("currentPopulation", 100000000.0);
        
        Map<String, Object> result = executor.execute(inputData);
        
        assertNotNull(result);
        assertEquals(100000000L, result.get("startingPopulation"));
        assertTrue((Long) result.get("finalPopulation") > 100000000L);
    }
    
    @Test
    void testValidateInput_ValidInput() {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("years", 10);
        
        assertDoesNotThrow(() -> executor.validateInput(inputData));
    }
    
    @Test
    void testValidateInput_NullInput() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> executor.validateInput(null)
        );
        assertEquals("Input data cannot be null", exception.getMessage());
    }
    
    @Test
    void testValidateInput_MissingYears() {
        Map<String, Object> inputData = new HashMap<>();
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> executor.validateInput(inputData)
        );
        assertEquals("'years' parameter is required", exception.getMessage());
    }
    
    @Test
    void testValidateInput_InvalidYearsRange() {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("years", 100);
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> executor.validateInput(inputData)
        );
        assertEquals("Years must be between 1 and 50", exception.getMessage());
    }
    
    @Test
    void testGetApplicationType() {
        assertEquals("population-projection", executor.getApplicationType());
    }
    
    @Test
    void testGetDescription() {
        assertNotNull(executor.getDescription());
        assertTrue(executor.getDescription().contains("population"));
    }
}