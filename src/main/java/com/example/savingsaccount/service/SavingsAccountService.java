package com.example.savingsaccount.service;

import com.example.savingsaccount.component.OffensiveNicknameValidator;
import com.example.savingsaccount.dto.CreateSavingsAccountRequest;
import com.example.savingsaccount.dto.SavingsAccountResponse;
import com.example.savingsaccount.entity.Account;
import com.example.savingsaccount.exception.BusinessRuleViolationException;
import com.example.savingsaccount.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {

    private final AccountNumberService accountNumberService;
    private final OffensiveNicknameValidator offensiveNicknameValidator;
    private final AccountRepository accountRepository;

    public SavingsAccountService(AccountNumberService accountNumberService, OffensiveNicknameValidator offensiveNicknameValidator, AccountRepository accountRepository) {
        this.accountNumberService = accountNumberService;
        this.offensiveNicknameValidator = offensiveNicknameValidator;
        this.accountRepository = accountRepository;
    }

    public SavingsAccountResponse createAccount(CreateSavingsAccountRequest createSavingsAccountRequest){

        if(offensiveNicknameValidator.isOffensive(createSavingsAccountRequest.getAccountNickname())) {
            throw new BusinessRuleViolationException("Account nickname is not allowed");
        }
        // TODO: If customer has 5 accounts or more return a Http 409 error
        Account accountToSave = new Account(accountNumberService.generateId(), accountNumberService.generateAccountNumber(), createSavingsAccountRequest.getCustomerName(),
                createSavingsAccountRequest.getAccountNickname());
        Account savedAccount = accountRepository.save(accountToSave);
        return new SavingsAccountResponse(savedAccount.getId(), savedAccount.getAccountNumber(),
                savedAccount.getCustomerName(), savedAccount.getAccountNickname());
    }

    public SavingsAccountResponse getAccountById(String accountId){
        // TODO: Get bank account details from Postgres database and handle database errors
        // TODO: Cache bank account details using Redis
        return new SavingsAccountResponse(accountId, "123", "John Smith", "Johnny");
    }
}
