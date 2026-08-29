package com.example.savingsaccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateSavingsAccountRequest {
    @NotBlank(message = "customerName must not be blank")
    private String customerName;

    @Size(min = 5, max = 30, message = "accountNickName must be between 5 and 30 characters")
    private String accountNickName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNickName() {
        return accountNickName;
    }

    public void setAccountNickName(String accountNickName) {
        this.accountNickName = accountNickName;
    }
}
