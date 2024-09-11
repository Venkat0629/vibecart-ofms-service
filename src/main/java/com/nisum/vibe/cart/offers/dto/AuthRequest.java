package com.nisum.vibe.cart.offers.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an authentication request containing username and password.
 */
public class AuthRequest {

    private static final Logger logger = LoggerFactory.getLogger(AuthRequest.class);

    private String username;
    private String password;

    /**
     * Gets the username from the authentication request.
     *
     * @return the username
     */
    public String getUsername() {
        logger.debug("Getting username: {}", username);
        return username;
    }

    /**
     * Sets the username for the authentication request.
     *
     * @param username the username
     * @return the current instance of AuthRequest
     */
    public AuthRequest setUserName(String username) {
        logger.debug("Setting username: {}", username);
        this.username = username;
        return this;
    }

    /**
     * Gets the password from the authentication request.
     *
     * @return the password
     */
    public String getPassword() {
        logger.debug("Getting password");
        return password;
    }

    /**
     * Sets the password for the authentication request.
     *
     * @param password the password
     * @return the current instance of AuthRequest
     */
    public AuthRequest setPassword(String password) {
        logger.debug("Setting password");
        this.password = password;
        return this;
    }
}
