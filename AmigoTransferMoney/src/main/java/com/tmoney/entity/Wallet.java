package com.tmoney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wallets")
@Setter
@Getter
public class Wallet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double balance;

    public Wallet() {}
    public Wallet(Long userId, Double balance) {
        this.userId = userId;
        this.balance = balance;
    }
    
}
