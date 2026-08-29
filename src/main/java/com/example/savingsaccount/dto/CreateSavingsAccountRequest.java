package com.example.savingsaccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateSavingsAccountRequest {

    @NotBlank(message = "customerName must not be blank")
    private final String customerName;

    @Size(min = 5, max = 30, message = "accountNickName must be between 5 and 30 characters")
    private final String accountNickname;

    public CreateSavingsAccountRequest(String customerName, String accountNickname) {
        this.customerName = customerName;
        this.accountNickname = accountNickname;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountNickname() {
        return accountNickname;
    }
}
