package com.nisum.vibe.cart.offers.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * Represents the usage of an offer by a customer in the system. This entity is mapped to the "vibe_cart_offer_usage" table in the database.
 */
@Entity
@Table(name = "vibe_cart_offer_usage")
public class OfferUsageDAO implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OfferUsageDAO.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_usage_id")
    private Long offerUsageId;

    @Column(name = "offer_id")
    private Long offerId;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "email")
    private String email;

    @Column(name = "offer_status_created_at", nullable = false, updatable = false)
    private Instant offerStatusCreatedAt;

    @Column(name = "offer_status_updated_at", nullable = false)
    private Instant offerStatusUpdatedAt;

    @PrePersist
    protected void onCreate() {
        offerStatusCreatedAt = Instant.now();
        offerStatusUpdatedAt = Instant.now();
        logger.debug("OfferUsageDAO created with ID: {}", offerUsageId);
    }

    @PreUpdate
    protected void onUpdate() {
        offerStatusUpdatedAt = Instant.now();
        logger.debug("OfferUsageDAO updated with ID: {}", offerUsageId);
    }

    /**
     * Gets the unique identifier for this offer usage record.
     *
     * @return the offer usage ID
     */
    public Long getOfferUsageId() {
        logger.debug("Getting offer usage ID: {}", offerUsageId);
        return offerUsageId;
    }

    /**
     * Sets the unique identifier for this offer usage record.
     *
     * @param offerUsageId the offer usage ID
     * @return the current instance of OfferUsageDAO
     */
    public OfferUsageDAO setOfferUsageId(Long offerUsageId) {
        logger.debug("Setting offer usage ID: {}", offerUsageId);
        this.offerUsageId = offerUsageId;
        return this;
    }

    /**
     * Gets the offer ID associated with this offer usage record.
     *
     * @return the offer ID
     */
    public Long getOfferId() {
        logger.debug("Getting offer ID: {}", offerId);
        return offerId;
    }

    /**
     * Sets the offer ID associated with this offer usage record.
     *
     * @param offerId the offer ID
     * @return the current instance of OfferUsageDAO
     */
    public OfferUsageDAO setOfferId(Long offerId) {
        logger.debug("Setting offer ID: {}", offerId);
        this.offerId = offerId;
        return this;
    }

    /**
     * Gets the order ID associated with this offer usage record.
     *
     * @return the order ID
     */
    public String getOrderId() {
        logger.debug("Getting order ID: {}", orderId);
        return orderId;
    }

    /**
     * Sets the order ID associated with this offer usage record.
     *
     * @param orderId the order ID
     */
    public void setOrderId(String orderId) {
        logger.debug("Setting order ID: {}", orderId);
        this.orderId = orderId;
    }

    /**
     * Gets the customer ID associated with this offer usage record.
     *
     * @return the customer ID
     */
    public Long getCustomerId() {
        logger.debug("Getting customer ID: {}", customerId);
        return customerId;
    }

    /**
     * Sets the customer ID associated with this offer usage record.
     *
     * @param customerId the customer ID
     */
    public void setCustomerId(Long customerId) {
        logger.debug("Setting customer ID: {}", customerId);
        this.customerId = customerId;
    }

    /**
     * Gets the email of the customer associated with this offer usage record.
     *
     * @return the email
     */
    public String getEmail() {
        logger.debug("Getting email: {}", email);
        return email;
    }

    /**
     * Sets the email of the customer associated with this offer usage record.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        logger.debug("Setting email: {}", email);
        this.email = email;
    }

    /**
     * Gets the timestamp when this offer usage record was created.
     *
     * @return the creation timestamp
     */
    public Instant getOfferStatusCreatedAt() {
        logger.debug("Getting offer status created at: {}", offerStatusCreatedAt);
        return offerStatusCreatedAt;
    }

    /**
     * Sets the timestamp when this offer usage record was created.
     *
     * @param offerStatusCreatedAt the creation timestamp
     */
    public void setOfferStatusCreatedAt(Instant offerStatusCreatedAt) {
        logger.debug("Setting offer status created at: {}", offerStatusCreatedAt);
        this.offerStatusCreatedAt = offerStatusCreatedAt;
    }

    /**
     * Gets the timestamp when this offer usage record was last updated.
     *
     * @return the last updated timestamp
     */
    public Instant getOfferStatusUpdatedAt() {
        logger.debug("Getting offer status updated at: {}", offerStatusUpdatedAt);
        return offerStatusUpdatedAt;
    }

    /**
     * Sets the timestamp when this offer usage record was last updated.
     *
     * @param offerStatusUpdatedAt the last updated timestamp
     */
    public void setOfferStatusUpdatedAt(Instant offerStatusUpdatedAt) {
        logger.debug("Setting offer status updated at: {}", offerStatusUpdatedAt);
        this.offerStatusUpdatedAt = offerStatusUpdatedAt;
    }
}
