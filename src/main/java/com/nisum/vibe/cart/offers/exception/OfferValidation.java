package com.nisum.vibe.cart.offers.exception;

import com.nisum.vibe.cart.offers.common.ExceptionType;
import com.nisum.vibe.cart.offers.common.OfferType;
import com.nisum.vibe.cart.offers.constants.OfferManagementConstants;
import com.nisum.vibe.cart.offers.dto.OfferDTO;
import com.nisum.vibe.cart.offers.dto.OfferItemDTO;

import java.time.LocalDate;

public class OfferValidation {

    public static void validateOffer(OfferDTO offerDTO) {
        if (offerDTO.getOfferName() == null || offerDTO.getOfferName().trim().isEmpty()) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_NAME, offerDTO.getOfferName() == null ? ExceptionType.NULL : ExceptionType.EMPTY));
        }
        if (offerDTO.getOfferDescription() == null) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_DESCRIPTION, ExceptionType.NULL));
        }
        if (offerDTO.getOfferQuantity() == null || offerDTO.getOfferQuantity() <= 0) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_QUANTITY, offerDTO.getOfferQuantity() == null ? ExceptionType.NULL : ExceptionType.LESS_THAN_ZERO));
        }
        if (offerDTO.getOfferDiscountType() == null || offerDTO.getOfferDiscountType().name().isEmpty()) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_DISCOUNT_TYPE, offerDTO.getOfferDiscountType() == null ? ExceptionType.NULL : ExceptionType.EMPTY));
        }
        if (offerDTO.getOfferDiscountValue() == null || offerDTO.getOfferDiscountValue() <= 0.0) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_DISCOUNT_VALUE, offerDTO.getOfferDiscountValue() == null ? ExceptionType.NULL : ExceptionType.LESS_THAN_ZERO));
        }

        if (offerDTO.getOfferItems() == null) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_TYPE, ExceptionType.NULL));
        } else {
            for (OfferItemDTO offerItemDTO : offerDTO.getOfferItems()) {
                if (offerItemDTO.getOfferType() == null || offerItemDTO.getOfferType().name().isEmpty()) {
                    throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_TYPE, offerItemDTO.getOfferType() == null ? ExceptionType.NULL : ExceptionType.EMPTY));
                }
                if (offerItemDTO.getOfferType().equals(OfferType.ITEM_OFFER) || offerItemDTO.getOfferType().equals(OfferType.SKU_OFFER)) {
                    if (offerItemDTO.getOfferOn() == null) {
                        throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_ON, ExceptionType.NULL));
                    }
                    if (offerItemDTO.getItemId() == null) {
                        throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.ITEM_ID, ExceptionType.NULL));
                    }
                    if (offerItemDTO.getSkuId() == null) {
                        throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.SKU_ID, ExceptionType.NULL));
                    }

                }

                if (offerItemDTO.getOfferType().equals(OfferType.DISCOUNT_COUPONS)) {
                    if (offerItemDTO.getCouponCode() == null || offerItemDTO.getCouponCode().isEmpty()) {
                        throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.DISCOUNT_COUPONS, offerItemDTO.getCouponCode() == null ? ExceptionType.NULL : ExceptionType.EMPTY));
                    }
                }
                if (offerItemDTO.getOfferType().equals(OfferType.ON_BILL_AMOUNT)) {
                    if (offerItemDTO.getBillAmount() == null) {
                        throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.ON_BILL_AMOUNT, ExceptionType.NULL));
                    }
                }
            }
        }

        if (offerDTO.getOfferStatus() == null) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_STATUS, ExceptionType.NULL));
        }

        if (offerDTO.getOfferStartDate() == null) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_START_DATE, ExceptionType.NULL));
        }

        if (offerDTO.getOfferEndDate() == null) {
            throw new NullPointerException(OfferManagementConstants.getOfferDetailsExceptionMessageFormat(OfferManagementConstants.OFFER_END_DATE, ExceptionType.NULL));
        }
        if (offerDTO.getOfferId() != null && offerDTO.getOfferId() > 0)
            validateUpdateOfferDate(offerDTO.getOfferStartDate(), offerDTO.getOfferEndDate());
        else
            validateDate(offerDTO.getOfferStartDate(), offerDTO.getOfferEndDate());
    }

    public static void validateDate(LocalDate startDate, LocalDate endDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new InvalidDateException(String.format(OfferManagementConstants.EARLIER_DATE_VALIDATION, "start"));
        }
        if (endDate.isBefore(LocalDate.now())) {
            throw new InvalidDateException(String.format(OfferManagementConstants.EARLIER_DATE_VALIDATION, "end"));
        }

        if (startDate.isAfter(endDate)) {
            throw new InvalidDateException(OfferManagementConstants.START_DATE_EARLIER_END_DATE);
        } else if (startDate.isEqual(endDate)) {
            throw new InvalidDateException(OfferManagementConstants.START_DATE_SAME_END_DATE);
        }
    }

    public static void validateUpdateOfferDate(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(LocalDate.now())) {
            throw new InvalidDateException(String.format(OfferManagementConstants.EARLIER_DATE_VALIDATION, "end"));
        }

        if (startDate.isAfter(endDate)) {
            throw new InvalidDateException(OfferManagementConstants.START_DATE_EARLIER_END_DATE);
        } else if (startDate.isEqual(endDate)) {
            throw new InvalidDateException(OfferManagementConstants.START_DATE_SAME_END_DATE);
        }
    }
}
