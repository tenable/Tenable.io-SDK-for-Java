package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum ScanRole {

    /**
     * Scans with these permissions can not be viewed.
     */
    NO_ACCESS( 0 ),

    /**
     * Scans with these permissions can be viewed.
     */
    CAN_VIEW( 16 ),

    /**
     * Scans with these permissions can be controlled.
     */
    CAN_CONTROL( 32 ),

    /**
     * Scans with these permissions can be configured.
     */
    CAN_CONFIGURE( 64 );

    private int value;


    private ScanRole( int value ) {
        this.value = value;
    }


    /**
     * Gets int value.
     *
     * @return the value
     */
    @JsonValue
    public int getValue() {
        return value;
    }
}
