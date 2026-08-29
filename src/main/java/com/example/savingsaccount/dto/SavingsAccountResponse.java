package com.example.savingsaccount.dto;

public class SavingsAccountResponse {

    private final String id;
    private final String accountNumber;
    private final String customerName;
    private final String accountNickName;

    public SavingsAccountResponse(String id, String accountNumber, String customerName, String accountNickName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountNickName = accountNickName;
    }
    public String getAccountNickName() {
        return accountNickName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getId() {
        return id;
    }
}
