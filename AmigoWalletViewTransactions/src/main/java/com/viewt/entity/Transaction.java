package com.viewt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "user_id", nullable = false)
	    private Long userId;

	    @Column(name = "transaction_date", nullable = false)
	    private LocalDateTime transactionDate;

	    @Column(nullable = false)
	    private String info;

	    @Column(nullable = false)
	    private Double amount;

	    @Column(nullable = false)
	    private String status;
}