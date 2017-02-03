package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class History {
    private int historyId;
    private String uuid;
    private int ownerId;
    private String status;
    private int creationDate;
    private int lastModificationDate;


    /**
     * Gets the unique id of the historical data.
     *
     * @return the unique id of the historical data.
     */
    @JsonProperty( "history_id" )
    public int getHistoryId() {
        return historyId;
    }


    /**
     * Sets the unique id of the historical data.
     *
     * @param historyId the unique id of the historical data.
     */
    @JsonProperty( "history_id" )
    public void setHistoryId( int historyId ) {
        this.historyId = historyId;
    }


    /**
     * Gets the uuid of the historical data.
     *
     * @return the uuid of the historical data.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid of the historical data.
     *
     * @param uuid the uuid of the historical data.
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


    /**
     * Gets the unique id of the owner of the scan.
     *
     * @return the unique id of the owner of the scan.
     */
    @JsonProperty( "owner_id" )
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the unique id of the owner of the scan.
     *
     * @param ownerId the unique id of the owner of the scan.
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( int ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the status of the historical data.
     *
     * @return the status of the historical data.
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status of the historical data.
     *
     * @param status the status of the historical data.
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * Gets the creation date for the historical data in unixtime.
     *
     * @return the creation date for the historical data in unixtime.
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creation date for the historical data in unixtime.
     *
     * @param creationDate the creation date for the historical data in unixtime.
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the last modification date for the historical data in unixtime.
     *
     * @return the last modification date for the historical data in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets the last modification date for the historical data in unixtime.
     *
     * @param lastModificationDate the last modification date for the historical data in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }
}
