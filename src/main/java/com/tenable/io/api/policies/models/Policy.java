package com.tenable.io.api.policies.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Policy {
    private int id;
    private String templateUuid;
    private String name;
    private String description;
    private String ownerId;
    private String owner;
    private int shared;
    private int userPermissions;
    private int creationDate;
    private int lastModificationDate;
    private String visibility;
    private boolean noTarget;


    /**
     * Gets the unique id of the policy.
     *
     * @return the unique id of the policy.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the policy.
     *
     * @param id the unique id of the policy.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the uuid for the template the policy uses.
     *
     * @return the uuid for the template the policy uses.
     */
    @JsonProperty( "template_uuid" )
    public String getTemplateUuid() {
        return templateUuid;
    }


    /**
     * Sets the uuid for the template the policy uses.
     *
     * @param templateUuid the uuid for the template the policy uses.
     */
    @JsonProperty( "template_uuid" )
    public void setTemplateUuid( String templateUuid ) {
        this.templateUuid = templateUuid;
    }


    /**
     * Gets the name of the policy.
     *
     * @return the name of the policy.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the policy.
     *
     * @param name the name of the policy.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the description of the policy.
     *
     * @return the description of the policy.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description of the policy.
     *
     * @param description the description of the policy.
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets the unique id of the owner of the policy.
     *
     * @return the unique id of the owner of the policy.
     */
    @JsonProperty( "owner_id" )
    public String getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the unique id of the owner of the policy.
     *
     * @param ownerId the unique id of the owner of the policy.
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( String ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the username for the owner of the policy.
     *
     * @return the username for the owner of the policy.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the username for the owner of the policy.
     *
     * @param owner the username for the owner of the policy.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * Gets the shared status of the policy.
     *
     * @return the shared status of the policy.
     */
    public int getShared() {
        return shared;
    }


    /**
     * Sets the shared status of the policy.
     *
     * @param shared the shared status of the policy.
     */
    public void setShared( int shared ) {
        this.shared = shared;
    }


    /**
     * Gets the sharing permissions for the policy.
     *
     * @return the sharing permissions for the policy.
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * Sets the sharing permissions for the policy.
     *
     * @param userPermissions the sharing permissions for the policy.
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }


    /**
     * Gets the creation date of the policy in unixtime.
     *
     * @return the creation date of the policy in unixtime.
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creation date of the policy in unixtime.
     *
     * @param creationDate the creation date of the policy in unixtime.
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the last modification date for the policy in unixtime.
     *
     * @return the last modification date for the policy in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets the last modification date for the policy in unixtime.
     *
     * @param lastModificationDate the last modification date for the policy in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * Gets the visibility of the target (private or shared).
     *
     * @return the visibility of the target (private or shared).
     */
    public String getVisibility() {
        return visibility;
    }


    /**
     * Sets the visibility of the target (private or shared).
     *
     * @param visibility the visibility of the target (private or shared).
     */
    public void setVisibility( String visibility ) {
        this.visibility = visibility;
    }


    /**
     * Whether the policy does not use targets.
     *
     * @return boolean whether the policy does not use targets.
     */
    @JsonProperty( "no_target" )
    public boolean isNoTarget() {
        return noTarget;
    }


    /**
     * Sets boolean whether the policy does not use targets.
     *
     * @param noTarget boolean whether the policy does not use targets.
     */
    @JsonProperty( "no_target" )
    public void setNoTarget( boolean noTarget ) {
        this.noTarget = noTarget;
    }
}
