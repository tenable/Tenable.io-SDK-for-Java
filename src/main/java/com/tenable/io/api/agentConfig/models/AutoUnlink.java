package com.tenable.io.api.agentConfig.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AutoUnlink {
    private Integer expiration = null;
    private Boolean enabled = null;

    /**
     * Instantiates a new Auto unlink.
     *
     * @param enabled the enabled
     */
    public AutoUnlink( Boolean enabled ) {
        this.enabled = enabled;
    }

    /**
     * Instantiates a new Auto unlink.
     *
     * @param expiration the expiration
     */
    public AutoUnlink( Integer expiration ) {
        this.expiration = expiration;
    }

    /**
     * Instantiates a new Auto unlink.
     *
     * @param expiration the expiration
     * @param enabled    the enabled
     */
    @JsonCreator
    public AutoUnlink( @JsonProperty( "expiration" ) Integer expiration, @JsonProperty( "enabled" ) Boolean enabled ) {
        this.expiration = expiration;
        this.enabled = enabled;
    }

    /**
     * Gets expiration.
     *
     * @return the expiration
     */
    public Integer getExpiration() {
        return expiration;
    }

    /**
     * Sets expiration.
     *
     * @param expiration the expiration
     */
    public void setExpiration( Integer expiration ) {
        this.expiration = expiration;
    }

    /**
     * Gets enabled.
     *
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Sets enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled( Boolean enabled ) {
        this.enabled = enabled;
    }
}
