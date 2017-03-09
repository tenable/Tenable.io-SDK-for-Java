package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.utilities.models.MacAddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class MacAddressHelper {
    private static final Pattern MAC_ADDRESS = Pattern.compile( "^([0-9A-Fa-f]{1,2}[:-]){5}([0-9A-Fa-f]{1,2})$" );


    /**
     * Returns a MacAddress instance corresponding to the value of the given {@code String}.
     *
     * @param macAddress the MAC Address to be parsed.
     * @return a MacAddress instance corresponding to the value of the given {@code String}.
     * @throws TenableIoException if the string cannot be parsed.
     */
    public static MacAddress parse( String macAddress ) throws TenableIoException {
        // first validates the format
        if( macAddress == null )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "macAddress is null" );

        Matcher m = MAC_ADDRESS.matcher( macAddress );
        if( !m.find() )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid macAddress: %s.", macAddress ) );

        String[] parts = macAddress.split( "[:-]" );
        if( parts.length != MacAddress.MAC_ADDRESS_LENGTH ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid macAddress: %s. Must contain 6 hex numbers separated by : or -.", macAddress ) );
        }

        byte[] bytes = new byte[MacAddress.MAC_ADDRESS_LENGTH];
        try {
            for( int i = 0; i < MacAddress.MAC_ADDRESS_LENGTH; i++ ) {
                String part = parts[i];
                bytes[i] = (byte)Integer.parseInt( part, 16 );
            }
        } catch( NumberFormatException e ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid macAddress: %s. Must contain 6 hex numbers separated by : or -.", macAddress ) );
        }

        return new MacAddress( bytes );
    }


    /**
     * Returns a MacAddress instance corresponding to the given {@code byte} array.
     *
     * @param macAddress the byte array to be parsed.
     * @return a MacAddress instance corresponding to the given {@code byte} array.
     * @throws TenableIoException if the byte array cannot be parsed.
     */
    public static MacAddress parse( byte[] macAddress ) throws TenableIoException {
        if( macAddress.length != MacAddress.MAC_ADDRESS_LENGTH ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid MacAddress bytes array. Length must be %d.", MacAddress.MAC_ADDRESS_LENGTH ) );
        }

        return new MacAddress( macAddress );
    }


    /**
     * Returns a MacAddress instance corresponding to the given {@code long} value.
     * Only the lower 48 bits of the long value are used.
     *
     * @param macAddress the long value to be parsed. Only uses the lower 48 bits.
     * @return a MacAddress instance corresponding to the given {@code long} value.
     */
    public static MacAddress parse( long macAddress ) {
        byte[] addressInBytes = new byte[MacAddress.MAC_ADDRESS_LENGTH];

        for( int i = 0, shift = 40; i < MacAddress.MAC_ADDRESS_LENGTH; i++, shift -= 8 ) {
            addressInBytes[i] = (byte)( ( macAddress >> shift ) & 0xffL );
        }

        return new MacAddress( addressInBytes );
    }
}