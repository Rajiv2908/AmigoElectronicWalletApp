package com.paybills.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wallets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id @GeneratedValue 
    private Long id;
    private Long userId;
    private Double balance;
    // getters, setters, constructors
}