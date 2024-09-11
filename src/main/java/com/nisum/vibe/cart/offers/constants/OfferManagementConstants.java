package com.nisum.vibe.cart.offers.constants;

import com.nisum.vibe.cart.offers.common.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class containing constants and utility methods related to offer management.
 */
public class OfferManagementConstants {

    private static final Logger logger = LoggerFactory.getLogger(OfferManagementConstants.class);

    public static final String DELETE_MESSAGE_FORMAT = "Offer with ID %d successfully deleted.";
    public static final String EXCEPTION_MESSAGE_FORMAT = "Offer with ID %d is not available";
    public static final String OFFER_QUANTITY_EXPIRED = "Offer not available anymore!";
    public static final String INVALID_REQUEST_BODY_EXCEPTION_MESSAGE_FORMAT = "Request Body should not be null";
    public static final String OFFER_ALREADY_EXIST_EXCEPTION_MESSAGE_FORMAT = "Offer with that name %s already exists";
    public static final String OFFER_DETAILS_EXCEPTION_MESSAGE_FORMAT = "%s should not be TYPE";
    public static final String OFFER_DESCRIPTION = "Offer Description";
    public static final String OFFER_DISCOUNT_TYPE = "Offer Discount Type";
    public static final String OFFER_DISCOUNT_VALUE = "Offer Discount Value";
    public static final String OFFER_NAME = "Offer Name ";
    public static final String OFFER_TYPE = "offer Type";
    public static final String OFFER_ON = "Offer On";
    public static final String ITEM_ID = "Item ID";
    public static final String SKU_ID = "SKU ID";
    public static final String DISCOUNT_COUPONS = "Discount Coupons";
    public static final String ON_BILL_AMOUNT = "On Bill Amount";
    public static final String OFFER_STATUS = "Offer Status";
    public static final String OFFER_START_DATE = "Offer Start Date";
    public static final String OFFER_END_DATE = "Offer End Date";
    public static final String OFFER_QUANTITY = "Offer Quantity ";
    public static final String START_DATE_EARLIER_END_DATE = "Offer start date should be earlier than offer End date";
    public static final String START_DATE_SAME_END_DATE = "Offer start date and offer end date should not be same";
    public static final String EARLIER_DATE_VALIDATION = "Offer %s date should not be earlier than current date";

    /**
     * Generates a message indicating successful deletion of an offer.
     *
     * @param offerId the ID of the deleted offer
     * @return a formatted success message
     */
    public static String getDeleteMessage(Long offerId) {
        String message = String.format(DELETE_MESSAGE_FORMAT, offerId);
        logger.debug("Generated delete message: {}", message);
        return message;
    }

    /**
     * Generates an exception message format for an offer.
     *
     * @param <T>   the type of the offer identifier
     * @param offer the offer identifier
     * @return a formatted exception message
     */
    public static <T> String getExceptionMessageFormat(T offer) {
        String message = String.format(EXCEPTION_MESSAGE_FORMAT, offer);
        logger.debug("Generated exception message: {}", message);
        return message;
    }

    /**
     * Generates a message indicating that the request body should not be null.
     *
     * @return a formatted exception message
     */
    public static String getInvalidRequestBodyExceptionMessageFormat() {
        String message = String.format(INVALID_REQUEST_BODY_EXCEPTION_MESSAGE_FORMAT);
        logger.debug("Generated invalid request body exception message: {}", message);
        return message;
    }

    /**
     * Generates a message indicating that an offer with the specified name already exists.
     *
     * @param offerName the name of the offer that already exists
     * @return a formatted exception message
     */
    public static String getOfferAlreadyExistExceptionMessageFormat(String offerName) {
        String message = String.format(OFFER_ALREADY_EXIST_EXCEPTION_MESSAGE_FORMAT, offerName);
        logger.debug("Generated offer already exists exception message: {}", message);
        return message;
    }

    /**
     * Generates a message indicating details about an offer exception.
     *
     * @param offer        the offer details
     * @param exceptionType the type of exception
     * @return a formatted exception message
     */
    public static String getOfferDetailsExceptionMessageFormat(String offer, ExceptionType exceptionType) {
        String formattedExceptionMessage = String.format(OFFER_DETAILS_EXCEPTION_MESSAGE_FORMAT, offer)
                .replaceAll("TYPE", exceptionType.toString().replace('_', ' ').toLowerCase());
        logger.debug("Generated offer details exception message: {}", formattedExceptionMessage);
        return formattedExceptionMessage;
    }
}
