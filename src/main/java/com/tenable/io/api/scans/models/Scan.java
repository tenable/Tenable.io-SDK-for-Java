package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Scan {
    private int id;
    private String uuid;
    private String name;
    private String type;
    private String owner;
    private int ownerId;
    private UUID ownerUuid;
    private boolean enabled;
    private int folderId;
    private boolean read;
    private String status;
    private boolean shared;
    private int userPermissions;
    private int creationDate;
    private int lastModificationDate;
    private boolean control;
    private String startTime;
    private String timeZone;
    private String rRules;
    private String scheduleUuid;
    private UUID containerUuid;


    /**
     * Gets the unique id of the scan.
     *
     * @return the unique id of the scan.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the scan.
     *
     * @param id the unique id of the scan.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the uuid for the scan.
     *
     * @return the uuid for the scan.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid for the scan.
     *
     * @param uuid the uuid for the scan.
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
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
     * @param name the name of the scan.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the type of scan (local, remote, or agent).
     *
     * @return the type of scan (local, remote, or agent).
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of scan (local, remote, or agent).
     *
     * @param type the type of scan (local, remote, or agent).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the owner of the scan.
     *
     * @return the owner of the scan.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner of the scan.
     *
     * @param owner the owner of the scan.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
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
     * Gets owner uuid  (new ID).
     *
     * @return the owner uuid  (new ID)
     */
    public UUID getOwnerUuid() {
        return ownerUuid;
    }


    /**
     * Sets owner uuid (new ID).
     *
     * @param ownerUuid the owner uuid  (new ID)
     */
    public void setOwnerUuid( UUID ownerUuid ) {
        this.ownerUuid = ownerUuid;
    }


    /**
     * If true, the schedule for the scan is enabled.
     *
     * @return true if the schedule for the scan is enabled.
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Enables the schedule for the scan.
     *
     * @param enabled true if the schedule for the scan is enabled.
     */
    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }


    /**
     * Gets the unique id of the folder housing the scan (only returned when folder_id is not in the list request).
     *
     * @return the unique id of the folder housing the scan (only returned when folder_id is not in the list request).
     */
    @JsonProperty( "folder_id" )
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets the unique id of the folder housing the scan (only returned when folder_id is not in the list request).
     *
     * @param folderId the unique id of the folder housing the scan (only returned when folder_id is not in the list                 request).
     */
    @JsonProperty( "folder_id" )
    public void setFolderId( int folderId ) {
        this.folderId = folderId;
    }


    /**
     * If true, the scan has been read.
     *
     * @return true if the scan has been read.
     */
    public boolean isRead() {
        return read;
    }


    /**
     * Sets the scan to be read.
     *
     * @param read boolean value whether the scan is read or not.
     */
    public void setRead( boolean read ) {
        this.read = read;
    }


    /**
     * Gets the status of the scan (completed, aborted, imported, pending, running, resuming, canceling, cancelled,
     * pausing, paused, stopping, stopped).
     *
     * @return the status of the scan (completed, aborted, imported, pending, running, resuming, canceling, cancelled, pausing, paused, stopping, stopped).
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status of the scan (completed, aborted, imported, pending, running, resuming, canceling, cancelled,
     * pausing, paused, stopping, stopped).
     *
     * @param status the status of the scan (completed, aborted, imported, pending, running, resuming, canceling,               cancelled, pausing, paused, stopping, stopped).
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * If true, the scan is shared.
     *
     * @return true if the scan is shared.
     */
    public boolean isShared() {
        return shared;
    }


    /**
     * Sets the scan to be shared.
     *
     * @param shared boolean value whether the scan is shared or not.
     */
    public void setShared( boolean shared ) {
        this.shared = shared;
    }


    /**
     * Gets the sharing permissions for the scan.
     *
     * @return the sharing permissions for the scan.
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * Sets the sharing permissions for the scan.
     *
     * @param userPermissions the sharing permissions for the scan.
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }


    /**
     * Gets the creation date for the scan in unixtime.
     *
     * @return the creation date for the scan in unixtime.
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creation date for the scan in unixtime.
     *
     * @param creationDate the creation date for the scan in unixtime.
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the last modification date for the scan in unixtime.
     *
     * @return the last modification date for the scan in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets the last modification date for the scan in unixtime.
     *
     * @param lastModificationDate the last modification date for the scan in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * If true, the scan has a schedule and can be launched.
     *
     * @return true if the scan is scheduled and can be launched.
     */
    public boolean isControl() {
        return control;
    }


    /**
     * Sets the scan has a schedule and can be launched.
     *
     * @param control boolean value whether the scan has a schedule and can be launched.
     */
    public void setControl( boolean control ) {
        this.control = control;
    }


    /**
     * Gets the scheduled start time for the scan.
     *
     * @return the scheduled start time for the scan.
     */
    @JsonProperty( "starttime" )
    public String getStartTime() {
        return startTime;
    }


    /**
     * Sets the scheduled start time for the scan.
     *
     * @param startTime the scheduled start time for the scan.
     */
    @JsonProperty( "starttime" )
    public void setStartTime( String startTime ) {
        this.startTime = startTime;
    }


    /**
     * Gets the timezone for the scan.
     *
     * @return the timezone for the scan.
     */
    @JsonProperty( "timezone" )
    public String getTimeZone() {
        return timeZone;
    }


    /**
     * Sets the timezone for the scan.
     *
     * @param timeZone the timezone for the scan.
     */
    @JsonProperty( "timezone" )
    public void setTimeZone( String timeZone ) {
        this.timeZone = timeZone;
    }


    /**
     * Gets the rules for repeating the scan.
     *
     * @return the rules for repeating the scan.
     */
    @JsonProperty( "rrules" )
    public String getrRules() {
        return rRules;
    }


    /**
     * Sets the rules for repeating the scan.
     *
     * @param rRules the rules for repeating the scan.
     */
    @JsonProperty( "rrules" )
    public void setrRules( String rRules ) {
        this.rRules = rRules;
    }


    /**
     * Gets schedule uuid.
     *
     * @return the schedule uuid
     */
    @JsonProperty( "schedule_uuid" )
    public String getScheduleUuid() {
        return scheduleUuid;
    }


    /**
     * Sets schedule uuid.
     *
     * @param scheduleUuid the schedule uuid
     */
    @JsonProperty( "schedule_uuid" )
    public void setScheduleUuid( String scheduleUuid ) {
        this.scheduleUuid = scheduleUuid;
    }


    /**
     * Gets container uuid.
     *
     * @return the container uuid
     */
    public UUID getContainerUuid() {
        return containerUuid;
    }


    /**
     * Sets container uuid.
     *
     * @param containerUuid the container uuid
     */
    public void setContainerUuid( UUID containerUuid ) {
        this.containerUuid = containerUuid;
    }
}
