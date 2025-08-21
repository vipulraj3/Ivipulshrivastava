package com.ivipulshrivastava.backend.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor for Computing angles of a triangle from three points
 */
public class ComputeAnglesExecutor implements ApplicationExecutor {
    
    @Override
    public String getApplicationType() {
        return "compute-angles";
    }
    
    @Override
    public String getDescription() {
        return "Calculate the three angles of a triangle given three points (x1,y1), (x2,y2), (x3,y3)";
    }
    
    @Override
    public void validateInput(Map<String, Object> inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        
        String[] requiredFields = {"x1", "y1", "x2", "y2", "x3", "y3"};
        
        for (String field : requiredFields) {
            if (!inputData.containsKey(field)) {
                throw new IllegalArgumentException("'" + field + "' parameter is required");
            }
            
            try {
                Double.parseDouble(inputData.get(field).toString());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'" + field + "' must be a valid number");
            }
        }
        
        // Validate that the three points don't form a degenerate triangle (collinear)
        double x1 = Double.parseDouble(inputData.get("x1").toString());
        double y1 = Double.parseDouble(inputData.get("y1").toString());
        double x2 = Double.parseDouble(inputData.get("x2").toString());
        double y2 = Double.parseDouble(inputData.get("y2").toString());
        double x3 = Double.parseDouble(inputData.get("x3").toString());
        double y3 = Double.parseDouble(inputData.get("y3").toString());
        
        // Check if points are collinear using cross product
        double crossProduct = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (Math.abs(crossProduct) < 1e-10) {
            throw new IllegalArgumentException("The three points are collinear and do not form a valid triangle");
        }
    }
    
    @Override
    public Map<String, Object> execute(Map<String, Object> inputData) {
        double x1 = Double.parseDouble(inputData.get("x1").toString());
        double y1 = Double.parseDouble(inputData.get("y1").toString());
        double x2 = Double.parseDouble(inputData.get("x2").toString());
        double y2 = Double.parseDouble(inputData.get("y2").toString());
        double x3 = Double.parseDouble(inputData.get("x3").toString());
        double y3 = Double.parseDouble(inputData.get("y3").toString());
        
        // Calculate side lengths
        double a = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3)); // side opposite to angle A
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)); // side opposite to angle B
        double c = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); // side opposite to angle C
        
        // Calculate angles using law of cosines
        double angleA = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        double angleB = Math.toDegrees(Math.acos((-a * a + b * b - c * c) / (-2 * a * c)));
        double angleC = Math.toDegrees(Math.acos((-a * a - b * b + c * c) / (-2 * b * a)));
        
        // Round to 2 decimal places
        angleA = Math.round(angleA * 100.0) / 100.0;
        angleB = Math.round(angleB * 100.0) / 100.0;
        angleC = Math.round(angleC * 100.0) / 100.0;
        
        Map<String, Object> result = new HashMap<>();
        result.put("point1", Map.of("x", x1, "y", y1));
        result.put("point2", Map.of("x", x2, "y", y2));
        result.put("point3", Map.of("x", x3, "y", y3));
        result.put("sideA", Math.round(a * 100.0) / 100.0);
        result.put("sideB", Math.round(b * 100.0) / 100.0);
        result.put("sideC", Math.round(c * 100.0) / 100.0);
        result.put("angleA", angleA);
        result.put("angleB", angleB);
        result.put("angleC", angleC);
        result.put("angleSum", Math.round((angleA + angleB + angleC) * 100.0) / 100.0);
        result.put("triangleType", determineTriangleType(angleA, angleB, angleC));
        
        return result;
    }
    
    private String determineTriangleType(double angleA, double angleB, double angleC) {
        if (Math.abs(angleA - 90) < 0.01 || Math.abs(angleB - 90) < 0.01 || Math.abs(angleC - 90) < 0.01) {
            return "Right Triangle";
        } else if (angleA > 90 || angleB > 90 || angleC > 90) {
            return "Obtuse Triangle";
        } else {
            return "Acute Triangle";
        }
    }
}