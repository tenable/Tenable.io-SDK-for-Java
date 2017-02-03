package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum FileFormat {
    /**
     * Nessus file format.
     */
    NESSUS( "nessus" ), /**
     * Html file format.
     */
    HTML( "html" ), /**
     * Pdf file format.
     */
    PDF( "pdf" ), /**
     * Csv file format.
     */
    CSV( "csv" ), /**
     * Db file format.
     */
    DB( "db" );

    private String value;


    private FileFormat( String value ) {
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
     * Converts string value to enum value
     *
     * @param value the string value from json
     * @return the scan status
     * @throws TenableIoException the tenable IO exception
     */
    @JsonCreator
    public static FileFormat forValue( String value ) throws TenableIoException {

        for( FileFormat enumValue : FileFormat.values() ) {
            if( enumValue.getValue().equals( value.toLowerCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid severity level value: " + value + "." );
    }

}
