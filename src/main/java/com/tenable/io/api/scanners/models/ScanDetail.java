package com.tenable.io.api.scanners.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanDetail {
    private String scannerUuid;
    private String name;
    private String status;
    private String id;
    private int scanId;
    private String user;
    private int lastModificationDate;
    private int startTime;
    private boolean remote;


    /**
     * Gets the uuid of the scanner the scan belongs to.
     *
     * @return the uuid of the scanner the scan belongs to.
     */
    @JsonProperty( "scanner_uuid" )
    public String getScannerUuid() {
        return scannerUuid;
    }


    /**
     * Sets the uuid of the scanner the scan belongs to.
     *
     * @param scannerUuid the uuid of the scanner the scan belongs to.
     */
    @JsonProperty( "scanner_uuid" )
    public void setScannerUuid( String scannerUuid ) {
        this.scannerUuid = scannerUuid;
    }


    /**
     * Gets the name of the scan.
     *
     * @return the name of the scan.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the scan.
     *
     * @param name The name of the scan.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets Scan status. One of pending, processing, stopping, pausing, paused, resuming, or running.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets Scan status. One of pending, processing, stopping, pausing, paused, resuming, or running.
     *
     * @param status the status
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * Gets the scan uuid.
     *
     * @return The scan uuid.
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the scan uuid.
     *
     * @param id the scan uuid.
     */
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * Gets the id of the scan.
     *
     * @return the id of the scan.
     */
    @JsonProperty( "scan_id" )
    public int getScanId() {
        return scanId;
    }


    /**
     * Sets the id of the scan.
     *
     * @param scanId the id of the scan.
     */
    @JsonProperty( "scan_id" )
    public void setScanId( int scanId ) {
        this.scanId = scanId;
    }


    /**
     * Gets the username of the owner of the scan.
     *
     * @return the username of the owner of the scan.
     */
    public String getUser() {
        return user;
    }


    /**
     * Sets the username of the owner of the scan.
     *
     * @param user the username of the owner of the scan.
     */
    public void setUser( String user ) {
        this.user = user;
    }


    /**
     * Gets the last time the scan was modified.
     *
     * @return the last time the scan was modified.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets the last time the scan was modified.
     *
     * @param lastModificationDate the last time the scan was modified.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * Gets when the scan was started.
     *
     * @return the start time
     */
    @JsonProperty( "start_time" )
    public int getStartTime() {
        return startTime;
    }


    /**
     * Sets when the scan was started.
     *
     * @param startTime the start time
     */
    @JsonProperty( "start_time" )
    public void setStartTime( int startTime ) {
        this.startTime = startTime;
    }


    /**
     * Is remote boolean. true if the scan is running remotely; false otherwise.
     *
     * @return the boolean
     */
    public boolean isRemote() {
        return remote;
    }


    /**
     * Sets remote. true if the scan is running remotely; false otherwise.
     *
     * @param remote the remote
     */
    public void setRemote( boolean remote ) {
        this.remote = remote;
    }
}
