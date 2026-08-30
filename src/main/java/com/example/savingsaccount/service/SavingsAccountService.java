package com.example.savingsaccount.service;

import com.example.savingsaccount.component.OffensiveNicknameValidator;
import com.example.savingsaccount.dto.CreateSavingsAccountRequest;
import com.example.savingsaccount.dto.SavingsAccountResponse;
import com.example.savingsaccount.exception.BusinessRuleViolationException;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {

    private final AccountNumberService accountNumberService;
    private final OffensiveNicknameValidator offensiveNicknameValidator;

    public SavingsAccountService(AccountNumberService accountNumberService, OffensiveNicknameValidator offensiveNicknameValidator) {
        this.accountNumberService = accountNumberService;
        this.offensiveNicknameValidator = offensiveNicknameValidator;
    }

    public SavingsAccountResponse createAccount(CreateSavingsAccountRequest createSavingsAccountRequest){

        if(offensiveNicknameValidator.isOffensive(createSavingsAccountRequest.getAccountNickname())) {
            throw new BusinessRuleViolationException("Account nickname is not allowed");
        }
        // TODO: If customer has 5 accounts or more return a Http 409 error
        // TODO: Save bank account details to a Postgres database and handle database errors
        return new SavingsAccountResponse(accountNumberService.generateId(),
                accountNumberService.generateAccountNumber(), createSavingsAccountRequest.getCustomerName(),
                createSavingsAccountRequest.getAccountNickname());
    }

    public SavingsAccountResponse getAccountById(String accountId){
        // TODO: Get bank account details from Postgres database and handle database errors
        // TODO: Cache bank account details using Redis
        return new SavingsAccountResponse(accountId, "123", "John Smith", "Johnny");
    }
}
