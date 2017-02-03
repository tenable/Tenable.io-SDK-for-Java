package com.tenable.io.api.agents.models;


import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum AgentRole {
    /**
     * Agent groups with these permissions can not be used.
     */
    NO_ACCESS( 0 ),

    /**
     * Agent groups with these permissions can be used.
     */
    CAN_USE( 16 );

    private int value;


    private AgentRole( int value ) {
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
