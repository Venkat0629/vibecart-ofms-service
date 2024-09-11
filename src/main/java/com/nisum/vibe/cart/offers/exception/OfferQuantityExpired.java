package com.nisum.vibe.cart.offers.exception;

public class OfferQuantityExpired extends RuntimeException{
    public OfferQuantityExpired(String message) {
        super(message);
    }
}