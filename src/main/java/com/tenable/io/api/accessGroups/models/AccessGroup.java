package com.tenable.io.api.accessGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AccessGroup {
    private String containerUuid;
    private String createdAt;
    private String updatedAt;
    private String id;
    private String name;
    private boolean allAssets;
    private boolean allUsers;
    private String status;
    private String version;
    private AssetRule[] rules;
    private AssetRulePrincipal[] principals;
    private String createdByUuid;
    private String createdByName;
    private String updatedByUuid;
    private String updatedByName;
    private int processingPercentComplete;


    /**
     * Gets the container uuid of access group.
     *
     * @return the container uuid of access group.
     */
    @JsonProperty( "container_uuid" )
    public String getContainerUuid() {
        return containerUuid;
    }


    /**
     * Sets the container uuid of access group.
     *
     * @param containerUuid the container uuid of access group.
     */
    @JsonProperty( "container_uuid" )
    public void setContainerUuid( String containerUuid ) {
        this.containerUuid = containerUuid;
    }


    /**
     * Gets the creation date of access group.
     *
     * @return the creation date of access group.
     */
    @JsonProperty( "created_at" )
    public String getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the creation date of access group.
     *
     * @param createdAt the creation date of access group.
     */
    @JsonProperty( "created_at" )
    public void setCreatedAt( String createdAt ) {
        this.createdAt = createdAt;
    }


    /**
     * Gets the last modification date of access group.
     *
     * @return the last modification date of access group.
     */
    @JsonProperty( "updated_at" )
    public String getUpdatedAt() {
        return updatedAt;
    }


    /**
     * Sets the last modification date of access group.
     *
     * @param updatedAt the last modification date of access group.
     */
    @JsonProperty( "updated_at" )
    public void setUpdatedAt( String updatedAt ) {
        this.updatedAt = updatedAt;
    }


    /**
     * Gets the uuid of access group.
     *
     * @return the uuid of access group.
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the uuid of access group.
     *
     * @param id the uuid of access group.
     */
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * Gets the name of access group.
     *
     * @return the name of access group.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of access group.
     *
     * @param name the name of access group.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets whether access group is system-provided All Assets.
     *
     * @return whether access group is system-provided All Assets.
     */
    @JsonProperty( "all_assets" )
    public boolean isAllAssets() {
        return allAssets;
    }


    /**
     * Sets whether access group is system-provided All Assets.
     *
     * @param allAssets whether access group is system-provided All Assets.
     */
    @JsonProperty( "all_assets" )
    public void setAllAssets( boolean allAssets ) {
        this.allAssets = allAssets;
    }


    /**
     * Gets whether access group can be viewed by all.
     *
     * @return whether access group can be viewed by all.
     */
    @JsonProperty( "all_users" )
    public boolean isAllUsers() {
        return allUsers;
    }


    /**
     * Sets whether access group can be viewed by all.
     *
     * @param allUsers whether access group can be viewed by all.
     */
    @JsonProperty( "all_users" )
    public void setAllUsers( boolean allUsers ) {
        this.allUsers = allUsers;
    }


    /**
     * Gets the status of the process of assets to access groups.
     *
     * @return the status of the process of assets to access groups.
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status of the process of assets to access groups.
     *
     * @param status the status of the process of assets to access groups.
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * Gets the version access group.
     *
     * @return the version of access group.
     */
    public String getVersion() {
        return version;
    }


    /**
     * Sets the version access group.
     *
     * @param version the version of access group.
     */
    public void setVersion( String version ) {
        this.version = version;
    }


    /**
     * Gets the array of access rules.
     *
     * @return the array of access rules.
     */
    public AssetRule[] getRules() {
        return rules;
    }


    /**
     * Sets the array of access rules.
     *
     * @param rules the array of access rules.
     */
    public void setRules( AssetRule[] rules ) {
        this.rules = rules;
    }


    /**
     * Gets the array of principals.
     *
     * @return the array of principals.
     */
    public AssetRulePrincipal[] getPrincipals() {
        return principals;
    }


    /**
     * Sets the array of principals.
     *
     * @param principals the array of principals.
     */
    public void setPrincipals( AssetRulePrincipal[] principals ) {
        this.principals = principals;
    }


    /**
     * Gets the uuid of access group creator.
     *
     * @return the uuid of access group creator.
     */
    @JsonProperty( "created_by_uuid" )
    public String getCreatedByUuid() {
        return createdByUuid;
    }


    /**
     * Sets the uuid of access group creator.
     *
     * @param createdByUuid the uuid of access group creator.
     */
    @JsonProperty( "created_by_uuid" )
    public void setCreatedByUuid( String createdByUuid ) {
        this.createdByUuid = createdByUuid;
    }


    /**
     * Gets the name of access group creator.
     *
     * @return the name of access group creator.
     */
    @JsonProperty( "created_by_name" )
    public String getCreatedByName() {
        return createdByName;
    }


    /**
     * Sets the name of access group creator.
     *
     * @param createdByName the name of access group creator.
     */
    @JsonProperty( "created_by_name" )
    public void setCreatedByName( String createdByName ) {
        this.createdByName = createdByName;
    }


    /**
     * Gets the uuid of user who last modified the access group.
     *
     * @return the uuid of user who last modified the access group.
     */
    @JsonProperty( "updated_by_uuid" )
    public String getUpdatedByUuid() {
        return updatedByUuid;
    }


    /**
     * Sets the uuid of user who last modified the access group.
     *
     * @param updatedByUuid the uuid of user who last modified the access group.
     */
    @JsonProperty( "updated_by_uuid" )
    public void setUpdatedByUuid( String updatedByUuid ) {
        this.updatedByUuid = updatedByUuid;
    }


    /**
     * Gets the name of user who last modified the access group.
     *
     * @return the container uuid of value the access group.
     */
    @JsonProperty( "updated_by_name" )
    public String getUpdatedByName() {
        return updatedByName;
    }


    /**
     * Sets the name of user who last modified the access group.
     *
     * @param updatedByName the container uuid of value the access group.
     */
    @JsonProperty( "updated_by_name" )
    public void setUpdatedByName( String updatedByName ) {
        this.updatedByName = updatedByName;
    }


    /**
     * Gets the percentage of assets evaluated against asset rules.
     *
     * @return the percentage of assets evaluated against asset rules.
     */
    @JsonProperty( "processing_percent_complete" )
    public int getProcessingPercentComplete() {
        return processingPercentComplete;
    }


    /**
     * Sets the percentage of assets evaluated against asset rules.
     *
     * @param processingPercentComplete the percentage of assets evaluated against asset rules.
     */
    @JsonProperty( "processing_percent_complete" )
    public void setProcessingPercentComplete( int processingPercentComplete ) {
        this.processingPercentComplete = processingPercentComplete;
    }
}
