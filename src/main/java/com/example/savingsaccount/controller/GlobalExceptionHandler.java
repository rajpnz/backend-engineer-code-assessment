package com.example.savingsaccount.controller;

import com.example.savingsaccount.exception.BusinessRuleViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessRuleViolationException.class)
    public ProblemDetail handleBusinessRuleViolation(BusinessRuleViolationException businessRuleViolationException) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_CONTENT);
        problemDetail.setTitle("Business Rule Violation");
        problemDetail.setDetail(businessRuleViolationException.getMessage());
        return problemDetail;
    }

}
