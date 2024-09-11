package com.nisum.vibe.cart.offers.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nisum.vibe.cart.offers.common.OfferOn;
import com.nisum.vibe.cart.offers.common.OfferType;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) representing an item associated with an offer.
 */
public class OfferItemDTO implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OfferItemDTO.class);

    private Long offerTypeId;
    private OfferType offerType;
    private OfferOn offerOn;
    private Long skuId;
    private Long itemId;
    private Double billAmount;
    private String couponCode;

    /**
     * Gets the offer type ID.
     *
     * @return the offer type ID
     */
    public Long getOfferTypeId() {
        logger.debug("Getting offer type ID: {}", offerTypeId);
        return offerTypeId;
    }

    /**
     * Sets the offer type ID.
     *
     * @param offerTypeId the offer type ID
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setOfferTypeId(Long offerTypeId) {
        logger.debug("Setting offer type ID: {}", offerTypeId);
        this.offerTypeId = offerTypeId;
        return this;
    }

    /**
     * Gets the offer type.
     *
     * @return the offer type
     */
    public OfferType getOfferType() {
        logger.debug("Getting offer type: {}", offerType);
        return offerType;
    }

    /**
     * Sets the offer type.
     *
     * @param offerType the offer type
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setOfferType(OfferType offerType) {
        logger.debug("Setting offer type: {}", offerType);
        this.offerType = offerType;
        return this;
    }

    /**
     * Gets the SKU ID.
     *
     * @return the SKU ID
     */
    public Long getSkuId() {
        logger.debug("Getting SKU ID: {}", skuId);
        return skuId;
    }

    /**
     * Sets the SKU ID.
     *
     * @param skuId the SKU ID
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setSkuId(Long skuId) {
        logger.debug("Setting SKU ID: {}", skuId);
        this.skuId = skuId;
        return this;
    }

    /**
     * Gets the item ID.
     *
     * @return the item ID
     */
    public Long getItemId() {
        logger.debug("Getting item ID: {}", itemId);
        return itemId;
    }

    /**
     * Sets the item ID.
     *
     * @param itemId the item ID
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setItemId(Long itemId) {
        logger.debug("Setting item ID: {}", itemId);
        this.itemId = itemId;
        return this;
    }

    /**
     * Gets the bill amount.
     *
     * @return the bill amount
     */
    public Double getBillAmount() {
        logger.debug("Getting bill amount: {}", billAmount);
        return billAmount;
    }

    /**
     * Sets the bill amount.
     *
     * @param billAmount the bill amount
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setBillAmount(Double billAmount) {
        logger.debug("Setting bill amount: {}", billAmount);
        this.billAmount = billAmount;
        return this;
    }

    /**
     * Gets the coupon code.
     *
     * @return the coupon code
     */
    public String getCouponCode() {
        logger.debug("Getting coupon code: {}", couponCode);
        return couponCode;
    }

    /**
     * Sets the coupon code.
     *
     * @param couponCode the coupon code
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setCouponCode(String couponCode) {
        logger.debug("Setting coupon code: {}", couponCode);
        this.couponCode = couponCode;
        return this;
    }

    /**
     * Gets the offer on attribute.
     *
     * @return the offer on attribute
     */
    public OfferOn getOfferOn() {
        logger.debug("Getting offer on: {}", offerOn);
        return offerOn;
    }

    /**
     * Sets the offer on attribute.
     *
     * @param offerOn the offer on attribute
     * @return the current instance of OfferItemDTO
     */
    public OfferItemDTO setOfferOn(OfferOn offerOn) {
        logger.debug("Setting offer on: {}", offerOn);
        this.offerOn = offerOn;
        return this;
    }
}
