package com.tenable.io.api.tags.models;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class TagValue {
    private String containerUuid;
    private String uuid;
    private String value;
    private String description;
    private String categoryUuid;
    private String categoryName;
    private String categoryDescription;
    private String creationDate;
    private String owner;
    private String lastUpdateDate;
    private String lastUpdatedBy;
    private String type;
    private String modelName;


    /**
     * Gets the container uuid of value.
     *
     * @return the container uuid of value.
     */
    public String getContainerUuid() {
        return containerUuid;
    }


    /**
     * Sets the container uuid value.
     *
     * @param containerUuid the container uuid of value.
     */
    public void setContainerUuid( String containerUuid ) {
        this.containerUuid = containerUuid;
    }

    /**
     * Gets the uuid of value.
     *
     * @return the uuid of value.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value.
     *
     * @param uuid the uuid of value.
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


    /**
     * Gets the name of value.
     *
     * @return the name of value.
     */
    public String getValue() {
        return value;
    }


    /**
     * Sets the name of value.
     *
     * @param value the name of value.
     */
    public void setValue( String value ) {
        this.value = value;
    }


    /**
     * Gets the description of value.
     *
     * @return the description of value.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description of value.
     *
     * @param description the description of value.
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets the category uuid of value.
     *
     * @return the category uuid of value.
     */
    @JsonProperty( "category_uuid" )
    public String getCategoryUuid() {
        return categoryUuid;
    }


    /**
     * Sets the category uuid value.
     *
     * @param categoryUuid the category uuid of value.
     */
    @JsonProperty( "category_uuid" )
    public void setCategoryUuid( String categoryUuid ) {
        this.categoryUuid = categoryUuid;
    }


    /**
     * Gets the category name of value.
     *
     * @return the category name of value.
     */
    @JsonProperty( "category_name" )
    public String getCategoryName() {
        return categoryName;
    }


    /**
     * Sets the category name value.
     *
     * @param categoryName the category name of value.
     */
    @JsonProperty( "category_name" )
    public void setCategoryName( String categoryName ) {
        this.categoryName = categoryName;
    }


    /**
     * Gets the category description of value.
     *
     * @return the category description of value.
     */
    @JsonProperty( "category_description" )
    public String getCategoryDescription() {
        return categoryDescription;
    }


    /**
     * Sets the category description of value.
     *
     * @param categoryDescription the category description of value.
     */
    @JsonProperty( "category_description" )
    public void setCategoryDescription( String categoryDescription ) {
        this.categoryDescription = categoryDescription;
    }


    /**
     * Gets the creation date of value.
     *
     * @return the creation date of value.
     */
    @JsonProperty( "created_at" )
    public String getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creation date of value.
     *
     * @param creationDate the creation date of value.
     */
    @JsonProperty( "created_at" )
    public void setCreationDate( String creationDate ) {
        this.creationDate = creationDate;
    }



    /**
     * Gets the owner of value.
     *
     * @return the owner of value.
     */
    @JsonProperty( "created_by" )
    public String getOwner() {
        return owner;
    }


    /**
     * Sets the owner of value.
     *
     * @param owner the owner of value.
     */
    @JsonProperty( "created_by" )
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * Gets the last update date of value.
     *
     * @return the last update date of value.
     */
    @JsonProperty( "updated_at" )
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }


    /**
     * Sets the last update date of value.
     *
     * @param lastUpdateDate the last update date of value.
     */
    @JsonProperty( "updated_at" )
    public void setLastUpdateDate( String lastUpdateDate ) {
        this.lastUpdateDate = lastUpdateDate;
    }


    /**
     * Gets the last user who updated value.
     *
     * @return the last user who updated value.
     */
    @JsonProperty( "updated_by" )
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }


    /**
     * Sets the user who last updated value.
     *
     * @param lastUpdatedBy the last user who updated value.
     */
    @JsonProperty( "updated_by" )
    public void setLastUpdatedBy( String lastUpdatedBy ) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    /**
     * Gets the type of value.
     *
     * @return the type of value.
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of value.
     *
     * @param type the type of value.
     */
    public void setType(String type) {
        this.type = type;
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


