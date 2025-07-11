package com.cashbk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cashbk.entity.Cashback;

@Repository
public interface CashbackRepository extends JpaRepository<Cashback, Long> {

}
