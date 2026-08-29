package com.example.savingsaccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateSavingsAccountRequest {

    @NotBlank(message = "customerName must not be blank")
    private final String customerName;

    @Size(min = 5, max = 30, message = "accountNickName must be between 5 and 30 characters")
    private final String accountNickName;

    public CreateSavingsAccountRequest(String customerName, String accountNickName) {
        this.customerName = customerName;
        this.accountNickName = accountNickName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountNickName() {
        return accountNickName;
    }
}
