package com.tenable.io.api.tags.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Copyright (c) 2019 Tenable Network Security, Inc.
 */
public enum TagFilterOperator {
    /**
     * `and` operator for tag filters.
     */
    AND( "and" ),
    /**
     * `or` operator for tag filters.
     */
    OR( "or" );

    private final String value;


    /**
     * Gets operator value.
     *
     * @param value the value
     */
    TagFilterOperator( String value ) {
        this.value = value;
    }


    /**
     * Gets operator value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
