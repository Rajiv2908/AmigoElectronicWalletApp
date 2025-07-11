package com.offers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offers.entity.Offer;
import com.offers.repositories.OfferRepository;

@Service
public class OfferService {
	@Autowired
    private OfferRepository offerRepository;

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public List<Offer> getOffersByRegion(String region) {
        return offerRepository.findByRegion(region);
    }
}
