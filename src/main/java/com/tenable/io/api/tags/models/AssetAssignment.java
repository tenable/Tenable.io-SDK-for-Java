package com.tenable.io.api.tags.models;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AssetAssignment {
    private String assetUuid;
    private String value;
    private String valueUuid;
    private String categoryName;
    private String categoryUuid;
    private String creationDate;
    private String owner;

    /**
     * Gets the uuid of asset.
     *
     * @return the uuid of asset.
     */
    @JsonProperty( "asset_uuid" )
    public String getAssetUuid() {
        return assetUuid;
    }


    /**
     * Sets the uuid asset.
     *
     * @param assetUuid the uuid of asset.
     */
    @JsonProperty( "asset_uuid" )
    public void setAssetUuid( String assetUuid ) {
        this.assetUuid = assetUuid;
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
     * Gets the uuid of value.
     *
     * @return the uuid of value.
     */
    @JsonProperty( "value_uuid" )
    public String getValueUuid() {
        return valueUuid;
    }


    /**
     * Sets the uuid value.
     *
     * @param valueUuid the uuid of value.
     */
    @JsonProperty( "value_uuid" )
    public void setValueUuid( String valueUuid ) {
        this.valueUuid = valueUuid;
    }


    /**
     * Gets the uuid of category.
     *
     * @return the uuid of category.
     */
    @JsonProperty( "category_uuid" )
    public String getCategoryUuid() {
        return categoryUuid;
    }


    /**
     * Sets the uuid of category.
     *
     * @param categoryUuid the uuid of category.
     */
    @JsonProperty( "category_uuid" )
    public void setCategoryUuid( String categoryUuid ) {
        this.categoryUuid = categoryUuid;
    }


    /**
     * Gets the name of category.
     *
     * @return the name of category.
     */
    @JsonProperty( "category_name" )
    public String getCategoryName() {
        return categoryName;
    }


    /**
     * Sets the name of category.
     *
     * @param categoryName the name of category.
     */
    @JsonProperty( "category_name" )
    public void setCategoryName( String categoryName ) {
        this.categoryName = categoryName;
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
}
