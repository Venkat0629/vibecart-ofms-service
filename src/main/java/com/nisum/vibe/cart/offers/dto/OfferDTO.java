package com.nisum.vibe.cart.offers.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nisum.vibe.cart.offers.common.OfferDiscountType;
import com.nisum.vibe.cart.offers.common.OfferStatus;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing an offer with various attributes.
 */
public class OfferDTO implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OfferDTO.class);

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
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferId(Long offerId) {
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
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferName(String offerName) {
        logger.debug("Setting offer name: {}", offerName);
        this.offerName = offerName;
        return this;
    }

    /**
     * Gets the offer description.
     *
     * @return the offer description
     */
    public String getOfferDescription() {
        logger.debug("Getting offer description: {}", offerDescription);
        return offerDescription;
    }

    /**
     * Sets the offer description.
     *
     * @param offerDescription the offer description
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferDescription(String offerDescription) {
        logger.debug("Setting offer description: {}", offerDescription);
        this.offerDescription = offerDescription;
        return this;
    }

    /**
     * Gets the offer quantity.
     *
     * @return the offer quantity
     */
    public Integer getOfferQuantity() {
        logger.debug("Getting offer quantity: {}", offerQuantity);
        return offerQuantity;
    }

    /**
     * Sets the offer quantity.
     *
     * @param offerQuantity the offer quantity
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferQuantity(Integer offerQuantity) {
        logger.debug("Setting offer quantity: {}", offerQuantity);
        this.offerQuantity = offerQuantity;
        return this;
    }

    /**
     * Gets the offer usage quantity.
     *
     * @return the offer usage quantity
     */
    public Integer getOfferUsageQuantity() {
        logger.debug("Getting offer usage quantity: {}", offerUsageQuantity);
        return offerUsageQuantity;
    }

    /**
     * Sets the offer usage quantity.
     *
     * @param offerUsageQuantity the offer usage quantity
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferUsageQuantity(Integer offerUsageQuantity) {
        logger.debug("Setting offer usage quantity: {}", offerUsageQuantity);
        this.offerUsageQuantity = offerUsageQuantity;
        return this;
    }

    /**
     * Gets the offer status.
     *
     * @return the offer status
     */
    public OfferStatus getOfferStatus() {
        logger.debug("Getting offer status: {}", offerStatus);
        return offerStatus;
    }

    /**
     * Sets the offer status.
     *
     * @param offerStatus the offer status
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferStatus(OfferStatus offerStatus) {
        logger.debug("Setting offer status: {}", offerStatus);
        this.offerStatus = offerStatus;
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
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferDiscountType(OfferDiscountType offerDiscountType) {
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
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferDiscountValue(Double offerDiscountValue) {
        logger.debug("Setting offer discount value: {}", offerDiscountValue);
        this.offerDiscountValue = offerDiscountValue;
        return this;
    }

    /**
     * Gets the list of offer items.
     *
     * @return the list of offer items
     */
    public List<OfferItemDTO> getOfferItems() {
        logger.debug("Getting offer items: {}", offerItems);
        return offerItems;
    }

    /**
     * Sets the list of offer items.
     *
     * @param offerItems the list of offer items
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferItems(List<OfferItemDTO> offerItems) {
        logger.debug("Setting offer items: {}", offerItems);
        this.offerItems = offerItems;
        return this;
    }

    /**
     * Gets the offer start date.
     *
     * @return the offer start date
     */
    public LocalDate getOfferStartDate() {
        logger.debug("Getting offer start date: {}", offerStartDate);
        return offerStartDate;
    }

    /**
     * Sets the offer start date.
     *
     * @param offerStartDate the offer start date
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferStartDate(LocalDate offerStartDate) {
        logger.debug("Setting offer start date: {}", offerStartDate);
        this.offerStartDate = offerStartDate;
        return this;
    }

    /**
     * Gets the offer end date.
     *
     * @return the offer end date
     */
    public LocalDate getOfferEndDate() {
        logger.debug("Getting offer end date: {}", offerEndDate);
        return offerEndDate;
    }

    /**
     * Sets the offer end date.
     *
     * @param offerEndDate the offer end date
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferEndDate(LocalDate offerEndDate) {
        logger.debug("Setting offer end date: {}", offerEndDate);
        this.offerEndDate = offerEndDate;
        return this;
    }

    /**
     * Gets the offer creation timestamp.
     *
     * @return the offer creation timestamp
     */
    public Instant getOfferCreatedAt() {
        logger.debug("Getting offer created at: {}", offerCreatedAt);
        return offerCreatedAt;
    }

    /**
     * Sets the offer creation timestamp.
     *
     * @param offerCreatedAt the offer creation timestamp
     * @return the current instance of OfferDTO
     */
    public OfferDTO setOfferCreatedAt(Instant offerCreatedAt) {
        logger.debug("Setting offer created at: {}", offerCreatedAt);
        this.offerCreatedAt = offerCreatedAt;
        return this;
    }
}
