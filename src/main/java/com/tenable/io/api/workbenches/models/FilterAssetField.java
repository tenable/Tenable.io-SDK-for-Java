package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public enum FilterAssetField {
    /**
     * Tenable uuid asset field type filter.
     */
    TENABLE_UUID( "tenable_uuid" ),

    /**
     * Ipv4 asset field type filter.
     */
    IPV4( "ipv4" ),

    /**
     * Mac address asset field type filter.
     */
    MAC_ADDRESS( "mac_address" ),

    /**
     * Netbios asset field type filter.
     */
    NETBIOS_NAME( "netbios_name" ),

    /**
     * Host name asset field type filter.
     */
    FQDN( "fqdn" );


    private final String value;


    FilterAssetField( String value ) {
        this.value = value;
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
