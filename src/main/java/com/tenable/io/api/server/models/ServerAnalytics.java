package com.tenable.io.api.server.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerAnalytics {
    private boolean enabled;
    private String key;
    private String siteId;


    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Sets enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }


    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }


    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey( String key ) {
        this.key = key;
    }


    /**
     * Gets site id.
     *
     * @return the site id
     */
    @JsonProperty( "site_id" )
    public String getSiteId() {
        return siteId;
    }


    /**
     * Sets site id.
     *
     * @param siteId the site id
     */
    @JsonProperty( "site_id" )
    public void setSiteId( String siteId ) {
        this.siteId = siteId;
    }
}
