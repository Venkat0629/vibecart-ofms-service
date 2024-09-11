package com.nisum.vibe.cart.offers.model;

import com.nisum.vibe.cart.offers.common.OfferDiscountType;
import com.nisum.vibe.cart.offers.common.OfferStatus;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class OfferDTO implements Serializable {

    private Long offerId;
    private String offerName;
    private String offerDescription;
    private Integer offerQuantity;
    private Integer offerUsageQuantity;
    private OfferStatus offerStatus;
    private OfferDiscountType offerDiscountType;
    private Double offerDiscountValue;
    private List<OfferItemDTO> offerItems;
    private LocalDate offerStartDate;
    private LocalDate offerEndDate;
    private Instant offerCreatedAt;

    public Long getOfferId() {
        return offerId;
    }

    public OfferDTO setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }

    public String getOfferName() {
        return offerName;
    }

    public OfferDTO setOfferName(String offerName) {
        this.offerName = offerName;
        return this;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public OfferDTO setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
        return this;
    }

    public Integer getOfferQuantity() {
        return offerQuantity;
    }

    public OfferDTO setOfferQuantity(Integer offerQuantity) {
        this.offerQuantity = offerQuantity;
        return this;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public OfferDTO setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    }

    public OfferDiscountType getOfferDiscountType() {
        return offerDiscountType;
    }

    public OfferDTO setOfferDiscountType(OfferDiscountType offerDiscountType) {
        this.offerDiscountType = offerDiscountType;
        return this;
    }

    public Double getOfferDiscountValue() {
        return offerDiscountValue;
    }

    public OfferDTO setOfferDiscountValue(Double offerDiscountValue) {
        this.offerDiscountValue = offerDiscountValue;
        return this;
    }

    public List<OfferItemDTO> getOfferItems() {
        return offerItems;
    }

    public OfferDTO setOfferItems(List<OfferItemDTO> offerItems) {
        this.offerItems = offerItems;
        return this;
    }

    public Integer getOfferUsageQuantity() {
        return offerUsageQuantity;
    }

    public OfferDTO setOfferUsageQuantity(Integer offerUsageQuantity) {
        this.offerUsageQuantity = offerUsageQuantity;
        return this;
    }

    public LocalDate getOfferStartDate() {
        return offerStartDate;
    }

    public OfferDTO setOfferStartDate(LocalDate offerStartDate) {
        this.offerStartDate = offerStartDate;
        return this;
    }

    public LocalDate getOfferEndDate() {
        return offerEndDate;
    }

    public OfferDTO setOfferEndDate(LocalDate offerEndDate) {
        this.offerEndDate = offerEndDate;
        return this;
    }

    public Instant getOfferCreatedAt() {
        return offerCreatedAt;
    }

    public OfferDTO setOfferCreatedAt(Instant offerCreatedAt) {
        this.offerCreatedAt = offerCreatedAt;
        return this;
    }

}
