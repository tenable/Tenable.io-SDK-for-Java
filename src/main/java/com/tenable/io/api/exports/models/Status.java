package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public enum Status {
    /**
     * The export request is queued
      */
    QUEUED,
    /**
     * The export request is being processed
     */
    PROCESSING,
    /**
     * The export is ready for download
     */
    FINISHED,
    /**
     * An error occurred while preparing export
     */
    ERROR;

    /**
     * Converts string value to enum value
     *
     * @param value the string value from json
     * @return the scan status
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static Status forValue( String value ) throws TenableIoException {

        for( Status enumValue : Status.values() ) {
            if( enumValue.toString().equals( value.toUpperCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid export status value: " + value + "." );
    }
}
