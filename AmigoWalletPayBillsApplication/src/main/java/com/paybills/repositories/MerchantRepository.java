package com.paybills.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paybills.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Optional<Merchant> findById(Long id);

}
