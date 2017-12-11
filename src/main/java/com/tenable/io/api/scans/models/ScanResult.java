package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanResult {
    private int creationDate;
    private String customTargets;
    private int defaultPermissions;
    private String description;
    private String emails;
    private int id;
    private int lastModificationDate;
    private String name;
    private String notificationFilterType;
    private String notificationFilters;
    private String owner;
    private int ownerId;
    private UUID ownerUuid;
    private int policyId;
    private String rRules;
    private int scannerId;
    private String scannerUuid;
    private int shared;
    private String startTime;
    private int tagId;
    private String timezone;
    private String type;
    private int userPermissions;
    private String uuid;
    private boolean enabled;


    /**
     * Gets creation date.
     *
     * @return the creation date
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
     * Gets custom targets.
     *
     * @return the custom targets
     */
    @JsonProperty( "custom_targets" )
    public String getCustomTargets() {
        return customTargets;
    }


    /**
     * Sets custom targets.
     *
     * @param customTargets the custom targets
     */
    @JsonProperty( "custom_targets" )
    public void setCustomTargets( String customTargets ) {
        this.customTargets = customTargets;
    }


    /**
     * Gets default permissions.
     *
     * @return the default permissions
     */
    @JsonProperty( "default_permisssions" )
    public int getDefaultPermissions() {
        return defaultPermissions;
    }


    /**
     * Sets default permissions.
     *
     * @param defaultPermissions the default permissions
     */
    @JsonProperty( "default_permisssions" )
    public void setDefaultPermissions( int defaultPermissions ) {
        this.defaultPermissions = defaultPermissions;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets emails.
     *
     * @return the emails
     */
    public String getEmails() {
        return emails;
    }


    /**
     * Sets emails.
     *
     * @param emails the emails
     */
    public void setEmails( String emails ) {
        this.emails = emails;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets last modification date.
     *
     * @return the last modification date
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets last modification date.
     *
     * @param lastModificationDate the last modification date
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
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
     * Gets notification filter type.
     *
     * @return the notification filter type
     */
    @JsonProperty( "notification_filter_type" )
    public String getNotificationFilterType() {
        return notificationFilterType;
    }


    /**
     * Sets notification filter type.
     *
     * @param notificationFilterType the notification filter type
     */
    @JsonProperty( "notification_filter_type" )
    public void setNotificationFilterType( String notificationFilterType ) {
        this.notificationFilterType = notificationFilterType;
    }


    /**
     * Gets notification filters.
     *
     * @return the notification filters
     */
    @JsonProperty( "notification_filters" )
    public String getNotificationFilters() {
        return notificationFilters;
    }


    /**
     * Sets notification filters.
     *
     * @param notificationFilters the notification filters
     */
    @JsonProperty( "notification_filters" )
    public void setNotificationFilters( String notificationFilters ) {
        this.notificationFilters = notificationFilters;
    }


    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets owner.
     *
     * @param owner the owner
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
     * Gets policy id.
     *
     * @return the policy id
     */
    @JsonProperty( "policy_id" )
    public int getPolicyId() {
        return policyId;
    }


    /**
     * Sets policy id.
     *
     * @param policyId the policy id
     */
    @JsonProperty( "policy_id" )
    public void setPolicyId( int policyId ) {
        this.policyId = policyId;
    }


    /**
     * Gets the schedule rules.
     *
     * @return the rules
     */
    @JsonProperty( "rrules" )
    public String getrRules() {
        return rRules;
    }


    /**
     * Sets the schedule rules.
     *
     * @param rRules the r rules
     */
    @JsonProperty( "rrules" )
    public void setrRules( String rRules ) {
        this.rRules = rRules;
    }


    /**
     * Gets scanner id.
     *
     * @return the scanner id
     */
    @JsonProperty( "scanner_id" )
    public int getScannerId() {
        return scannerId;
    }


    /**
     * Sets scanner id.
     *
     * @param scannerId the scanner id
     */
    @JsonProperty( "scanner_id" )
    public void setScannerId( int scannerId ) {
        this.scannerId = scannerId;
    }


    /**
     * Gets scanner uuid.
     *
     * @return the scanner uuid
     */
    @JsonProperty( "scanner_uuid" )
    public String getScannerUuid() {
        return scannerUuid;
    }


    /**
     * Sets scanner id.
     *
     * @param scannerUuid the scanner id
     */
    @JsonProperty( "scanner_uuid" )
    public void setScannerUuid( String scannerUuid ) {
        this.scannerUuid = scannerUuid;
    }


    /**
     * Gets whether the scan is shared.
     *
     * @return the shared
     */
    public int getShared() {
        return shared;
    }


    /**
     * Sets whether the scan is shared.
     *
     * @param shared the shared
     */
    public void setShared( int shared ) {
        this.shared = shared;
    }


    /**
     * Gets start time.
     *
     * @return the start time
     */
    @JsonProperty( "starttime" )
    public String getStartTime() {
        return startTime;
    }


    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    @JsonProperty( "starttime" )
    public void setStartTime( String startTime ) {
        this.startTime = startTime;
    }


    /**
     * Gets tag id.
     *
     * @return the tag id
     */
    @JsonProperty( "tag_id" )
    public int getTagId() {
        return tagId;
    }


    /**
     * Sets tag id.
     *
     * @param tagId the tag id
     */
    @JsonProperty( "tag_id" )
    public void setTagId( int tagId ) {
        this.tagId = tagId;
    }


    /**
     * Gets timezone.
     *
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }


    /**
     * Sets timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone( String timezone ) {
        this.timezone = timezone;
    }


    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType( String type ) {
        this.type = type;
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
     * Is enabled boolean.
     *
     * @return the boolean
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Sets enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }
}
