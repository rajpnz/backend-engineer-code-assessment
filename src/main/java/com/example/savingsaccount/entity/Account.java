package com.example.savingsaccount.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@Entity
@Table(
        name = "account",
        schema = "coding_assessment",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_account_account_number",
                columnNames = "account_number"
        )
)
public class Account {

    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "account_number", length = 36, nullable = false)
    private String accountNumber;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "account_nick_name", length = 30)
    private String accountNickName;

    protected Account() {
    }

    public Account(String id, String accountNumber, String customerName,
                   String accountNickName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountNickName = accountNickName;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAccountNickName() {
        return accountNickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}