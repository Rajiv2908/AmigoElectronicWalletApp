package com.offers.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String region;
	private LocalDate validTill;

	public Offer() {
	}

	public Offer(Long id, String title, String description, String region, LocalDate validTill) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.region = region;
		this.validTill = validTill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", title=" + title + ", description=" + description + ", region=" + region
				+ ", validTill=" + validTill + "]";
	}
}
