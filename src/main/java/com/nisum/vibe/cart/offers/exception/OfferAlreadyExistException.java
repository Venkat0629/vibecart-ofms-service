package com.nisum.vibe.cart.offers.exception;

public class OfferAlreadyExistException extends RuntimeException{
    public OfferAlreadyExistException(String message) {
        super(message);
    }
}