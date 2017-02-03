package com.tenable.io.api.server.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerLicense {
    private int agents;
    private String expirationDate;
    private int ips;
    private int scanners;
    private int agentsUsed;
    private int scannersUsed;
    private int users;


    /**
     * Gets agents used.
     *
     * @return the agents used
     */
    @JsonProperty( "agents_used" )
    public int getAgentsUsed() {
        return agentsUsed;
    }


    /**
     * Sets agents used.
     *
     * @param agentsUsed the agents used
     */
    @JsonProperty( "agents_used" )
    public void setAgentsUsed( int agentsUsed ) {
        this.agentsUsed = agentsUsed;
    }


    /**
     * Gets scanners used.
     *
     * @return the scanners used
     */
    @JsonProperty( "scanners_used" )
    public int getScannersUsed() {
        return scannersUsed;
    }


    /**
     * Sets scanners used.
     *
     * @param scannersUsed the scanners used
     */
    @JsonProperty( "scanners_used" )
    public void setScannersUsed( int scannersUsed ) {
        this.scannersUsed = scannersUsed;
    }


    /**
     * Gets users.
     *
     * @return the users
     */
    public int getUsers() {
        return users;
    }


    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers( int users ) {
        this.users = users;
    }


    /**
     * Gets agents.
     *
     * @return the agents
     */
    public int getAgents() {
        return agents;
    }


    /**
     * Sets agents.
     *
     * @param agents the agents
     */
    public void setAgents( int agents ) {
        this.agents = agents;
    }


    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    @JsonProperty( "expiration_date" )
    public String getExpirationDate() {
        return expirationDate;
    }


    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    @JsonProperty( "expiration_date" )
    public void setExpirationDate( String expirationDate ) {
        this.expirationDate = expirationDate;
    }


    /**
     * Gets ips.
     *
     * @return the ips
     */
    public int getIps() {
        return ips;
    }


    /**
     * Sets ips.
     *
     * @param ips the ips
     */
    public void setIps( int ips ) {
        this.ips = ips;
    }


    /**
     * Gets scanners.
     *
     * @return the scanners
     */
    public int getScanners() {
        return scanners;
    }


    /**
     * Sets scanners.
     *
     * @param scanners the scanners
     */
    public void setScanners( int scanners ) {
        this.scanners = scanners;
    }
}
