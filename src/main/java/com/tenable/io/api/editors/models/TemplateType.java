package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum TemplateType {
    /**
     * Scan template type.
     */
    SCAN( "scan" ), /**
     * Policy template type.
     */
    POLICY( "policy" );

    private String value;


    private TemplateType( String value ) {
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
    public static TemplateType forValue( String value ) throws TenableIoException {

        for( TemplateType enumValue : TemplateType.values() ) {
            if( enumValue.getValue().equals( value.toLowerCase() ) ) {
                return enumValue;
            }
        }
        throw new TenableIoException( TenableIoErrorCode.DeserializationError, "Invalid template type value: " + value + "." );
    }

}
