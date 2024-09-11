package com.nisum.vibe.cart.offers.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nisum.vibe.cart.offers.common.OfferDiscountType;
import com.nisum.vibe.cart.offers.common.OfferType;

/**
 * Represents an offer with details such as offer ID, name, discount type,
 * discount value, offer type, bill amount and offer description.
 */
public class Offer {

    private static final Logger logger = LoggerFactory.getLogger(Offer.class);

    private Long offerId;
    private String offerName;
    private OfferDiscountType offerDiscountType;
    private Double offerDiscountValue;
    private OfferType offerType;
    private Double billAmount;
    private String offerDescription;

    /**
     * Gets the offer ID.
     *
     * @return the offer ID
     */
    public Long getOfferId() {
        logger.debug("Getting offer ID: {}", offerId);
        return offerId;
    }

    /**
     * Sets the offer ID.
     *
     * @param offerId the offer ID
     * @return the current instance of Offer
     */
    public Offer setOfferId(Long offerId) {
        logger.debug("Setting offer ID: {}", offerId);
        this.offerId = offerId;
        return this;
    }

    /**
     * Gets the offer name.
     *
     * @return the offer name
     */
    public String getOfferName() {
        logger.debug("Getting offer name: {}", offerName);
        return offerName;
    }

    /**
     * Sets the offer name.
     *
     * @param offerName the offer name
     * @return the current instance of Offer
     */
    public Offer setOfferName(String offerName) {
        logger.debug("Setting offer name: {}", offerName);
        this.offerName = offerName;
        return this;
    }

    /**
     * Gets the offer discount type.
     *
     * @return the offer discount type
     */
    public OfferDiscountType getOfferDiscountType() {
        logger.debug("Getting offer discount type: {}", offerDiscountType);
        return offerDiscountType;
    }

    /**
     * Sets the offer discount type.
     *
     * @param offerDiscountType the offer discount type
     * @return the current instance of Offer
     */
    public Offer setOfferDiscountType(OfferDiscountType offerDiscountType) {
        logger.debug("Setting offer discount type: {}", offerDiscountType);
        this.offerDiscountType = offerDiscountType;
        return this;
    }

    /**
     * Gets the offer discount value.
     *
     * @return the offer discount value
     */
    public Double getOfferDiscountValue() {
        logger.debug("Getting offer discount value: {}", offerDiscountValue);
        return offerDiscountValue;
    }

    /**
     * Sets the offer discount value.
     *
     * @param offerDiscountValue the offer discount value
     * @return the current instance of Offer
     */
    public Offer setOfferDiscountValue(Double offerDiscountValue) {
        logger.debug("Setting offer discount value: {}", offerDiscountValue);
        this.offerDiscountValue = offerDiscountValue;
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
     * @return the current instance of Offer
     */
    public Offer setOfferType(OfferType offerType) {
        logger.debug("Setting offer type: {}", offerType);
        this.offerType = offerType;
        return this;
    }

    /**
     * Gets the bill amount associated with the offer.
     *
     * @return the bill amount
     */
    public Double getBillAmount() {
        logger.debug("Getting bill amount: {}", billAmount);
        return billAmount;
    }

    /**
     * Sets the bill amount associated with the offer.
     *
     * @param billAmount the bill amount
     * @return the current instance of Offer
     */
    public Offer setBillAmount(Double billAmount) {
        logger.debug("Setting bill amount: {}", billAmount);
        this.billAmount = billAmount;
        return this;
    }

    /**
     * Gets the offer description.
     *
     * @return the offer description
     */
    public String getOfferDescription() {
        return offerDescription;
    }

    /**
     * Sets the offer description associated with the offer.
     *
     * @param offerDescription the bill amount
     * @return the current instance of Offer
     */

    public Offer setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
        return this;
    }
}
