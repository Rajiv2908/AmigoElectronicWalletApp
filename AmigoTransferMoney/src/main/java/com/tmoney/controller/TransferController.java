package com.tmoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmoney.service.TransferService;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

	@Autowired
    private TransferService transferService;

    @PostMapping("/to-bank")
    public ResponseEntity<String> transferToBank(@RequestParam("userId") Long userId,
            @RequestParam("bankCode") String bankCode,
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("accountHolderName") String accountHolderName,
            @RequestParam("amount") Double amount) {
        String result = transferService.transferToBank(userId, bankCode, accountNumber, accountHolderName, amount);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/to-wallet")
    public ResponseEntity<String> transferToWallet(@RequestParam("fromUserId") Long fromUserId,
            @RequestParam("toUserId") Long toUserId,
            @RequestParam("amount") Double amount) {
        String result = transferService.transferToWallet(fromUserId, toUserId, amount);
        return ResponseEntity.ok(result);
    }
}
