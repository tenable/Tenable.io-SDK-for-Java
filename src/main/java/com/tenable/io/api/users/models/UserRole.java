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
     * In addition to basic user privileges, users with this role can use existing scan policies that were created by a standard user or higher.
     * They can also analyze scan results and create user target groups.
     */
    SCAN_OPERATOR(24),
    /**
     * Users with this role can create scans, policies, and user target groups.
     */
    STANDARD( 32 ),
    /**
     * In addition to standard user privileges, users with this role can manage scanners, agents, and exclusions.
     */
    SCAN_MANAGER(40),
    /**
     * Users with this role have the same privileges as the standard user but can also manage users, groups, agents, exclusions,
     * system target groups, user target groups, access groups, and scanners.
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
