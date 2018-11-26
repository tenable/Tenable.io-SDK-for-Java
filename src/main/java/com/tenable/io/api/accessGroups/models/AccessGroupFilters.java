package com.tenable.io.api.accessGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.editors.models.Filter;
import java.util.Map;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AccessGroupFilters {
    private String[] wildcardFields;
    private Filter[] filters;
    private Map<String, String[]> sort;


    /**
     * Gets the list of wildcard fields.
     *
     * @return the list of wildcard fields.
     */
    @JsonProperty( "wildcard_fields" )
    public String[] getWildcardFields() {
        return wildcardFields;
    }


    /**
     * Sets the list of wildcard fields.
     *
     * @param wildcardFields the list of wildcard fields.
     */
    @JsonProperty( "wildcard_fields" )
    public void setWildcardFields( String[] wildcardFields ) {
        this.wildcardFields = wildcardFields;
    }


    /**
     * Gets the list of filters.
     *
     * @return the list of filters.
     */
    public Filter[] getFilters() {
        return filters;
    }


    /**
     * Sets the list of filters.
     *
     * @param filters the list of filters.
     */
    public void setFilters( Filter[] filters ) {
        this.filters = filters;
    }


    /**
     * Gets the list of sortable fields.
     *
     * @return the list of sortable fields.
     */
    public Map<String, String[]> getSort() {
        return sort;
    }


    /**
     * Sets the list of sortable fields.
     *
     * @param sort the list of sortable fields.
     */
    public void setSort( Map<String, String[]> sort ) {
        this.sort = sort;
    }
}
