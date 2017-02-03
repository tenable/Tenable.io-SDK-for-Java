package com.tenable.io.api.users.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum UserRole {
    /**
     * Users with this role can view and configure scan results.
     */
    BASIC( 16 ),
    /**
     * Users with this role can create scans, policies, and user asset lists.
     */
    STANDARD( 32 ),
    /**
     * Users with this role have the same privileges as the standard user but can also manage users, groups,
     * agents, exclusions, asset lists, and scanners.
     */
    ADMINISTRATOR( 64 );

    private int value;


    private UserRole( int value ) {
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


    @JsonCreator
    public static UserRole forValue( int value ) throws TenableIoException {
        for( UserRole permission : UserRole.values() ) {
            if( permission.getValue() == value )
                return permission;
        }

        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid user permission value: " + value + "." );
    }
}
