package com.nisum.vibe.cart.offers.controller;

import com.nisum.vibe.cart.offers.common.OfferOn;
import com.nisum.vibe.cart.offers.common.OfferStatus;
import com.nisum.vibe.cart.offers.dto.Response;
import com.nisum.vibe.cart.offers.dto.*;
import com.nisum.vibe.cart.offers.service.OfferManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

/**
 * Controller for managing offers in the VibeCart application.
 * Provides endpoints to create, read, update, delete, and manage offers.
 */
@RestController
@RequestMapping("/api/v1/vibe-cart/offers")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class OfferManagementController {

    private static final Logger logger = LoggerFactory.getLogger(OfferManagementController.class);
    private final OfferManagementService offerManagementService;

    public OfferManagementController(OfferManagementService offerManagementService) {
        this.offerManagementService = offerManagementService;
    }

    /**
     * Retrieves all offers.
     *
     * @return a list of all offers.
     */
    @GetMapping
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        logger.debug("Fetching all offers");
        List<OfferDTO> offers = offerManagementService.getAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    /**
     * Retrieves an offer by its ID.
     *
     * @param id the ID of the offer to retrieve.
     * @return the offer with the specified ID or a 404 Not Found status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable Long id) {
        logger.debug("Fetching offer with ID {}", id);
        OfferDTO offerDTO = offerManagementService.getOfferById(id);
        if (offerDTO != null) {
            return new ResponseEntity<>(offerDTO, HttpStatus.OK);
        } else {
            logger.warn("Offer with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves an offer by its name.
     *
     * @param offerName the name of the offer to retrieve.
     * @return the offer with the specified name or a 404 Not Found status if not found.
     */
    @GetMapping("/name")
    public ResponseEntity<OfferDTO> getOfferByName(@RequestParam String offerName) {
        logger.debug("Fetching offer with name {}", offerName);
        OfferDTO offerDTO = offerManagementService.getOfferByName(offerName);
        if (offerDTO != null) {
            return new ResponseEntity<>(offerDTO, HttpStatus.OK);
        } else {
            logger.warn("Offer with name {} not found", offerName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves offers associated with a product ID.
     *
     * @param id the product ID.
     * @return a list of offers associated with the product ID.
     */
    @GetMapping("/item/{id}")
    public ResponseEntity<List<Offer>> getOfferByProductId(@PathVariable Long id) {
        logger.debug("Fetching offers for product ID {}", id);
        List<Offer> offers = offerManagementService.getOfferByEntityId(id, OfferOn.ITEM);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    /**
     * Retrieves offers associated with an item ID.
     *
     * @param id the item ID.
     * @return a list of offers associated with the item ID.
     */
    @GetMapping("/sku/{id}")
    public ResponseEntity<List<Offer>> getOfferByItemId(@PathVariable Long id) {
        logger.debug("Fetching offers for SKU ID {}", id);
        List<Offer> offers = offerManagementService.getOfferByEntityId(id, OfferOn.SKU);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    /**
     * Retrieves offers by bill.
     *
     * @return a list of offers associated with the coupon code.
     */

    @GetMapping("/bill")
    public ResponseEntity<List<Offer>> getOfferByBill() {
        List<Offer> offer = offerManagementService.getOfferByBill();
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    /**
     * Retrieves offers by coupon code.
     *
     * @param code the coupon code.
     * @return a list of offers associated with the coupon code.
     */
    @GetMapping("/coupon/{code}")
    public ResponseEntity<List<Offer>> getOfferByCoupon(@PathVariable String code) {
        logger.debug("Fetching offers for coupon code {}", code);
        List<Offer> offers = offerManagementService.getOfferByCoupon(code);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    /**
     * Creates a new offer.
     *
     * @param offerDTO the offer details.
     * @return the created offer.
     */
    @PostMapping
    public ResponseEntity<OfferDTO> createOffer(@RequestBody OfferDTO offerDTO) {
        logger.debug("Creating new offer {}", offerDTO);
        OfferDTO createdOffer = offerManagementService.createOffer(offerDTO);
        return new ResponseEntity<>(createdOffer, HttpStatus.CREATED);
    }

    /**
     * Updates an existing offer.
     *
     * @param offerDTO the updated offer details.
     * @param id       the ID of the offer to update.
     * @return the updated offer.
     */
    @PutMapping("/{id}")
    public ResponseEntity<OfferDTO> updateOffer(@RequestBody OfferDTO offerDTO, @PathVariable Long id) {
        logger.debug("Updating offer with ID {} to {}", id, offerDTO);
        OfferDTO updatedOffer = offerManagementService.updateOffer(offerDTO, id);
        return new ResponseEntity<>(updatedOffer, HttpStatus.OK);
    }

    /**
     * Deletes an offer by its ID.
     *
     * @param id the ID of the offer to delete.
     * @return a response indicating the result of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteOffer(@PathVariable Long id) {
        logger.debug("Deleting offer with ID {}", id);
        String message = offerManagementService.deleteOffer(id);
        Response response = new Response(message, HttpStatus.NO_CONTENT.getReasonPhrase(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Updates the status of an offer.
     *
     * @param id     the ID of the offer.
     * @param status the new status of the offer.
     * @return a response indicating the result of the status update.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Response> updateOfferStatus(@PathVariable Long id, @RequestParam Boolean status) {
        logger.debug("Updating status of offer with ID {} to {}", id, status ? "ACTIVE" : "INACTIVE");
        OfferStatus offerStatus = offerManagementService.updateOfferStatus(id, status ? OfferStatus.ACTIVE : OfferStatus.INACTIVE);
        Response response = new Response(offerStatus, HttpStatus.NO_CONTENT.getReasonPhrase(), Instant.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Updates the usage details of an offer.
     *
     * @param id            the ID of the offer.
     * @param offerUsageDTO the updated offer usage details.
     * @return the updated offer usage details.
     */
    @PutMapping("/usage/{id}")
    public ResponseEntity<OfferUsageDTO> updateOfferUsage(@PathVariable Long id, @RequestBody OfferUsageDTO offerUsageDTO) {
        logger.debug("Updating usage of offer with ID {} to {}", id, offerUsageDTO);
        OfferUsageDTO updatedOfferUsageDTO = offerManagementService.updateOfferUsage(id, offerUsageDTO);
        return new ResponseEntity<>(updatedOfferUsageDTO, HttpStatus.OK);
    }
}
