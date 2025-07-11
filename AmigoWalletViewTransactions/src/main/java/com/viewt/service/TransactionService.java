package com.viewt.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.viewt.entity.Transaction;
import com.viewt.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> getTransactionsForUser(Long userId, int page, int size) {
        Sort sort = Sort.by("transactionDate").descending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return transactionRepository.findByUserId(userId, pageable);
    }
}
