package com.tmoney.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmoney.entity.BankAccount;
import com.tmoney.entity.Wallet;
import com.tmoney.repositories.BankAccountRepository;
import com.tmoney.repositories.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferService {

	@Autowired
    private WalletRepository walletRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    private final Pattern bankCodePattern = Pattern.compile("^[A-Za-z]{4}\\d{6,8}$");
    private final Pattern accountNumberPattern = Pattern.compile("^\\d+$");
    private final Pattern namePattern = Pattern.compile("^[A-Za-z ]+$");

    @Transactional
    public String transferToBank(Long userId, String bankCode, String accountNumber, String accountHolderName, Double amount) {
        if (!bankCodePattern.matcher(bankCode).matches()) {
            throw new IllegalArgumentException("Invalid bank code format.");
        }
        if (!accountNumberPattern.matcher(accountNumber).matches()) {
            throw new IllegalArgumentException("Invalid account number format.");
        }
        if (!namePattern.matcher(accountHolderName).matches()) {
            throw new IllegalArgumentException("Invalid account holder name.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }

        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found."));
        if (wallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient wallet balance.");
        }

        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Bank account not found."));

        if (!bankAccount.getBankCode().equals(bankCode) ||
            !bankAccount.getAccountHolderName().equalsIgnoreCase(accountHolderName)) {
            throw new RuntimeException("Bank account details do not match.");
        }

        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);

        bankAccount.setBalance(bankAccount.getBalance() + amount);
        bankAccountRepository.save(bankAccount);

        return "Transfer to bank successful. Amount: " + amount;
    }

    @Transactional
    public String transferToWallet(Long fromUserId, Long toUserId, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }

        Wallet fromWallet = walletRepository.findByUserId(fromUserId)
                .orElseThrow(() -> new RuntimeException("Sender wallet not found."));
        Wallet toWallet = walletRepository.findByUserId(toUserId)
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found."));

        if (fromWallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient wallet balance.");
        }

        fromWallet.setBalance(fromWallet.getBalance() - amount);
        toWallet.setBalance(toWallet.getBalance() + amount);

        walletRepository.save(fromWallet);
        walletRepository.save(toWallet);

        return "Transfer to another wallet successful. Amount: " + amount;
    }
}
