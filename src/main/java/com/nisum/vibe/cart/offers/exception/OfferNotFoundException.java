package com.nisum.vibe.cart.offers.exception;

public class OfferNotFoundException extends RuntimeException{
    public OfferNotFoundException(String message)
    {
        super(message);
    }
}
