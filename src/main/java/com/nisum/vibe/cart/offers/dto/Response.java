package com.nisum.vibe.cart.offers.dto;

import java.time.Instant;

/**
 * Represents a response containing a message, status, and timestamp.
 */
public class Response {
    private Object message;
    private String status;
    private Instant time;

    /**
     * Constructs a {@link Response} with the specified message, status, and time.
     *
     * @param message the message to be included in the response
     * @param status the status of the response
     * @param time the timestamp of the response
     */
    public Response(Object message, String status, Instant time) {
        this.message = message;
        this.status = status;
        this.time = time;
    }

    /**
     * Gets the message of the response.
     *
     * @return the message
     */
    public Object getMessage() {
        return message;
    }

    /**
     * Sets the message of the response.
     *
     * @param message the message to set
     * @return the current instance of {@link Response}
     */
    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Gets the status of the response.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the response.
     *
     * @param status the status to set
     * @return the current instance of {@link Response}
     */
    public Response setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Gets the timestamp of the response.
     *
     * @return the timestamp
     */
    public Instant getTime() {
        return time;
    }

    /**
     * Sets the timestamp of the response.
     *
     * @param time the timestamp to set
     * @return the current instance of {@link Response}
     */
    public Response setTime(Instant time) {
        this.time = time;
        return this;
    }
}
