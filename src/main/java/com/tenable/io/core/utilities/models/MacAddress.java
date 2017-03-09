package com.tenable.io.core.utilities.models;


import java.util.Arrays;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class MacAddress {
    public static final int MAC_ADDRESS_LENGTH = 6;
    private byte[] macAddress = new byte[MAC_ADDRESS_LENGTH];


    public MacAddress( byte[] macAddress ) {
        this.macAddress = Arrays.copyOf( macAddress, MAC_ADDRESS_LENGTH );
    }


    /**
     * Returns the value of the {@code MacAddress} formatted as a {@code byte} array.
     *
     * @return tthe MacAddress formatted as a {@code byte} array.
     */
    public byte[] toBytes() {
        return Arrays.copyOf( macAddress, macAddress.length );
    }


    /**
     * Returns the value of the {@code MacAddress} formatted as a {@code long}.
     *
     * @return the MacAddress formatted as a {@code long}.
     */
    public long toLong() {
        long mac = 0;
        for( int i = 0, shift = 40; i < 6; i++, shift -= 8 ) {
            mac |= ( macAddress[i] & 0xffL ) << shift;
        }
        return mac;
    }


    /**
     * Returns {@code true} if the MacAddress is the broadcast macAddress, false otherwise.
     *
     * @return {@code true} if the MacAddress is the broadcast macAddress, false otherwise.
     */
    public boolean isBroadcast() {
        return toLong() == 0xFFFFFFFFFFFFL;
    }


    /**
     * Returns {@code true} if the MacAddress is the multicast macAddress, false otherwise.
     *
     * @return {@code true} if the MacAddress is the multicast macAddress, false otherwise.
     */
    public boolean isMulticast() {
        return  macAddress[0] != (byte)0xFF && ( macAddress[0] & 0x01 ) != 0;
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode( this.macAddress );
    }


    @Override
    public boolean equals( Object obj ) {
        if( obj == this ) return true;
        if( !( obj instanceof MacAddress ) ) return false;

        return Arrays.equals( this.macAddress, ( (MacAddress)obj ).macAddress );
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for( byte b : macAddress ) {
            builder.append( String.format( "%02X", b & 0xFF ) ).append( ":" );
        }

        builder.setLength( builder.length() - 1 );
        return builder.toString();
    }
}