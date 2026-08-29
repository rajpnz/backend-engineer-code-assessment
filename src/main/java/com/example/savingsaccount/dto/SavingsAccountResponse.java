package com.example.savingsaccount.dto;

public class SavingsAccountResponse {

    private final String id;
    private final String accountNumber;
    private final String customerName;
    private final String accountNickname;

    public SavingsAccountResponse(String id, String accountNumber, String customerName, String accountNickname) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountNickname = accountNickname;
    }
    public String getAccountNickname() {
        return accountNickname;
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
