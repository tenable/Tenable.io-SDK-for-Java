package com.tenable.io.api.tags.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.workbenches.models.FilterOperator;

/**
 * Copyright (c) 2019 Tenable Network Security, Inc.
 */
public class TagFilter {

    private String field;
    private FilterOperator operator;
    private String value;

    public TagFilter() {}


    public TagFilter( String field, FilterOperator operator, String value ) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }


    /**
     * Gets the field for a filter.
     *
     * @return the field of the filter.
     */
    @JsonProperty( "field" )
    public String getField() {
        return field;
    }


    /**
     * Sets the field for a filter.
     *
     * @param field field of the filter.
     */
    @JsonProperty( "field" )
    public void setField( String field ) {
        this.field = field;
    }


    /**
     * Gets the operator for a filter.
     *
     * @return the operator of the filter.
     */
    @JsonProperty( "operator" )
    public FilterOperator getOperator() {
        return operator;
    }


    /**
     * Sets the operastor for a filter.
     *
     * @param operator the operator of the filter.
     */
    @JsonProperty( "operator" )
    public void setOperator( FilterOperator operator ) {
        this.operator = operator;
    }


    /**
     * Gets the value for a filter.
     *
     * @return the value of the filter.
     */
    @JsonProperty( "value" )
    public String getValue() {
        return value;
    }


    /**
     * Sets the value for a filter.
     *
     * @param value the value of the filter.
     */
    @JsonProperty( "value" )
    public void setValue( String value ) {
        this.value = value;
    }
}
