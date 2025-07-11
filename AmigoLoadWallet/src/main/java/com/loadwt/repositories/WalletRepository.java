package com.loadwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loadwt.entity.BankAccount;
import com.loadwt.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
	
	Optional<Wallet> findByUserId(Long userId);

}
