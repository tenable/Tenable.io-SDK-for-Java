package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum FilterSearchType {
    /**
     * And filter search type.
     */
    AND( "and" ),
    /**
     * Or filter search type.
     */
    OR( "or" );


    private final String value;


    FilterSearchType( String value ) {
        this.value = value;
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
