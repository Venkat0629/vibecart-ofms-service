package com.nisum.vibe.cart.offers.dao;

import com.nisum.vibe.cart.offers.common.OfferOn;
import com.nisum.vibe.cart.offers.common.OfferType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * Represents an item within an offer in the system. This entity is mapped to the "vibe_cart_offer_items" table in the database.
 */
@Entity
@Table(name = "vibe_cart_offer_items")
public class OfferItemDAO implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OfferItemDAO.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerTypeId;

    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private OfferDAO offerDAO;

    @Enumerated(EnumType.STRING)
    @Column(name = "offer_type", nullable = false)
    private OfferType offerType;

    @Enumerated(EnumType.STRING)
    @Column(name = "offer_on", nullable = false)
    private OfferOn offerOn = OfferOn.NA; // Default value is 'NA'

    @Column(name = "sku_id")
    private Long skuId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "bill_amount")
    private Double billAmount;

    @Column(name = "coupon_code", length = 50)
    private String couponCode;

    @Column(name = "offer_type_created_at", nullable = false, updatable = false)
    private Instant offerTypeCreatedAt;

    @Column(name = "offer_type_updated_at", nullable = false)
    private Instant offerTypeUpdatedAt;

    @PrePersist
    protected void onCreate() {
        offerTypeCreatedAt = Instant.now();
        offerTypeUpdatedAt = Instant.now();
        logger.debug("OfferItemDAO created with ID: {}", offerTypeId);
    }

    @PreUpdate
    protected void onUpdate() {
        offerTypeUpdatedAt = Instant.now();
        logger.debug("OfferItemDAO updated with ID: {}", offerTypeId);
    }

    public Long getOfferTypeId() {
        logger.debug("Getting offer type ID: {}", offerTypeId);
        return offerTypeId;
    }

    public OfferItemDAO setOfferTypeId(Long offerTypeId) {
        logger.debug("Setting offer type ID: {}", offerTypeId);
        this.offerTypeId = offerTypeId;
        return this;
    }

    public OfferDAO getOfferDAO() {
        logger.debug("Getting associated offer DAO: {}", offerDAO);
        return offerDAO;
    }

    public OfferItemDAO setOfferDAO(OfferDAO offerDAO) {
        logger.debug("Setting associated offer DAO: {}", offerDAO);
        this.offerDAO = offerDAO;
        return this;
    }

    public OfferType getOfferType() {
        logger.debug("Getting offer type: {}", offerType);
        return offerType;
    }

    public OfferItemDAO setOfferType(OfferType offerType) {
        logger.debug("Setting offer type: {}", offerType);
        this.offerType = offerType;
        return this;
    }

    public OfferOn getOfferOn() {
        logger.debug("Getting offer on: {}", offerOn);
        return offerOn;
    }

    public OfferItemDAO setOfferOn(OfferOn offerOn) {
        logger.debug("Setting offer on: {}", offerOn);
        this.offerOn = offerOn;
        return this;
    }

    public Long getSkuId() {
        logger.debug("Getting SKU ID: {}", skuId);
        return skuId;
    }

    public OfferItemDAO setSkuId(Long skuId) {
        logger.debug("Setting SKU ID: {}", skuId);
        this.skuId = skuId;
        return this;
    }

    public Long getItemId() {
        logger.debug("Getting item ID: {}", itemId);
        return itemId;
    }

    public OfferItemDAO setItemId(Long itemId) {
        logger.debug("Setting item ID: {}", itemId);
        this.itemId = itemId;
        return this;
    }

    public Double getBillAmount() {
        logger.debug("Getting bill amount: {}", billAmount);
        return billAmount;
    }

    public OfferItemDAO setBillAmount(Double billAmount) {
        logger.debug("Setting bill amount: {}", billAmount);
        this.billAmount = billAmount;
        return this;
    }

    public String getCouponCode() {
        logger.debug("Getting coupon code: {}", couponCode);
        return couponCode;
    }

    public OfferItemDAO setCouponCode(String couponCode) {
        logger.debug("Setting coupon code: {}", couponCode);
        this.couponCode = couponCode;
        return this;
    }

    public Instant getOfferTypeCreatedAt() {
        logger.debug("Getting offer type created at: {}", offerTypeCreatedAt);
        return offerTypeCreatedAt;
    }

    public OfferItemDAO setOfferTypeCreatedAt(Instant offerTypeCreatedAt) {
        logger.debug("Setting offer type created at: {}", offerTypeCreatedAt);
        this.offerTypeCreatedAt = offerTypeCreatedAt;
        return this;
    }

    public Instant getOfferTypeUpdatedAt() {
        logger.debug("Getting offer type updated at: {}", offerTypeUpdatedAt);
        return offerTypeUpdatedAt;
    }

    public OfferItemDAO setOfferTypeUpdatedAt(Instant offerTypeUpdatedAt) {
        logger.debug("Setting offer type updated at: {}", offerTypeUpdatedAt);
        this.offerTypeUpdatedAt = offerTypeUpdatedAt;
        return this;
    }
}
