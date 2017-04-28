package com.tenable.io.api.scannerGroups.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tenable.io.api.models.SeverityLevel;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum ScannerGroupType {
    LOAD_BALANCING( "load_balancing" ),
    SCANNER_POOL( "scanner-pool" );

    private final String value;
    private final String lowerCasedValue;

    ScannerGroupType( String value ) {
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
     * Converts string value to enum value
     *
     * @param value the string value from json
     * @return the SeverityLevel corresponding to the given string value
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static ScannerGroupType forValue( String value ) throws TenableIoException {

        for( ScannerGroupType enumValue : ScannerGroupType.values() ) {
            if( enumValue.lowerCasedValue.equals( value.toLowerCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid ScannerGroupType value: " + value + "." );
    }
}
