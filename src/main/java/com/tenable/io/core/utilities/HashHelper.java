package com.tenable.io.core.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class HashHelper {
    /**
     * Hash sha 256 string.
     *
     * @param data the data to hash
     * @return the hashed string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static String hashSha256( String data ) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance( "SHA-256" );
        messageDigest.update( data.getBytes() );
        return bytesToHex( messageDigest.digest() );
    }

    /**
     * Bytes to hex string.
     *
     * @param bytes the byte array to hash
     * @return the hashed string
     */
    public static String bytesToHex( byte[] bytes ) {
        StringBuffer result = new StringBuffer();
        for ( byte byt : bytes ) result.append( Integer.toString( ( byt & 0xff ) + 0x100, 16 ).substring( 1 ) );
        return result.toString();
    }
}
