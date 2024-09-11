package com.nisum.vibe.cart.offers.exception;

import java.time.Instant;

public class OfferError {
    public String error;
    public String message;
    private Instant time;

    public String getMessage() {
        return message;
    }

    public OfferError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getError() {
        return error;
    }

    public OfferError setError(String error) {
        this.error = error;
        return this;
    }

    public Instant getTime() {
        return time;
    }

    public OfferError setTime(Instant time) {
        this.time = time;
        return this;
    }
}
