package com.tmoney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank_accounts")
@Setter
@Getter
public class BankAccount {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankCode;
    private String accountNumber;
    private String accountHolderName;
    private Double balance;
    private Long userId;

    public BankAccount() {}

	public BankAccount(Long id, String bankCode, String accountNumber, String accountHolderName, Double balance,
			Long userId) {
		super();
		this.id = id;
		this.bankCode = bankCode;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.userId = userId;
	}
}
