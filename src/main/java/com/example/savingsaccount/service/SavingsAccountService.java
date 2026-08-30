package com.example.savingsaccount.service;

import com.example.savingsaccount.dto.CreateSavingsAccountRequest;
import com.example.savingsaccount.dto.SavingsAccountResponse;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {

    private final AccountNumberService accountNumberService;

    public SavingsAccountService(AccountNumberService accountNumberService) {
        this.accountNumberService = accountNumberService;
    }

    public SavingsAccountResponse createAccount(CreateSavingsAccountRequest createSavingsAccountRequest){
        return new SavingsAccountResponse(accountNumberService.generateId(),
                accountNumberService.generateAccountNumber(), createSavingsAccountRequest.getCustomerName(),
                createSavingsAccountRequest.getAccountNickname());
    }

    public SavingsAccountResponse getAccountById(String accountId){
        return new SavingsAccountResponse(accountId, "123", "John Smith", "Johnny");
    }
}
