package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum LaunchFrequency {
    /**
     * Daily launch frequency.
     */
    DAILY( "DAILY" ),
    /**
     * Weekly launch frequency.
     */
    WEEKLY( "WEEKLY" ),
    /**
     * Monthly launch frequency.
     */
    MONTHLY( "MONTHLY" ),
    /**
     * Yearly launch frequency.
     */
    YEARLY( "YEARLY" ),
    /**
     * On demand launch frequency.
     */
    ON_DEMAND( "ON_DEMAND" ),

    /**
     * One time launch frequency.
     */
    ONE_TIME( "ONE_TIME" );

    private String value;


    private LaunchFrequency( String value ) {
        this.value = value;
    }


    @JsonValue
    public String getValue() {
        return value;
    }
}
