package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;
import java.util.UUID;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanHistoryInfo {
    private long ownerId;
    private UUID ownerUuid;
    private String Owner;
    private String scheduleUuid;
    private String scanType;
    private ScanStatus status;
    private String scanStart;
    private String targets;
    private int objectId;
    private String uuid;
    private String scanEnd;
    private String name;


    /**
     * Gets status.
     *
     * @return the status
     */
    public ScanStatus getStatus() {
        return status;
    }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus( ScanStatus status ) {
        this.status = status;
    }


    /**
     * Gets scan start.
     *
     * @return the scan start
     */
    @JsonProperty( "scan_start" )
    public String getScanStart() {
        return scanStart;
    }


    /**
     * Sets scan start.
     *
     * @param scanStart the scan start
     */
    @JsonProperty( "scan_start" )
    public void setScanStart( String scanStart ) {
        this.scanStart = scanStart;
    }


    /**
     * Gets targets.
     *
     * @return the targets
     */
    public String getTargets() {
        return targets;
    }


    /**
     * Sets targets.
     *
     * @param targets the targets
     */
    public void setTargets( String targets ) {
        this.targets = targets;
    }


    /**
     * Gets object id.
     *
     * @return the object id
     */
    @JsonProperty( "object_id" )
    public int getObjectId() {
        return objectId;
    }


    /**
     * Sets object id.
     *
     * @param objectId the object id
     */
    @JsonProperty( "object_id" )
    public void setObjectId( int objectId ) {
        this.objectId = objectId;
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
     * Gets scan end.
     *
     * @return the scan end
     */
    @JsonProperty( "scan_end" )
    public String getScanEnd() {
        return scanEnd;
    }


    /**
     * Sets scan end.
     *
     * @param scanEnd the scan end
     */
    @JsonProperty( "scan_end" )
    public void setScanEnd( String scanEnd ) {
        this.scanEnd = scanEnd;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public long getOwnerId() {
        return ownerId;
    }


    /**
     * Sets owner id.
     *
     * @param ownerId the owner id
     */
    public void setOwnerId( long ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * Gets owner uuid.
     *
     * @return the owner uuid
     */
    public UUID getOwnerUuid() {
        return ownerUuid;
    }


    /**
     * Sets owner uuid.
     *
     * @param ownerUuid the owner uuid
     */
    public void setOwnerUuid( UUID ownerUuid ) {
        this.ownerUuid = ownerUuid;
    }


    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return Owner;
    }


    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner( String owner ) {
        Owner = owner;
    }


    /**
     * Gets schedule uuid.
     *
     * @return the schedule uuid
     */
    public String getScheduleUuid() {
        return scheduleUuid;
    }


    /**
     * Sets schedule uuid.
     *
     * @param scheduleUuid the schedule uuid
     */
    public void setScheduleUuid( String scheduleUuid ) {
        this.scheduleUuid = scheduleUuid;
    }


    /**
     * Gets scan type.
     *
     * @return the scan type
     */
    public String getScanType() {
        return scanType;
    }


    /**
     * Sets scan type.
     *
     * @param scanType the scan type
     */
    public void setScanType( String scanType ) {
        this.scanType = scanType;
    }
}
