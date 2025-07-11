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
@Table(name = "merchants")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    @Id @GeneratedValue 
    private Long id;
    private String name;
    private String utilityType; // electricity, water, etc.
    private Double balance;
    // getters, setters, constructors
    
    
}
