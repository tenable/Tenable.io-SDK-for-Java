package com.tenable.io.api.scanners.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum ScannerRole {
    /**
     * Scanners with these permissions can not be used.
     */
    NO_ACCESS( 0 ),

    /**
     * Scanners with these permissions can be used.
     */
    CAN_USE( 16 ),

    /**
     * Scanners with these permissions can be managed.
     */
    CAN_MANAGE( 64 );

    private int value;


    private ScannerRole( int value ) {
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
