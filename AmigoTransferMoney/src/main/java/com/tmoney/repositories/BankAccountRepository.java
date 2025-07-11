package com.tmoney.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tmoney.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    Optional<BankAccount> findByAccountNumber(String accountNumber);

}
