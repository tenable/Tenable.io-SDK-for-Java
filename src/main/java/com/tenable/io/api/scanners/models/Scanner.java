package com.tenable.io.api.scanners.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Scanner {
    private int id;
    private String uuid;
    private String name;
    private String type;
    private String status;
    private int scanCount;
    private String engineVersion;
    private String platform;
    private String loadedPluginSet;
    private String registrationCode;
    private String owner;
    private String key;
    private ScannerLicense license;
    private String challenge;
    private String creationDate;
    private String expiration;
    private String lastModificationDate;
    private int linked;
    private int numScans;
    private int ownerId;
    private String ownerName;
    private boolean pool;
    private int shared;
    private String timestamp;
    private String token;
    private int userPermissions;


    /**
     * Gets the unique id of the scanner.
     *
     * @return The unique id of the scanner.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the scanner.
     *
     * @param id The unique id of the scanner.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the uuid of the scanner.
     *
     * @return the uuid of the scanner.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid of the scanner.
     *
     * @param uuid the uuid of the scanner.
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


    /**
     * Gets the user-defined name of the scanner.
     *
     * @return The user-defined name of the scanner.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the user-defined name of the scanner.
     *
     * @param name The user-defined name of the scanner.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the type of scanner (local or remote).
     *
     * @return The type of scanner (local or remote).
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of scanner (local or remote).
     *
     * @param type The type of scanner (local or remote).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the status of the scanner (on or off).
     *
     * @return The status of the scanner (on or off).
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status of the scanner (on or off).
     *
     * @param status The status of the scanner (on or off).
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * Gets the current number of running scans on the scanner.
     *
     * @return The current number of running scans on the scanner.
     */
    @JsonProperty( "scan_count" )
    public int getScanCount() {
        return scanCount;
    }


    /**
     * Sets the current number of running scans on the scanner.
     *
     * @param scanCount The current number of running scans on the scanner.
     */
    @JsonProperty( "scan_count" )
    public void setScanCount( int scanCount ) {
        this.scanCount = scanCount;
    }


    /**
     * Gets the version of the scanner.
     *
     * @return the version of the scanner.
     */
    @JsonProperty( "engine_version" )
    public String getEngineVersion() {
        return engineVersion;
    }


    /**
     * Sets the version of the scanner.
     *
     * @param engineVersion the version of the scanner.
     */
    @JsonProperty( "engine_version" )
    public void setEngineVersion( String engineVersion ) {
        this.engineVersion = engineVersion;
    }


    /**
     * Gets the platform of the scanner.
     *
     * @return the platform of the scanner.
     */
    public String getPlatform() {
        return platform;
    }


    /**
     * Sets the platform of the scanner.
     *
     * @param platform the platform of the scanner.
     */
    public void setPlatform( String platform ) {
        this.platform = platform;
    }


    /**
     * Gets the current plugin set on the scanner.
     *
     * @return the current plugin set on the scanner.
     */
    @JsonProperty( "loaded_plugin_set" )
    public String getLoadedPluginSet() {
        return loadedPluginSet;
    }


    /**
     * Sets the current plugin set on the scanner.
     *
     * @param loadedPluginSet the current plugin set on the scanner.
     */
    @JsonProperty( "loaded_plugin_set" )
    public void setLoadedPluginSet( String loadedPluginSet ) {
        this.loadedPluginSet = loadedPluginSet;
    }


    /**
     * Gets the registration code of the scanner.
     *
     * @return the registration code of the scanner.
     */
    @JsonProperty( "registration_code" )
    public String getRegistrationCode() {
        return registrationCode;
    }


    /**
     * Sets the registration code of the scanner.
     *
     * @param registrationCode the registration code of the scanner.
     */
    @JsonProperty( "registration_code" )
    public void setRegistrationCode( String registrationCode ) {
        this.registrationCode = registrationCode;
    }


    /**
     * Gets the owner of the scanner.
     *
     * @return the owner of the scanner.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner of the scanner.
     *
     * @param owner the owner of the scanner.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * Gets an alpha-numeric sequence of characters used when linking a scanner to a scanner manager.
     *
     * @return an alpha-numeric sequence of characters used when linking a scanner to a scanner manager.
     */
    public String getKey() {
        return key;
    }


    /**
     * Sets A alpha-numeric sequence of characters used when linking a scanner to a scanner manager.
     *
     * @param key A alpha-numeric sequence of characters used when linking a scanner to a scanner manager.
     */
    public void setKey( String key ) {
        this.key = key;
    }


    /**
     * Gets challenge.
     *
     * @return the challenge
     */
    public String getChallenge() {
        return challenge;
    }


    /**
     * Sets challenge.
     *
     * @param challenge the challenge
     */
    public void setChallenge( String challenge ) {
        this.challenge = challenge;
    }


    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    @JsonProperty( "creation_date" )
    public String getCreationDate() {
        return creationDate;
    }


    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( String creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets expiration.
     *
     * @return the expiration
     */
    public String getExpiration() {
        return expiration;
    }


    /**
     * Sets expiration.
     *
     * @param expiration the expiration
     */
    public void setExpiration( String expiration ) {
        this.expiration = expiration;
    }


    /**
     * Gets last modification date.
     *
     * @return the last modification date
     */
    @JsonProperty( "last_modification_date" )
    public String getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets last modification date.
     *
     * @param lastModificationDate the last modification date
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( String lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * Gets linked.
     *
     * @return the linked
     */
    public int getLinked() {
        return linked;
    }


    /**
     * Sets linked.
     *
     * @param linked the linked
     */
    public void setLinked( int linked ) {
        this.linked = linked;
    }


    /**
     * Gets num scans.
     *
     * @return the num scans
     */
    @JsonProperty( "num_scans" )
    public int getNumScans() {
        return numScans;
    }


    /**
     * Sets num scans.
     *
     * @param numScans the num scans
     */
    @JsonProperty( "num_scans" )
    public void setNumScans( int numScans ) {
        this.numScans = numScans;
    }


    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    @JsonProperty( "owner_id" )
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * Sets owner id.
     *
     * @param ownerId the owner id
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( int ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * Gets owner name.
     *
     * @return the owner name
     */
    @JsonProperty( "owner_name" )
    public String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets owner name.
     *
     * @param ownerName the owner name
     */
    @JsonProperty( "owner_name" )
    public void setOwnerName( String ownerName ) {
        this.ownerName = ownerName;
    }


    /**
     * Is pool boolean.
     *
     * @return the boolean
     */
    public boolean isPool() {
        return pool;
    }


    /**
     * Sets pool.
     *
     * @param pool the pool
     */
    public void setPool( boolean pool ) {
        this.pool = pool;
    }


    /**
     * Gets shared.
     *
     * @return the shared
     */
    public int getShared() {
        return shared;
    }


    /**
     * Sets shared.
     *
     * @param shared the shared
     */
    public void setShared( int shared ) {
        this.shared = shared;
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
     * Gets user permissions.
     *
     * @return the user permissions
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * Sets user permissions.
     *
     * @param userPermissions the user permissions
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }


    /**
     * Gets the license information for the scanner.
     *
     * @return The license information for the scanner.
     */
    public ScannerLicense getLicense() {
        return license;
    }


    /**
     * Sets the license information for the scanner.
     *
     * @param license The license information for the scanner.
     */
    public void setLicense( ScannerLicense license ) {
        this.license = license;
    }
}
