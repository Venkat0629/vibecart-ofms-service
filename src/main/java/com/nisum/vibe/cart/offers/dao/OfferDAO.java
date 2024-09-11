package com.nisum.vibe.cart.offers.dao;

import com.nisum.vibe.cart.offers.common.OfferDiscountType;
import com.nisum.vibe.cart.offers.common.OfferStatus;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * Represents an offer in the system. This entity is mapped to the "vibe_cart_offers" table in the database.
 */
@Entity
@Table(name = "vibe_cart_offers")
public class OfferDAO implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OfferDAO.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @NotNull
    private String offerName;

    @NotNull
    private String offerDescription;

    @NotNull
    private Integer offerQuantity;

    @NotNull
    private Integer offerUsageQuantity;

    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    @Enumerated(EnumType.STRING)
    private OfferDiscountType offerDiscountType;

    private double offerDiscountValue;

    @OneToMany(mappedBy = "offerDAO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OfferItemDAO> offerItems;

    private LocalDate offerStartDate;
    private LocalDate offerEndDate;
    private Instant offerCreatedAt;
    private Instant offerUpdatedAt;

    /**
     * Gets the ID of the offer.
     *
     * @return the offer ID.
     */
    public Long getOfferId() {
        logger.debug("Getting offer ID: {}", offerId);
        return offerId;
    }

    /**
     * Sets the ID of the offer.
     *
     * @param offerId the offer ID to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferId(Long offerId) {
        logger.debug("Setting offer ID: {}", offerId);
        this.offerId = offerId;
        return this;
    }

    /**
     * Gets the name of the offer.
     *
     * @return the offer name.
     */
    public String getOfferName() {
        logger.debug("Getting offer name: {}", offerName);
        return offerName;
    }

    /**
     * Sets the name of the offer.
     *
     * @param offerName the offer name to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferName(String offerName) {
        logger.debug("Setting offer name: {}", offerName);
        this.offerName = offerName;
        return this;
    }

    /**
     * Gets the description of the offer.
     *
     * @return the offer description.
     */
    public String getOfferDescription() {
        logger.debug("Getting offer description: {}", offerDescription);
        return offerDescription;
    }

    /**
     * Sets the description of the offer.
     *
     * @param offerDescription the offer description to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferDescription(String offerDescription) {
        logger.debug("Setting offer description: {}", offerDescription);
        this.offerDescription = offerDescription;
        return this;
    }

    /**
     * Gets the quantity of the offer.
     *
     * @return the offer quantity.
     */
    public Integer getOfferQuantity() {
        logger.debug("Getting offer quantity: {}", offerQuantity);
        return offerQuantity;
    }

    /**
     * Sets the quantity of the offer.
     *
     * @param offerQuantity the offer quantity to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferQuantity(Integer offerQuantity) {
        logger.debug("Setting offer quantity: {}", offerQuantity);
        this.offerQuantity = offerQuantity;
        return this;
    }

    /**
     * Gets the status of the offer.
     *
     * @return the offer status.
     */
    public OfferStatus getOfferStatus() {
        logger.debug("Getting offer status: {}", offerStatus);
        return offerStatus;
    }

    /**
     * Sets the status of the offer.
     *
     * @param offerStatus the offer status to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferStatus(OfferStatus offerStatus) {
        logger.debug("Setting offer status: {}", offerStatus);
        this.offerStatus = offerStatus;
        return this;
    }

    /**
     * Gets the discount type of the offer.
     *
     * @return the offer discount type.
     */
    public OfferDiscountType getOfferDiscountType() {
        logger.debug("Getting offer discount type: {}", offerDiscountType);
        return offerDiscountType;
    }

    /**
     * Sets the discount type of the offer.
     *
     * @param offerDiscountType the offer discount type to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferDiscountType(OfferDiscountType offerDiscountType) {
        logger.debug("Setting offer discount type: {}", offerDiscountType);
        this.offerDiscountType = offerDiscountType;
        return this;
    }

    /**
     * Gets the discount value of the offer.
     *
     * @return the offer discount value.
     */
    public double getOfferDiscountValue() {
        logger.debug("Getting offer discount value: {}", offerDiscountValue);
        return offerDiscountValue;
    }

    /**
     * Sets the discount value of the offer.
     *
     * @param offerDiscountValue the offer discount value to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferDiscountValue(double offerDiscountValue) {
        logger.debug("Setting offer discount value: {}", offerDiscountValue);
        this.offerDiscountValue = offerDiscountValue;
        return this;
    }

    /**
     * Gets the usage quantity of the offer.
     *
     * @return the offer usage quantity.
     */
    public Integer getOfferUsageQuantity() {
        logger.debug("Getting offer usage quantity: {}", offerUsageQuantity);
        return offerUsageQuantity;
    }

    /**
     * Sets the usage quantity of the offer.
     *
     * @param offerUsageQuantity the offer usage quantity to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferUsageQuantity(Integer offerUsageQuantity) {
        logger.debug("Setting offer usage quantity: {}", offerUsageQuantity);
        this.offerUsageQuantity = offerUsageQuantity;
        return this;
    }

    /**
     * Gets the list of offer items.
     *
     * @return the list of offer items.
     */
    public List<OfferItemDAO> getOfferItems() {
        logger.debug("Getting offer items: {}", offerItems);
        return offerItems;
    }

    /**
     * Sets the list of offer items.
     *
     * @param offerItems the list of offer items to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferItems(List<OfferItemDAO> offerItems) {
        logger.debug("Setting offer items: {}", offerItems);
        this.offerItems = offerItems;
        return this;
    }

    /**
     * Gets the start date of the offer.
     *
     * @return the offer start date.
     */
    public LocalDate getOfferStartDate() {
        logger.debug("Getting offer start date: {}", offerStartDate);
        return offerStartDate;
    }

    /**
     * Sets the start date of the offer.
     *
     * @param offerStartDate the offer start date to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferStartDate(LocalDate offerStartDate) {
        logger.debug("Setting offer start date: {}", offerStartDate);
        this.offerStartDate = offerStartDate;
        return this;
    }

    /**
     * Gets the end date of the offer.
     *
     * @return the offer end date.
     */
    public LocalDate getOfferEndDate() {
        logger.debug("Getting offer end date: {}", offerEndDate);
        return offerEndDate;
    }

    /**
     * Sets the end date of the offer.
     *
     * @param offerEndDate the offer end date to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferEndDate(LocalDate offerEndDate) {
        logger.debug("Setting offer end date: {}", offerEndDate);
        this.offerEndDate = offerEndDate;
        return this;
    }

    /**
     * Gets the creation timestamp of the offer.
     *
     * @return the offer creation timestamp.
     */
    public Instant getOfferCreatedAt() {
        logger.debug("Getting offer created at: {}", offerCreatedAt);
        return offerCreatedAt;
    }

    /**
     * Sets the creation timestamp of the offer.
     *
     * @param offerCreatedAt the offer creation timestamp to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferCreatedAt(Instant offerCreatedAt) {
        logger.debug("Setting offer created at: {}", offerCreatedAt);
        this.offerCreatedAt = offerCreatedAt;
        return this;
    }

    /**
     * Gets the last updated timestamp of the offer.
     *
     * @return the offer last updated timestamp.
     */
    public Instant getOfferUpdatedAt() {
        logger.debug("Getting offer updated at: {}", offerUpdatedAt);
        return offerUpdatedAt;
    }

    /**
     * Sets the last updated timestamp of the offer.
     *
     * @param offerUpdatedAt the offer last updated timestamp to set.
     * @return the current instance of {@code OfferDAO}.
     */
    public OfferDAO setOfferUpdatedAt(Instant offerUpdatedAt) {
        logger.debug("Setting offer updated at: {}", offerUpdatedAt);
        this.offerUpdatedAt = offerUpdatedAt;
        return this;
    }
}
