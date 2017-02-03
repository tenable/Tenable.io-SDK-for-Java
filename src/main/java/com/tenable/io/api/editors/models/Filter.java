package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Filter {
    private String name;
    private String readableName;
    private List<String> operators;
    private FilterControl control;


    public FilterControl getControl() {
        return control;
    }


    public void setControl( FilterControl control ) {
        this.control = control;
    }


    /**
     * Gets the short name of the filter.
     *
     * @return the short name of the filter.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the short name of the filter.
     *
     * @param name the short name of the filter.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the long name of the filter.
     *
     * @return the long name of the filter.
     */
    @JsonProperty( "readable_name" )
    public String getReadableName() {
        return readableName;
    }


    /**
     * Sets the long name of the filter.
     *
     * @param readableName the long name of the filter.
     */
    @JsonProperty( "readable_name" )
    public void setReadableName( String readableName ) {
        this.readableName = readableName;
    }


    /**
     * Get the comparison options for the filter.
     *
     * @return the comparison options for the filter.
     */
    public List<String> getOperators() {
        return operators;
    }


    /**
     * Sets the comparison options for the filter.
     *
     * @param operators the comparison options for the filter.
     */
    public void setOperators( List<String> operators ) {
        this.operators = operators;
    }
}
