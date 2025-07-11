package com.loadwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loadwt.entity.BankAccount;
import com.loadwt.entity.Wallet;
import com.loadwt.repositories.BankAccountRepository;
import com.loadwt.repositories.WalletRepository;

@Service
public class WalletService {
	@Autowired
    private WalletRepository walletRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private RestTemplate restTemplate;

    public String loadWallet(Long userId, String accountNumber, Double amount) {
        if (amount < 100) {
            throw new RuntimeException("Minimum load amount is 100 USD.");
        }

        // Validate user via Manage User Service
        Boolean isValidUser = restTemplate.getForObject(
            "http://localhost:8081/api/users/validate/" + userId,
            Boolean.class
        );
        if (!Boolean.TRUE.equals(isValidUser)) {
            throw new RuntimeException("User validation failed.");
        }

        // Validate bank account
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Bank account not found."));

        if (bankAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient bank balance.");
        }

        bankAccount.setBalance(bankAccount.getBalance() - amount);
        bankAccountRepository.save(bankAccount);

        Wallet wallet = walletRepository.findByUserId(userId)
                .orElse(new Wallet(userId, 0.0));
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        return "Wallet loaded successfully with amount: " + amount;
    }
}
