package com.tenable.io.api.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum RiskFactor {
    /**
     * Critical risk factor.
     */
    CRITICAL( "Critical" ),
    /**
     * High risk factor.
     */
    HIGH( "High" ),
    /**
     * Medium risk factor.
     */
    MEDIUM( "Medium" ),
    /**
     * Low risk factor.
     */
    LOW( "Low" ),
    /**
     * no risk factor.
     */
    NONE( "None" );

    private final String value;
    private final String lowerCasedValue;


    RiskFactor( String value ) {
        this.value = value;
        this.lowerCasedValue = value.toLowerCase();
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
     * @return the RiskFactor corresponding to the given string value
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static RiskFactor forValue( String value ) throws TenableIoException {

        for( RiskFactor enumValue : RiskFactor.values() ) {
            if( enumValue.lowerCasedValue.equals( value.toLowerCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid RiskFactor value: " + value + "." );
    }
}
