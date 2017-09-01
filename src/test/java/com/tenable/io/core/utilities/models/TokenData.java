package com.tenable.io.core.utilities.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TokenData {
    private String token;
    private String issuedAt;

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken( String token ) {
        this.token = token;
    }

    /**
     * Gets issued at.
     *
     * @return the issued at
     */
    @JsonProperty( "issued_at" )
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * Sets issued at.
     *
     * @param issuedAt the issued at
     */
    @JsonProperty( "issued_at" )
    public void setIssuedAt( String issuedAt ) {
        this.issuedAt = issuedAt;
    }
}
