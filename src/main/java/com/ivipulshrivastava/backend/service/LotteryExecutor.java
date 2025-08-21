package com.ivipulshrivastava.backend.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Executor for Lottery game
 */
public class LotteryExecutor implements ApplicationExecutor {
    
    @Override
    public String getApplicationType() {
        return "lottery";
    }
    
    @Override
    public String getDescription() {
        return "Play a two-digit lottery game with different winning levels and prizes";
    }
    
    @Override
    public void validateInput(Map<String, Object> inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        
        if (!inputData.containsKey("guess")) {
            throw new IllegalArgumentException("'guess' parameter is required");
        }
        
        try {
            int guess = Integer.parseInt(inputData.get("guess").toString());
            if (guess < 0 || guess > 99) {
                throw new IllegalArgumentException("Guess must be a two-digit number (0-99)");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'guess' must be a valid integer");
        }
    }
    
    @Override
    public Map<String, Object> execute(Map<String, Object> inputData) {
        int guess = Integer.parseInt(inputData.get("guess").toString());
        
        // Generate lottery number (0-99)
        int lottery = (int)(Math.random() * 100);
        
        // Extract digits
        int lotteryDigit1 = lottery / 10;
        int lotteryDigit2 = lottery % 10;
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;
        
        Map<String, Object> result = new HashMap<>();
        result.put("guess", guess);
        result.put("lotteryNumber", lottery);
        result.put("guessDigits", new int[]{guessDigit1, guessDigit2});
        result.put("lotteryDigits", new int[]{lotteryDigit1, lotteryDigit2});
        
        // Determine winning level
        String message;
        int prize;
        String level;
        
        if (guess == lottery) {
            message = "Exact match: You Win ₹10000";
            prize = 10000;
            level = "EXACT_MATCH";
        } else if (guessDigit2 == lotteryDigit1 && guessDigit1 == lotteryDigit2) {
            message = "Match all digits: you win ₹3000";
            prize = 3000;
            level = "ALL_DIGITS_MATCH";
        } else if (guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2 || 
                   guessDigit2 == lotteryDigit1 || guessDigit2 == lotteryDigit2) {
            message = "You win ₹1000";
            prize = 1000;
            level = "ONE_DIGIT_MATCH";
        } else {
            message = "Sorry, no match. You lose money.";
            prize = 0;
            level = "NO_MATCH";
        }
        
        result.put("message", message);
        result.put("prize", prize);
        result.put("winningLevel", level);
        result.put("isWinner", prize > 0);
        
        return result;
    }
}