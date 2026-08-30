package com.example.savingsaccount.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class AccountNumberService {

    private final Random random = new Random();

    public String generateId() {
        return UUID.randomUUID().toString();
    }

    public String generateAccountNumber() {
        long number = random.nextLong(
                1_000_000_000_000_000L,
                10_000_000_000_000_000L
        );

        return String.valueOf(number);
    }
}
