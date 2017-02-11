package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum SeverityLevel {
    /**
     * Critical severity level.
     */
    CRITICAL( "critical" ), /**
     * High severity level.
     */
    HIGH( "high" ), /**
     * Medium severity level.
     */
    MEDIUM( "medium" ), /**
     * Low severity level.
     */
    LOW( "low" );

    private String value;


    private SeverityLevel( String value ) {
        this.value = value;
    }


    /**
     * Gets string value.
     *
     * @return the string value
     */
    @JsonValue
    public String getValue() {
        return value;
    }


    /**
     * Gets string value.
     *
     * @return the string value
     */
    public String toString() {
        return getValue();
    }


    /**
     * Converts string value to enum value
     *
     * @param value the string value from json
     * @return the scan status
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static SeverityLevel forValue( String value ) throws TenableIoException {

        for( SeverityLevel enumValue : SeverityLevel.values() ) {
            if( enumValue.getValue().equals( value.toLowerCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid SeverityLevel value: " + value + "." );
    }
}
