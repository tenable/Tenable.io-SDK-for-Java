package com.tenable.io.api.policies.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum PolicyRole {
    /**
     * Policies with these permissions can not be used.
     */
    NO_ACCESS( 0 ),

    /**
     * Policies with these permissions can be used.
     */
    CAN_USE( 16 ),

    /**
     * Policies with these permissions can be edited.
     */
    CAN_EDIT( 32 );

    private int value;


    private PolicyRole( int value ) {
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
