package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class IpAddressHelper {
    /**
     * Convert an IP address to an integer
     *
     * @param ipAddress Input IP address
     * @return The IP address as an integer
     * @throws TenableIoException the tenable sc exception
     */
    public static int ipToInt( String ipAddress ) throws TenableIoException {
        if( ipAddress == null )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "ipAddress is null." );

        int result = 0;
        String[] parts = ipAddress.split( "\\." );

        if( parts.length != 4 )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "ipAddress %s is invalid.", ipAddress ) );

        try {
            for( int i = 3; i >= 0; i-- ) {
                int part = Integer.parseInt( parts[3 - i] );
                if( part < 0 || part > 255 )
                    throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "ipAddress %s is invalid.", ipAddress ) );

                result |= ( part << ( i * 8 ) );
            }
        } catch( NumberFormatException nfe ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "ipAddress %s is invalid.", ipAddress ), nfe );
        }

        return result;
    }


    /**
     * Converts an integer IP to string.
     *
     * @param ip the integer ip
     * @return the IP as a string
     */
    public static String intToIp( int ip ) {
        StringBuilder sb = new StringBuilder( 15 );

        for( int i = 0; i < 4; i++, ip >>= 8 ) {
            sb.insert( 0, Integer.toString( ip & 0xff ) );

            if( i < 3 ) {
                sb.insert( 0, '.' );
            }
        }

        return sb.toString();
    }


    /**
     * Breakdown an IP into 4 individual bytes. Index 0 contains the most significant byte, index 3 the least
     *
     * @param ipAddress the ip address
     * @return the IP into 4 individual bytes. Index 0 contains the most significant byte, index 3 the least
     * @throws TenableIoException the tenable io exception
     */
    public static int[] ipToBytes( int ipAddress ) throws TenableIoException {
        int[] ret = new int[4];

        for( int i = 0; i < 4; i++, ipAddress >>= 8 ) {
            ret[3-i] = ipAddress & 0xff;
        }

        return ret;
    }
}