package com.tenable.io.core.utilities;


import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;

import java.util.Date;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class DateHelper {
    private static final ISO8601DateFormat iso8601DateFormat = new ISO8601DateFormat();


    /**
     * Parses out the given date into an actual java Date object.
     * The given date is expected to be in one of the ISO 8601 format, but will also take in date that use '/' instead of proper ISO 8601 '-'.
     *
     * @param date the date to pass
     * @return
     * @throws TenableIoException
     */
    public static Date parseIso8601Date( String date ) throws TenableIoException {
        try {
            return iso8601DateFormat.parse( date.replace( '/', '-' ) );
        } catch( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Exception when parsing date \'%s\'.", date ), e );
        }
    }
}
