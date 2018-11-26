package com.tenable.io.api.tags.models;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class TagCategory {
    private String containerUuid;
    private String uuid;
    private String name;
    private String description;
    private String creationDate;
    private String owner;
    private String lastUpdateDate;
    private String lastUpdatedBy;
    private boolean reserved = true;
    private String modelName;

    /**
     * Gets the uuid of container.
     *
     * @return the uuid of container.
     */
    @JsonProperty( "container_uuid" )
    public String getContainerUuid() {
        return containerUuid;
    }


    /**
     * Sets the uuid of category.
     *
     * @param containerUuid the uuid of category.
     */
    @JsonProperty( "container_uuid" )
    public void setContainerUuid( String containerUuid ) {
        this.containerUuid = containerUuid;
    }


    /**
     * Gets the uuid of category.
     *
     * @return the uuid of category.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid of category.
     *
     * @param uuid the uuid of category.
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


    /**
     * Gets the name of category.
     *
     * @return the name of category.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of category.
     *
     * @param name the name of category.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the description of category.
     *
     * @return the description of category.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description of category.
     *
     * @param description the name of category.
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets the creation date of category.
     *
     * @return the creation date of category.
     */
    @JsonProperty( "created_at" )
    public String getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the name of category.
     *
     * @param creationDate the name of category.
     */
    @JsonProperty( "created_at" )
    public void setCreationDate( String creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the owner of category.
     *
     * @return the owner of category.
     */
    @JsonProperty( "created_by" )
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner of category.
     *
     * @param owner the owner of category.
     */
    @JsonProperty( "created_by" )
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * Gets the last update date of category.
     *
     * @return the last update date of category.
     */
    @JsonProperty( "updated_at" )
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }


    /**
     * Sets the last update date of category.
     *
     * @param lastUpdateDate the last update date of category.
     */
    @JsonProperty( "updated_at" )
    public void setLastUpdateDate( String lastUpdateDate ) {
        this.lastUpdateDate = lastUpdateDate;
    }


    /**
     * Gets the last user who updated category.
     *
     * @return the last user who updated category.
     */
    @JsonProperty( "updated_by" )
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }


    /**
     * Sets the user who last updated category.
     *
     * @param lastUpdatedBy the last user who updated category.
     */
    @JsonProperty( "updated_by" )
    public void setLastUpdatedBy( String lastUpdatedBy ) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    /**
     * Gets if it is reserved.
     *
     * @return if is reserved or not.
     */
    public boolean isReserved() {
        return reserved;
    }


    /**
     * Sets to reserved or not.
     *
     * @param reserved if it is reserved or not.
     */
    public void setReserved( boolean reserved ) {
        this.reserved = reserved;
    }


    /**
     * Gets the model name.
     *
     * @return the model name.
     */
    @JsonProperty( "model_name" )
    public String getModelName() {
        return modelName;
    }


    /**
     * Sets the model name.
     *
     * @param modelName the model name
     */
    @JsonProperty( "model_name" )
    public void setModelName( String modelName ) {
        this.modelName = modelName;
    }
}
