package com.cashbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cashbk.entity.Cashback;
import com.cashbk.repositories.CashbackRepository;

@Service
public class CashbackService {

	@Autowired
    private CashbackRepository cashbackRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Cashback calculateCashback(Long userId, Double billAmount) {
        // Call Provide Offers microservice to get cashback % (stubbed with 5% for demo)
        Double cashbackPercentage = 0.05;

        Double cashbackAmount = billAmount * cashbackPercentage;

        Cashback cashback = new Cashback();
        cashback.setUserId(userId);
        cashback.setCashbackAmount(cashbackAmount);
        cashback.setDescription("Cashback for bill payment");

        return cashbackRepository.save(cashback);
    }
}
