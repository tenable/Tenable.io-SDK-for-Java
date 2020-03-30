package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum ScanStatus {
    /**
     * Initializing scan status.
     */
    INITIALIZING,
    /**
     * Completed scan status.
     */
    COMPLETED,
    /**
     * Aborted scan status.
     */
    ABORTED,
    /**
     * Imported scan status.
     */
    IMPORTED,
    /**
     * Pending scan status.
     */
    PENDING,
    /**
     * Queued scan status.
     */
    QUEUED,
    /**
     * Running scan status.
     */
    RUNNING,
    /**
     * Resuming scan status.
     */
    RESUMING,
    /**
     * Canceling scan status.
     */
    CANCELING,
    /**
     * Cancelled scan status.
     */
    CANCELLED,
    /**
     * Pausing scan status.
     */
    PAUSING,
    /**
     * Paused scan status.
     */
    PAUSED,
    /**
     * Stopping scan status.
     */
    STOPPING,
    /**
     * Stopped scan status.
     */
    STOPPED,
    /**
     * Canceled scan status.
     */
    CANCELED,
    /**
     * Empty scan status.
     */
    EMPTY,
    /**
     * Processing scan status.
     */
    PROCESSING;


    /**
     * Converts string value to enum value
     *
     * @param value the string value from json
     * @return the scan status
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static ScanStatus forValue( String value ) throws TenableIoException {

        for( ScanStatus enumValue : ScanStatus.values() ) {
            if( enumValue.toString().equals( value.toUpperCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid scan status value: " + value + "." );
    }
}
