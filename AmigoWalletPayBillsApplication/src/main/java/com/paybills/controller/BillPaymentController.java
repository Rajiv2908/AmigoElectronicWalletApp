package com.paybills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paybills.service.BillPaymentService;

@RestController
@RequestMapping("/api/payments")
public class BillPaymentController {

	@Autowired
	private BillPaymentService billPaymentService;

	@PostMapping("/pay-bill")
	public ResponseEntity<String> payBill(@RequestParam("userId") Long userId,
			@RequestParam("merchantId") Long merchantId) {
		String result = billPaymentService.payBill(userId, merchantId);
		return ResponseEntity.ok(result);
	}
}
