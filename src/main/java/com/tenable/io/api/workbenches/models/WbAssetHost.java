package com.tenable.io.api.workbenches.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WbAssetHost {
    private String id;
    private String hostname;


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * Gets hostname.
     *
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }


    /**
     * Sets hostname.
     *
     * @param hostname the hostname
     */
    public void setHostname( String hostname ) {
        this.hostname = hostname;
    }
}
