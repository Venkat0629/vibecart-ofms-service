package com.nisum.vibe.cart.offers.service;

import com.nisum.vibe.cart.offers.common.OfferOn;
import com.nisum.vibe.cart.offers.common.OfferStatus;
import com.nisum.vibe.cart.offers.dto.OfferDTO;
import com.nisum.vibe.cart.offers.dto.Offer;
import com.nisum.vibe.cart.offers.dto.OfferUsageDTO;

import java.util.List;

public interface OfferManagementService {
    List<OfferDTO> getAllOffers();

    OfferDTO getOfferById(Long id);

    OfferDTO createOffer(OfferDTO offerDTO);

    OfferDTO updateOffer(OfferDTO offerDTO, Long id);

    String deleteOffer(Long id);

    OfferDTO getOfferByName(String offerName);

    List<Offer> getOfferByEntityId(Long sku, OfferOn offerOn);

    List<Offer> getOfferByCoupon(String code);

    List<Offer> getOfferByBill();

    OfferStatus updateOfferStatus(Long id, OfferStatus status);

    OfferUsageDTO updateOfferUsage(Long id, OfferUsageDTO offerUsageDTO);

}
