package com.nisum.vibe.cart.offers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice(basePackages = "com.nisum.vibe.cart.offers.controller")
public class OfferControllerAdvice {

    @ExceptionHandler(OfferNotFoundException.class)
    public ResponseEntity<OfferError> offerNotFoundException(OfferNotFoundException ex) {
        return buildResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OfferAlreadyExistException.class)
    public ResponseEntity<OfferError> offerAlreadyExistFoundException(OfferAlreadyExistException ex) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<OfferError> illegalArgumentException(NullPointerException ex) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<OfferError> illegalArgumentException(InvalidDateException ex) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OfferQuantityExpired.class)
    public ResponseEntity<OfferError> offerExpired(OfferQuantityExpired ex) {
        return buildResponseEntity(ex, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidRequestBody.class)
    public ResponseEntity<OfferError> invalidRequestBody(InvalidRequestBody ex) {
        return buildResponseEntity(ex, HttpStatus.CONFLICT);
    }

    private ResponseEntity<OfferError> buildResponseEntity(Exception ex, HttpStatus status) {
        OfferError offerError = new OfferError();
        offerError.setError(status.getReasonPhrase());
        offerError.setMessage(ex.getMessage());
        offerError.setTime(Instant.now());
        return new ResponseEntity<>(offerError, status);
    }
}
