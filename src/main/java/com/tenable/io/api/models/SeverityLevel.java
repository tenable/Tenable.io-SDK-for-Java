package com.tenable.io.api.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    CRITICAL( "Critical", "Critical", 4 ),
    /**
     * High severity level.
     */
    HIGH( "High", "High", 3 ),
    /**
     * Medium severity level.
     */
    MEDIUM( "Medium", "Medium", 2 ),
    /**
     * Low severity level.
     */
    LOW( "Low", "Low", 1 ),
    /**
     * Informational severity level.
     */
    INFO( "Informational", "None", 0 );

    private final String value;
    private final String lowerCasedValue;
    private final String filterValue;
    private final int intValue;


    SeverityLevel( String value, String filterValue, int intValue ) {
        this.value = value;
        this.lowerCasedValue = value.toLowerCase();
        this.filterValue = filterValue;
        this.intValue = intValue;
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
    @JsonIgnore
    public int getIntValue() {
        return intValue;
    }


    /**
     * Gets filter value (value used when filtering).
     *
     * @return the filter value
     */
    public String getFilterValue() {
        return filterValue;
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
     * @return the SeverityLevel corresponding to the given string value
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static SeverityLevel forValue( String value ) throws TenableIoException {

        for( SeverityLevel enumValue : SeverityLevel.values() ) {
            if( enumValue.lowerCasedValue.equals( value.toLowerCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid SeverityLevel value: " + value + "." );
    }


    /**
     * Converts the given int value to a SeverityLevel
     *
     * @param intValue the int severity value
     * @return the SeverityLevel corresponding to the given int value
     * @throws TenableIoException the tenable IO exception
     */
    public static SeverityLevel forIntValue( int intValue ) throws TenableIoException {

        for( SeverityLevel enumValue : SeverityLevel.values() ) {
            if( enumValue.getIntValue() == intValue ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid SeverityLevel int value: " + intValue + "." );
    }
}
