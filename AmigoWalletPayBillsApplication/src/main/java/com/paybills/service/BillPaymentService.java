package com.paybills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paybills.entity.Merchant;
import com.paybills.entity.Wallet;
import com.paybills.repositories.MerchantRepository;
import com.paybills.repositories.WalletRepository;

@Service
public class BillPaymentService {

	@Autowired private WalletRepository walletRepository;
    @Autowired private MerchantRepository merchantRepository;

    public String payBill(Long userId, Long merchantId) {
        Wallet wallet = walletRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Wallet not found."));
        Merchant merchant = merchantRepository.findById(merchantId)
            .orElseThrow(() -> new RuntimeException("Merchant not found."));

        double amount = 50 + Math.random() * 150; // 50-200 USD
        amount = Math.round(amount * 100.0) / 100.0;

        if (wallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient wallet balance.");
        }

        wallet.setBalance(wallet.getBalance() - amount);
        merchant.setBalance(merchant.getBalance() + amount);

        walletRepository.save(wallet);
        merchantRepository.save(merchant);

        int rewardPoints = calculateRewardPoints(amount);

        return "Bill paid successfully. Amount: " + amount + " USD, Reward Points Earned: " + rewardPoints;
    }

    private int calculateRewardPoints(double amount) {
        return (int)(amount / 10); // 1 point per 10 USD paid
    }
}
