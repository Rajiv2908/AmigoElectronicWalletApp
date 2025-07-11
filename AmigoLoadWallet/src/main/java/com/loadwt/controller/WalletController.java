package com.loadwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loadwt.services.WalletService;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

	 @Autowired
	    private WalletService walletService;

	    @PostMapping("/load")
	    public ResponseEntity<String> loadWallet(@RequestParam Long userId, @RequestParam String accountNumber, @RequestParam Double amount) {
	        return ResponseEntity.ok(walletService.loadWallet(userId, accountNumber, amount));
	    }
}
