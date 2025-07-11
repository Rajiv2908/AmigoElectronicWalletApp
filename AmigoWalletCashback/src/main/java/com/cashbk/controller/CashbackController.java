package com.cashbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashbk.entity.Cashback;
import com.cashbk.service.CashbackService;


//POST: http://localhost:8086/api/cashback/calculate?userId=1&billAmount=150

@RestController
@RequestMapping("/api/cashback")
public class CashbackController {

	@Autowired
    private CashbackService cashbackService;

    @PostMapping("/calculate")
    public ResponseEntity<Cashback> calculateCashback(
    		 @RequestParam(name = "userId") Long userId,
             @RequestParam(name = "billAmount") Double billAmount) {
        Cashback cashback = cashbackService.calculateCashback(userId, billAmount);
        return ResponseEntity.ok(cashback);
    }
}
