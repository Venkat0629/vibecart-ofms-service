package com.nisum.vibe.cart.offers.model;

import com.nisum.vibe.cart.offers.common.OfferDiscountType;
import com.nisum.vibe.cart.offers.common.OfferType;

public class Offer {
    private Long offerId;
    private String offerName;
    private OfferDiscountType offerDiscountType;
    private Double offerDiscountValue;
    private OfferType offerType;
    private Double billAmount;

    public Long getOfferId() {
        return offerId;
    }

    public Offer setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }

    public String getOfferName() {
        return offerName;
    }

    public Offer setOfferName(String offerName) {
        this.offerName = offerName;
        return this;
    }

    public OfferDiscountType getOfferDiscountType() {
        return offerDiscountType;
    }

    public Offer setOfferDiscountType(OfferDiscountType offerDiscountType) {
        this.offerDiscountType = offerDiscountType;
        return this;
    }

    public Double getOfferDiscountValue() {
        return offerDiscountValue;
    }

    public Offer setOfferDiscountValue(Double offerDiscountValue) {
        this.offerDiscountValue = offerDiscountValue;
        return this;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public Offer setOfferType(OfferType offerType) {
        this.offerType = offerType;
        return this;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public Offer setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
        return this;
    }
}
