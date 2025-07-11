package com.viewt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewt.entity.Transaction;
import com.viewt.service.TransactionService;

//GET: http://localhost:8085/api/transactions/view?userId=1&page=0&size=5

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	 @Autowired
	    private TransactionService transactionService;

	    @GetMapping("/view")
	    public ResponseEntity<Page<Transaction>> viewTransactions(
	    		 @RequestParam(name = "userId") Long userId,
	    	        @RequestParam(name = "page", defaultValue = "0") int page,
	    	        @RequestParam(name = "size", defaultValue = "5") int size) {

	        Page<Transaction> transactions = transactionService.getTransactionsForUser(userId, page, size);
	        return ResponseEntity.ok(transactions);
	    }
}
