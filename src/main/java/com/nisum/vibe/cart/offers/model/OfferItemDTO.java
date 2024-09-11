package com.nisum.vibe.cart.offers.model;

import com.nisum.vibe.cart.offers.common.OfferOn;
import com.nisum.vibe.cart.offers.common.OfferType;

import java.io.Serializable;

public class OfferItemDTO implements Serializable {

    private Long offerTypeId;
    private OfferType offerType;
    private OfferOn offerOn;
    private Long skuId;
    private Long itemId;
    private Double billAmount;
    private String couponCode;

    public Long getOfferTypeId() {
        return offerTypeId;
    }

    public OfferItemDTO setOfferTypeId(Long offerTypeId) {
        this.offerTypeId = offerTypeId;
        return this;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public OfferItemDTO setOfferType(OfferType offerType) {
        this.offerType = offerType;
        return this;
    }

    public Long getSkuId() {
        return skuId;
    }

    public OfferItemDTO setSkuId(Long skuId) {
        this.skuId = skuId;
        return this;
    }

    public Long getItemId() {
        return itemId;
    }

    public OfferItemDTO setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public OfferItemDTO setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
        return this;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public OfferItemDTO setCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public OfferOn getOfferOn() {
        return offerOn;
    }

    public OfferItemDTO setOfferOn(OfferOn offerOn) {
        this.offerOn = offerOn;
        return this;
    }
}
