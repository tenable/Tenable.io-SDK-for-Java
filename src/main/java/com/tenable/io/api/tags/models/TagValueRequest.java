package com.tenable.io.api.tags.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class TagValueRequest {
    private String value;
    private String description;
    private String categoryUuid;
    private String categoryName;
    private String categoryDescription;
    private Map<String, TagFilters> filters;

    /**
     * Gets the value of the tag.
     *
     * @return the value of the tag.
     */
    public String getValue() {
        return value;
    }


    /**
     * Sets the value of the tag.
     *
     * @param value the value of the tag.
     */
    public void setValue( String value ) {
        this.value = value;
    }


    /**
     * Sets the value of the tag.
     *
     * @param value the value of the tag.
     */
    public TagValueRequest withValue( String value ) {
        this.value = value;
        return this;
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
     * Sets the description value.
     *
     * @param description the description value.
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Sets the description of the tag.
     *
     * @param description the description of the value.
     */
    public TagValueRequest withDescription( String description ) {
        this.description = description;
        return this;
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
     * Sets the category uuid of the value.
     *
     * @param categoryUuid the category uuid of the value.
     */
    public TagValueRequest withCategoryUuid( String categoryUuid ) {
        this.categoryUuid = categoryUuid;
        return this;
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
     * Sets the category name of the value.
     *
     * @param categoryName the category name of the value.
     */
    public TagValueRequest withCategoryName( String categoryName ) {
        this.categoryName = categoryName;
        return this;
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
     * Sets the category description of the value.
     *
     * @param categoryDescription the category description of the value.
     */
    public TagValueRequest withCategoryDescription( String categoryDescription ) {
        this.categoryDescription = categoryDescription;
        return this;
    }


    /**
     * Gets the filters for a value
     *
     * @return the filters of value.
     */
    @JsonProperty( "filters" )
    public Map<String, TagFilters> getFilters() {
        return filters;
    }


    /**
     * Sets the filters of value.
     *
     * @param filters filters for applying a tag dynamically
     */
    @JsonProperty( "filters" )
    public void setFilters( final TagFilterOperator operator, final List<TagFilter> filters ) {
        this.filters = new HashMap(){{
            put("asset", new HashMap() {{
                put(operator, filters);
            }});
        }};
    }


    /**
     * Sets the filters of the value.
     *
     * @param filters the filters of the value.
     */
    public TagValueRequest withFilters( final TagFilterOperator operator, final List<TagFilter> filters ) {
        this.setFilters( operator, filters );
        return this;
    }
}
