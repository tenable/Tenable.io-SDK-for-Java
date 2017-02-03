package com.tenable.io.api.server.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerUpdate {
    private String href;
    private boolean newVersion;
    private boolean restart;


    /**
     * Gets href.
     *
     * @return the href
     */
    public String getHref() {
        return href;
    }


    /**
     * Sets href.
     *
     * @param href the href
     */
    public void setHref( String href ) {
        this.href = href;
    }


    /**
     * Is new version boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "new_version" )
    public boolean isNewVersion() {
        return newVersion;
    }


    /**
     * Sets new version.
     *
     * @param newVersion the new version
     */
    @JsonProperty( "new_version" )
    public void setNewVersion( boolean newVersion ) {
        this.newVersion = newVersion;
    }


    /**
     * Is restart boolean.
     *
     * @return the boolean
     */
    public boolean isRestart() {
        return restart;
    }


    /**
     * Sets restart.
     *
     * @param restart the restart
     */
    public void setRestart( boolean restart ) {
        this.restart = restart;
    }
}
