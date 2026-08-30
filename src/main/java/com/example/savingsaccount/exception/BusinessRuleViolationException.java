package com.example.savingsaccount.exception;

public class BusinessRuleViolationException extends RuntimeException{

    public BusinessRuleViolationException(String message) {
        super(message);
    }
}
