package com.offers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.offers.entity.Offer;
import com.offers.service.OfferService;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
	 @Autowired
	    private OfferService offerService;

	    @PostMapping("/add")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
	        return ResponseEntity.ok(offerService.addOffer(offer));
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Offer>> getAllOffers() {
	        return ResponseEntity.ok(offerService.getAllOffers());
	    }

	    @GetMapping("/by-region")
	    public ResponseEntity<List<Offer>> getOffersByRegion(@RequestParam String region) {
	        return ResponseEntity.ok(offerService.getOffersByRegion(region));
	    }
}
