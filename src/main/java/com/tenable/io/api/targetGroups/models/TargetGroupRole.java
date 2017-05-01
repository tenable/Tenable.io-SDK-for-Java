package com.tenable.io.api.targetGroups.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum TargetGroupRole {
    /**
     * Hosts in TargetGroup with these permissions can not be viewed or scanned.
     */
    NO_ACCESS( 0 ),

    /**
     * Hosts in TargetGroup with these permissions can be viewed.
     */
    CAN_VIEW( 32 ),

    /**
     * Hosts in TargetGroup with these permissions can be scanned.
     */
    CAN_SCAN( 64 );

    private int value;


    private TargetGroupRole( int value ) {
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
