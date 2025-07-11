package com.offers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.offers.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{
	List<Offer> findByRegion(String region);
}
