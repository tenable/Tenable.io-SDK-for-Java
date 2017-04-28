package com.tenable.io.api.scannerGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScannerGroup {
    private int creationDate;
    private int id;
    private int lastModificationDate;
    private String name;
    private String owner;
    private int ownerId;
    private String scannerCount;
    private int shared;
    private ScannerGroupType type;
    private int userPermissions;
    private String uuid;
    private String token;
    private String timestamp;
    private int scannerId;
    private int scanCount;
    private String flag;


    /**
     * Gets the creation date for the scanner group in unixtime.
     *
     * @return the creation date for the scanner group in unixtime.
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the unique id of the scanner group.
     *
     * @return the unique id of the scanner group.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the scanner group.
     *
     * @param id the unique id of the scanner group.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the last modification date for the scanner group in unixtime.
     *
     * @return the last modification date for the scanner group in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets the last modification date for the scanner group in unixtime.
     *
     * @param lastModificationDate the last modification date for the scanner group in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * Gets the name of the scanner group.
     *
     * @return the name of the scanner group
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the scanner group
     *
     * @param name the name of the scanner group
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the username of the owner of the scanner group.
     *
     * @return the username of the owner of the scanner group.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the username of the owner of the scanner group.
     *
     * @param owner the username of the owner of the scanner group.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * Gets the unique id of the owner of the scanner group.
     *
     * @return the unique id of the owner of the scanner group.
     */
    @JsonProperty( "owner_id" )
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the unique id of the owner of the scanner group.
     *
     * @param ownerId the unique id of the owner of the scanner group.
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( int ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the number of scanners associated with this scanner group.
     *
     * @return the number of scanners associated with this scanner group.
     */
    @JsonProperty( "scanner_count" )
    public String getScannerCount() {
        return scannerCount;
    }


    /**
     * Sets the number of scanners associated with this scanner group.
     *
     * @param scannerCount the number of scanners associated with this scanner group.
     */
    @JsonProperty( "scanner_count" )
    public void setScannerCount( String scannerCount ) {
        this.scannerCount = scannerCount;
    }


    /**
     * Gets the shared status of the scanner-group.
     *
     * @return the shared status of the scanner-group.
     */
    public int getShared() {
        return shared;
    }


    /**
     * Sets the shared status of the scanner-group.
     *
     * @param shared the shared status of the scanner-group.
     */
    public void setShared( int shared ) {
        this.shared = shared;
    }


    /**
     * Gets the type of scanner group. This is set to "load_balancing" by default.
     *
     * @return the type of scanner group. This is set to "load_balancing" by default.
     */
    public ScannerGroupType getType() {
        return type;
    }


    /**
     * Sets the type of scanner group. This is set to "load_balancing" by default.
     *
     * @param type the type of scanner group. This is set to "load_balancing" by default.
     */
    public void setType( ScannerGroupType type ) {
        this.type = type;
    }


    /**
     * Gets the sharing permissions for the scanner group.
     *
     * @return the sharing permissions for the scanner group.
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * Sets the sharing permissions for the scanner group.
     *
     * @param userPermissions the sharing permissions for the scanner group.
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }


    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


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
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }


    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp( String timestamp ) {
        this.timestamp = timestamp;
    }


    /**
     * Gets scanner id.
     *
     * @return the scanner id
     */
    @JsonProperty( "scanner_Id" )
    public int getScannerId() {
        return scannerId;
    }


    /**
     * Sets scanner id.
     *
     * @param scannerId the scanner id
     */
    @JsonProperty( "scanner_Id" )
    public void setScannerId( int scannerId ) {
        this.scannerId = scannerId;
    }


    /**
     * Gets scan count.
     *
     * @return the scan count
     */
    @JsonProperty( "scan_count" )
    public int getScanCount() {
        return scanCount;
    }


    /**
     * Sets scan count.
     *
     * @param scanCount the scan count
     */
    @JsonProperty( "scan_count" )
    public void setScanCount( int scanCount ) {
        this.scanCount = scanCount;
    }


    /**
     * Gets flag.
     *
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }


    /**
     * Sets flag.
     *
     * @param flag the flag
     */
    public void setFlag( String flag ) {
        this.flag = flag;
    }
}
