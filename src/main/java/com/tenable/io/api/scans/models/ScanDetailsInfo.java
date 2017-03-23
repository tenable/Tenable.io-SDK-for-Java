package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanDetailsInfo {
    private List<Permission> acls;
    private boolean editAllowed;
    private ScanStatus status;
    private String policy;
    private boolean pciCanUpload;
    private boolean hasAuditTrail;
    private String scanStart;
    private int folderId;
    private String targets;
    private int timestamp;
    private int objectId;
    private String scannerName;
    private boolean hasKb;
    private String uuid;
    private int hostCount;
    private String scanEnd;
    private String name;
    private int userPermissions;
    private boolean control;
    private String scheduleUuid;


    /**
     * Gets the list of permissions.
     *
     * @return the list of permissions
     */
    public List<Permission> getAcls() {
        return acls;
    }


    /**
     * Sets the list of permissions.
     *
     * @param acls the list of permissions.
     */
    public void setAcls( List<Permission> acls ) {
        this.acls = acls;
    }


    /**
     * Is edit allowed boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "edit_allowed" )
    public boolean isEditAllowed() {
        return editAllowed;
    }


    /**
     * Sets edit allowed.
     *
     * @param editAllowed the edit allowed
     */
    @JsonProperty( "edit_allowed" )
    public void setEditAllowed( boolean editAllowed ) {
        this.editAllowed = editAllowed;
    }


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
     * Gets policy.
     *
     * @return the policy
     */
    public String getPolicy() {
        return policy;
    }


    /**
     * Sets policy.
     *
     * @param policy the policy
     */
    public void setPolicy( String policy ) {
        this.policy = policy;
    }


    /**
     * Is pci can upload boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "pci-can-upload" )
    public boolean isPciCanUpload() {
        return pciCanUpload;
    }


    /**
     * Sets pci can upload.
     *
     * @param pciCanUpload the pci can upload
     */
    @JsonProperty( "pci-can-upload" )
    public void setPciCanUpload( boolean pciCanUpload ) {
        this.pciCanUpload = pciCanUpload;
    }


    /**
     * Is has audit trail boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "hasauditrail" )
    public boolean isHasAuditTrail() {
        return hasAuditTrail;
    }


    /**
     * Sets has audit trail.
     *
     * @param hasAuditTrail the has audit trail
     */
    @JsonProperty( "hasauditrail" )
    public void setHasAuditTrail( boolean hasAuditTrail ) {
        this.hasAuditTrail = hasAuditTrail;
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
     * Gets folder id.
     *
     * @return the folder id
     */
    @JsonProperty( "folder_id" )
    public int getFolderId() {
        return folderId;
    }


    /**
     * Sets folder id.
     *
     * @param folderId the folder id
     */
    @JsonProperty( "folder_id" )
    public void setFolderId( int folderId ) {
        this.folderId = folderId;
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
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }


    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp( int timestamp ) {
        this.timestamp = timestamp;
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
     * Gets scanner name.
     *
     * @return the scanner name
     */
    @JsonProperty( "scanner_name" )
    public String getScannerName() {
        return scannerName;
    }


    /**
     * Sets scanner name.
     *
     * @param scannerName the scanner name
     */
    @JsonProperty( "scanner_name" )
    public void setScannerName( String scannerName ) {
        this.scannerName = scannerName;
    }


    /**
     * Gets whether has kb.
     *
     * @return the boolean
     */
    @JsonProperty( "haskb" )
    public boolean isHasKb() {
        return hasKb;
    }


    /**
     * Sets has kb.
     *
     * @param hasKb the has kb
     */
    @JsonProperty( "haskb" )
    public void setHasKb( boolean hasKb ) {
        this.hasKb = hasKb;
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
     * Gets uuid.
     *
     * @return the uuid
     */
    @JsonProperty( "schedule_uuid" )
    public String getScheduleUuid() {
        return scheduleUuid;
    }


    /**
     * Sets uuid.
     *
     * @param scheduleUuid the uuid
     */
    @JsonProperty( "schedule_uuid" )
    public void setScheduleUuid( String scheduleUuid ) {
        this.scheduleUuid = scheduleUuid;
    }


    /**
     * Gets host count.
     *
     * @return the host count
     */
    @JsonProperty( "hostcount" )
    public int getHostCount() {
        return hostCount;
    }


    /**
     * Sets host count.
     *
     * @param hostCount the host count
     */
    @JsonProperty( "hostcount" )
    public void setHostCount( int hostCount ) {
        this.hostCount = hostCount;
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
     * Is control boolean.
     *
     * @return the boolean
     */
    public boolean isControl() {
        return control;
    }


    /**
     * Sets control.
     *
     * @param control the control
     */
    public void setControl( boolean control ) {
        this.control = control;
    }
}
