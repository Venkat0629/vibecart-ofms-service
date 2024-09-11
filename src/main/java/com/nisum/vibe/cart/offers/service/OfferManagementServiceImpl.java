package com.nisum.vibe.cart.offers.service;

import com.nisum.vibe.cart.offers.common.OfferOn;
import com.nisum.vibe.cart.offers.common.OfferStatus;
import com.nisum.vibe.cart.offers.common.OfferType;
import com.nisum.vibe.cart.offers.constants.OfferManagementConstants;
import com.nisum.vibe.cart.offers.dao.OfferDAO;
import com.nisum.vibe.cart.offers.dao.OfferItemDAO;
import com.nisum.vibe.cart.offers.dao.OfferUsageDAO;
import com.nisum.vibe.cart.offers.exception.*;
import com.nisum.vibe.cart.offers.dto.*;
import com.nisum.vibe.cart.offers.repository.OfferItemRepository;
import com.nisum.vibe.cart.offers.repository.OfferRepository;
import com.nisum.vibe.cart.offers.repository.OfferUsageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the Offer Management Service for handling offers in the system.
 */
@Service
public class OfferManagementServiceImpl implements OfferManagementService {

    private static final Logger logger = LoggerFactory.getLogger(OfferManagementServiceImpl.class);

    private final OfferRepository offerRepository;
    private final OfferItemRepository offerItemRepository;
    private final OfferUsageRepository offerUsageRepository;

    public OfferManagementServiceImpl(OfferRepository offerRepository, OfferItemRepository offerItemRepository, OfferUsageRepository offerUsageRepository) {
        this.offerRepository = offerRepository;
        this.offerItemRepository = offerItemRepository;
        this.offerUsageRepository = offerUsageRepository;
    }

    /**
     * Retrieves all offers except those that are shelved.
     *
     * @return List of OfferDTOs representing active offers.
     */
    @Override
    public List<OfferDTO> getAllOffers() {
        logger.info("Fetching all offers");
        List<OfferDAO> offerDAOList = offerRepository.findAll();
        return offerDAOList.stream().map(this::convertDTOFromDAO)
//                .filter(offer -> offer.getOfferStatus() != OfferStatus.SHELVED)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves an offer by its ID.
     *
     * @param id The ID of the offer.
     * @return The OfferDTO corresponding to the given ID.
     * @throws OfferNotFoundException if the offer does not exist.
     */
    @Override
    public OfferDTO getOfferById(Long id) {
        logger.info("Fetching offer by ID: {}", id);
        Optional<OfferDAO> offerDAO = offerRepository.findById(id);
        if (!offerDAO.isPresent()) {
            logger.error("Offer not found with ID: {}", id);
            throw new OfferNotFoundException(OfferManagementConstants.getExceptionMessageFormat(id));
        }
        return convertDTOFromDAO(offerDAO.get());
    }

    /**
     * Creates a new offer.
     *
     * @param offerDTO The offer details to create.
     * @return The created OfferDTO.
     * @throws InvalidRequestBody         if the request body is invalid.
     * @throws OfferAlreadyExistException if an offer with the same name already exists.
     */
    @Override
    @Transactional
    public OfferDTO createOffer(OfferDTO offerDTO) {
        logger.info("Creating new offer: {}", offerDTO.getOfferName());
        if (offerDTO == null) {
            logger.error("Invalid request body: null");
            throw new InvalidRequestBody(OfferManagementConstants.getInvalidRequestBodyExceptionMessageFormat());
        }

        Optional<OfferDAO> existingOffer = offerRepository.findByOfferName(offerDTO.getOfferName());
        if (existingOffer.isPresent()) {
            logger.error("Offer already exists with name: {}", offerDTO.getOfferName());
            throw new OfferAlreadyExistException(OfferManagementConstants.getOfferAlreadyExistExceptionMessageFormat(offerDTO.getOfferName()));
        }

        offerDTO.setOfferStatus(OfferStatus.INACTIVE);
        offerDTO.setOfferUsageQuantity(0);
        OfferValidation.validateOffer(offerDTO);

        OfferDAO offerDAO = convertDAOFromDTO(offerDTO);
        offerDAO.setOfferCreatedAt(Instant.now());
        offerDAO.setOfferUpdatedAt(Instant.now());

        offerDAO = offerRepository.save(offerDAO);
        logger.info("Offer created with ID: {}", offerDAO.getOfferId());
        return convertDTOFromDAO(offerDAO);
    }

    /**
     * Updates an existing offer.
     *
     * @param offerDTO The offer details to update.
     * @param id       The ID of the offer to update.
     * @return The updated OfferDTO.
     * @throws OfferNotFoundException if the offer does not exist.
     * @throws InvalidRequestBody     if the request body is invalid.
     */
    @Override
    @Transactional
    public OfferDTO updateOffer(OfferDTO offerDTO, Long id) {
        logger.info("Updating offer with ID: {}", id);
        Optional<OfferDAO> existingOffer = offerRepository.findById(id);
        if (!existingOffer.isPresent()) {
            logger.error("Offer not found with ID: {}", id);
            throw new OfferNotFoundException(OfferManagementConstants.getExceptionMessageFormat(id));
        }
        OfferDAO offerDAO = existingOffer.get();

        if (offerDTO == null) {
            logger.error("Invalid request body: null");
            throw new InvalidRequestBody(OfferManagementConstants.getInvalidRequestBodyExceptionMessageFormat());
        }

        if (offerDTO.getOfferName() != null) {
            offerDAO.setOfferName(offerDTO.getOfferName());
        }
        if (offerDTO.getOfferDescription() != null) {
            offerDAO.setOfferDescription(offerDTO.getOfferDescription());
        }
        if (offerDTO.getOfferQuantity() != null) {
            offerDAO.setOfferQuantity(offerDTO.getOfferQuantity());
        }
        if (offerDTO.getOfferDiscountType() != null) {
            offerDAO.setOfferDiscountType(offerDTO.getOfferDiscountType());
        }
        if (offerDTO.getOfferDiscountValue() != null) {
            offerDAO.setOfferDiscountValue(offerDTO.getOfferDiscountValue());
        }
        if (offerDTO.getOfferStatus() != null) {
            offerDAO.setOfferStatus(offerDTO.getOfferStatus());
        }
        if (offerDTO.getOfferStartDate() != null) {
            offerDAO.setOfferStartDate(offerDTO.getOfferStartDate());
        }
        if (offerDTO.getOfferEndDate() != null) {
            offerDAO.setOfferEndDate(offerDTO.getOfferEndDate());
        }
        offerDAO.setOfferUpdatedAt(Instant.now());

        OfferDTO validatedOfferDTO = convertDTOFromDAO(offerDAO);
        OfferValidation.validateOffer(validatedOfferDTO);

        offerRepository.save(offerDAO);
        logger.info("Offer updated with ID: {}", id);
        return validatedOfferDTO;
    }

    /**
     * Deletes an offer by marking it as shelved.
     *
     * @param id The ID of the offer to delete.
     * @return A message indicating the result of the deletion.
     * @throws OfferNotFoundException if the offer does not exist.
     */
    @Override
    public String deleteOffer(Long id) {
        logger.info("Deleting offer with ID: {}", id);
        Optional<OfferDAO> offerDAO = offerRepository.findById(id);
        if (!offerDAO.isPresent()) {
            logger.error("Offer not found with ID: {}", id);
            throw new OfferNotFoundException(OfferManagementConstants.getExceptionMessageFormat(id));
        }
        offerDAO.get().setOfferStatus(OfferStatus.SHELVED);
        offerRepository.save(offerDAO.get());
        logger.info("Offer shelved with ID: {}", id);
        return OfferManagementConstants.getDeleteMessage(id);
    }

    /**
     * Retrieves an offer by its name.
     *
     * @param offerName The name of the offer.
     * @return The OfferDTO corresponding to the given name.
     * @throws OfferNotFoundException if the offer does not exist.
     */
    @Override
    public OfferDTO getOfferByName(String offerName) {
        logger.info("Fetching offer by name: {}", offerName);
        Optional<OfferDAO> offerDAO = offerRepository.findByOfferName(offerName);
        if (!offerDAO.isPresent()) {
            logger.error("Offer not found with name: {}", offerName);
            throw new OfferNotFoundException(OfferManagementConstants.getExceptionMessageFormat(offerName));
        }
        return convertDTOFromDAO(offerDAO.get());
    }

    /**
     * Retrieves offers applicable to a specific entity based on its ID and type.
     *
     * @param id      The entity ID.
     * @param offerOn The type of entity the offer is applicable to.
     * @return List of applicable Offer objects.
     */
    @Override
    public List<Offer> getOfferByEntityId(Long id, OfferOn offerOn) {
        logger.info("Fetching offers for entity ID: {} and type: {}", id, offerOn);
        List<OfferDTO> offerList = getAllOffers();
        return offerList.stream().filter(offer -> entityCheck(offer, offerOn, id)).map(offer -> {
            List<OfferItemDTO> offerItemDTOs = offer.getOfferItems().stream().filter(offerItems -> null != offerItems.getItemId() && offerItems.getItemId().equals(id) || null != offerItems.getSkuId() && offerItems.getSkuId().equals(id)).collect(Collectors.toList());
            return mapOfferDTOToOffer(offer, offerItemDTOs.get(0).getOfferType());
        }).collect(Collectors.toList());
    }


    /**
     * Retrieves offers that can be redeemed using a specific coupon code.
     *
     * @param code The coupon code.
     * @return List of applicable Offer objects.
     */
    @Override
    public List<Offer> getOfferByCoupon(String code) {
        logger.info("Fetching offers for coupon code: {}", code);
        List<OfferDTO> offerList = getAllOffers();
        return offerList.stream().filter(offer -> couponCheck(offer, code)).map(offer -> mapOfferDTOToOffer(offer, OfferType.DISCOUNT_COUPONS)).collect(Collectors.toList());
    }

    /**
     * Retrieves offers that apply to the bill amount.
     *
     * @return List of applicable Offer objects.
     */
    @Override
    public List<Offer> getOfferByBill() {
        logger.info("Fetching offers applicable to bill amount");
        List<OfferDTO> offerList = getAllOffers();
        return offerList.stream().filter(offer -> offer.getOfferItems().stream().anyMatch(offerItemDTO -> offerItemDTO.getOfferType().equals(OfferType.ON_BILL_AMOUNT))).map(offer -> mapOfferDTOToOffer(offer, OfferType.ON_BILL_AMOUNT)).collect(Collectors.toList());
    }

    /**
     * Checks if the offer is applicable to the specified entity.
     *
     * @param offerDTO The offer to check.
     * @param offerOn  The type of entity the offer is applicable to.
     * @param id       The entity ID.
     * @return true if the offer is applicable, false otherwise.
     */
    protected Boolean entityCheck(OfferDTO offerDTO, OfferOn offerOn, Long id) {
        if (!offerDTO.getOfferStatus().equals(OfferStatus.ACTIVE)) return false;
        if (!(offerDTO.getOfferUsageQuantity() <= offerDTO.getOfferQuantity())) return false;
        for (OfferItemDTO offerItemDTO : offerDTO.getOfferItems()) {
            if ((offerItemDTO.getOfferType().equals(OfferType.ITEM_OFFER) || offerItemDTO.getOfferType().equals(OfferType.SKU_OFFER)) && ((offerOn.equals(OfferOn.ITEM) && offerItemDTO.getItemId().equals(id)) || (offerOn.equals(OfferOn.SKU) && offerItemDTO.getSkuId().equals(id)))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the offer is applicable for a specific coupon code.
     *
     * @param offerDTO The offer to check.
     * @param code     The coupon code.
     * @return true if the coupon is applicable, false otherwise.
     */
    protected Boolean couponCheck(OfferDTO offerDTO, String code) {
        if (!offerDTO.getOfferStatus().equals(OfferStatus.ACTIVE)) return false;
        if (!(offerDTO.getOfferUsageQuantity() <= offerDTO.getOfferQuantity())) return false;
        if (offerDTO.getOfferItems().isEmpty()) return false;
        for (OfferItemDTO offerItemDTO : offerDTO.getOfferItems()) {
            if (offerItemDTO.getOfferType().equals(OfferType.DISCOUNT_COUPONS) && offerItemDTO.getCouponCode().equals(code))
                return true;
        }
        return false;
    }

    /**
     * Updates the status of an offer.
     *
     * @param id     The ID of the offer.
     * @param status The new status to set.
     * @return The updated OfferStatus.
     * @throws OfferNotFoundException if the offer does not exist.
     */
    public OfferStatus updateOfferStatus(Long id, OfferStatus status) {
        logger.info("Updating status of offer with ID: {} to {}", id, status);
        Optional<OfferDAO> offerDAO = offerRepository.findById(id);
        if (!offerDAO.isPresent()) {
            logger.error("Offer not found with ID: {}", id);
            throw new OfferNotFoundException(OfferManagementConstants.getExceptionMessageFormat(id));
        }
        OfferDAO existingOffer = offerDAO.get();
        existingOffer.setOfferStatus(status);
        existingOffer.setOfferUpdatedAt(Instant.now());
        if (status.equals(OfferStatus.ACTIVE))
            OfferValidation.validateDate(existingOffer.getOfferStartDate(), existingOffer.getOfferEndDate());
        return offerRepository.save(existingOffer).getOfferStatus();
    }

    /**
     * Updates the usage of an offer.
     *
     * @param id            The ID of the offer to update.
     * @param offerUsageDTO The offer usage details.
     * @return The updated OfferUsageDTO.
     * @throws OfferNotFoundException if the offer does not exist.
     * @throws OfferQuantityExpired   if the offer usage quantity has expired.
     */
    @Override
    public OfferUsageDTO updateOfferUsage(Long id, OfferUsageDTO offerUsageDTO) {
        logger.info("Updating usage for offer with ID: {}", id);
        Optional<OfferDAO> offerDAO = offerRepository.findById(id);
        if (!offerDAO.isPresent()) {
            logger.error("Offer not found with ID: {}", id);
            throw new OfferNotFoundException(OfferManagementConstants.getExceptionMessageFormat(id));
        }
        OfferDAO existingOffer = offerDAO.get();
        existingOffer.setOfferUpdatedAt(Instant.now());
        OfferUsageDAO offerUsageDAO = new OfferUsageDAO();
        offerUsageDTO.setOfferId(id);
        BeanUtils.copyProperties(offerUsageDTO, offerUsageDAO);
        if (existingOffer.getOfferUsageQuantity() < existingOffer.getOfferQuantity()) {
            BeanUtils.copyProperties(offerUsageRepository.save(offerUsageDAO), offerUsageDTO);
            if (offerUsageDTO.getOfferUsageId() != null) {
                existingOffer.setOfferUsageQuantity(existingOffer.getOfferUsageQuantity() + 1);
                offerRepository.save(existingOffer);
            }
        } else {
            logger.error("Offer usage quantity expired for offer ID: {}", id);
            throw new OfferQuantityExpired(OfferManagementConstants.OFFER_QUANTITY_EXPIRED);
        }
        logger.info("Offer usage updated for offer ID: {}", id);
        return offerUsageDTO;
    }

    /**
     * Converts OfferDAO to OfferDTO.
     *
     * @param offerDAO The OfferDAO to convert.
     * @return The corresponding OfferDTO.
     */
    protected OfferDTO convertDTOFromDAO(OfferDAO offerDAO) {
        OfferDTO offerDTO = new OfferDTO();
        BeanUtils.copyProperties(offerDAO, offerDTO);
        List<OfferItemDTO> offerItems = new ArrayList<>();
        if (offerDAO.getOfferItems() != null && !offerDAO.getOfferItems().isEmpty()) {
            for (OfferItemDAO offerItemDAO : offerDAO.getOfferItems()) {
                OfferItemDTO offerItemDTO = new OfferItemDTO();
                BeanUtils.copyProperties(offerItemDAO, offerItemDTO);
                offerItems.add(offerItemDTO);
            }
            offerDTO.setOfferItems(offerItems);
        }
        return offerDTO;
    }

    /**
     * Converts OfferDTO to OfferDAO.
     *
     * @param offerDTO The OfferDTO to convert.
     * @return The corresponding OfferDAO.
     */
    protected OfferDAO convertDAOFromDTO(OfferDTO offerDTO) {
        OfferDAO offerDAO = new OfferDAO();
        BeanUtils.copyProperties(offerDTO, offerDAO);
        List<OfferItemDAO> offerItems = new ArrayList<>();
        if (offerDTO.getOfferItems() != null && !offerDTO.getOfferItems().isEmpty()) {
            for (OfferItemDTO offerItemDTO : offerDTO.getOfferItems()) {
                OfferItemDAO offerItemDAO = new OfferItemDAO();
                BeanUtils.copyProperties(offerItemDTO, offerItemDAO);
                offerItemDAO.setOfferDAO(offerDAO);
                offerItems.add(offerItemDAO);
            }
            offerDAO.setOfferItems(offerItems);
        }
        return offerDAO;
    }

    /**
     * Maps OfferDTO to Offer object.
     *
     * @param offerDTO  The OfferDTO to map.
     * @param offerType The type of the offer.
     * @return The mapped Offer object.
     */
    protected Offer mapOfferDTOToOffer(OfferDTO offerDTO, OfferType offerType) {
        Offer offer = new Offer();
        offer.setOfferDiscountType(offerDTO.getOfferDiscountType());
        offer.setOfferDiscountValue(offerDTO.getOfferDiscountValue());
        offer.setOfferId(offerDTO.getOfferId());
        offer.setOfferName(offerDTO.getOfferName());
        offer.setOfferType(offerType);
        offer.setBillAmount(offerDTO.getOfferItems().get(0).getBillAmount());
        offer.setOfferDescription(offerDTO.getOfferDescription());
        return offer;
    }
}