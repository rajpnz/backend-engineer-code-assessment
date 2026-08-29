package com.example.savingsaccount.controller;

import com.example.savingsaccount.dto.CreateSavingsAccountRequest;
import com.example.savingsaccount.dto.SavingsAccountResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/savings-accounts")
public class SavingsAccountController {

    @PostMapping
    public ResponseEntity<SavingsAccountResponse> createAccount(
            @Valid @RequestBody CreateSavingsAccountRequest createSavingsAccountRequest) {
        SavingsAccountResponse response = new SavingsAccountResponse("xyz", "123", "John Smith", "Johnny");
        URI location = URI.create("/api/v1/savings-accounts/" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<SavingsAccountResponse> getAccount(@PathVariable String accountId) {
        SavingsAccountResponse response = new SavingsAccountResponse(accountId, "123", "John Smith", "Johnny");
        return ResponseEntity.ok(response);
    }
}
