package com.example.savingsaccount.service;

import com.example.savingsaccount.dto.CreateSavingsAccountRequest;
import com.example.savingsaccount.dto.SavingsAccountResponse;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {

    public SavingsAccountResponse createAccount(CreateSavingsAccountRequest createSavingsAccountRequest){
        return new SavingsAccountResponse("xyz", "123", createSavingsAccountRequest.getCustomerName(),
                createSavingsAccountRequest.getAccountNickname());
    }

    public SavingsAccountResponse getAccountById(String accountId){
        return new SavingsAccountResponse(accountId, "123", "John Smith", "Johnny");
    }
}
