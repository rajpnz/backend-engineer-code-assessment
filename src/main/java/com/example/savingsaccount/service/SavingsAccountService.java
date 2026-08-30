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
        return new SavingsAccountResponse(accountNumberService.generateId(),
                accountNumberService.generateAccountNumber(), createSavingsAccountRequest.getCustomerName(),
                createSavingsAccountRequest.getAccountNickname());
    }

    public SavingsAccountResponse getAccountById(String accountId){
        return new SavingsAccountResponse(accountId, "123", "John Smith", "Johnny");
    }
}
