package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.utilities.models.MacAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class MacAddressTest {
    @Test
    public void testParse() throws TenableIoException {
        MacAddress address = MacAddressHelper.parse( "00:01:02:03:04:05" );
        assertEquals( address, MacAddressHelper.parse( new byte[]{ 0x00, 0x01, 0x02, 0x03, 0x04, 0x05 } ) );
        assertEquals( "00:01:02:03:04:05", address.toString() );
        assertEquals( 0x000102030405L, address.toLong() );

        address = MacAddressHelper.parse( "11:2A:3B:4C:5D:6F" );
        assertEquals( address, MacAddressHelper.parse( new byte[]{ (byte)0x11, (byte)0x2A, (byte)0x3B, 0x4C, 0x5D, 0x6F } ) );
        assertEquals( "11:2A:3B:4C:5D:6F", address.toString() );
        assertEquals( 0x112A3B4C5D6FL, address.toLong() );

        address = MacAddressHelper.parse( 0x010203040506L );
        assertEquals( 0x010203040506L, address.toLong() );
    }


    @Test( expected = TenableIoException.class )
    public void testIllegalFormat1() throws TenableIoException {
        MacAddressHelper.parse( "ZZ:00:01:02:03:04" );
    }


    @Test( expected = TenableIoException.class )
    public void testIllegalFormat2() throws TenableIoException {
        MacAddressHelper.parse( "00:01:02:03:04:05:06" );
    }


    @Test( expected = TenableIoException.class )
    public void testIllegalFormat3() throws TenableIoException {
        MacAddressHelper.parse( "00:01:02:03:04" );
    }


    @Test( expected = TenableIoException.class )
    public void testIllegalFormat4() throws TenableIoException {
        MacAddressHelper.parse( new byte[]{ 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06 } );
    }


    @Test( expected = TenableIoException.class )
    public void testIllegalFormat5() throws TenableIoException {
        MacAddressHelper.parse( new byte[]{ 0x00, 0x01, 0x02, 0x03, 0x04 } );
    }


    @Test
    public void testToLong() throws TenableIoException {
        assertEquals( 0x010203040506L, MacAddressHelper.parse( new byte[]{ (byte)0x01, (byte)0x02, (byte)0x03, (byte)0x04, (byte)0x05, (byte)0x06 } ).toLong() );
        assertEquals( 0x808080808080L, MacAddressHelper.parse( new byte[]{ (byte)0x80, (byte)0x80, (byte)0x80, (byte)0x80, (byte)0x80, (byte)0x80 } ).toLong() );
        assertEquals( 0xFFFFFFFFFFFFL, MacAddressHelper.parse( new byte[]{ (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff } ).toLong() );
    }


    @Test
    public void testIsBroadcast() throws TenableIoException {
        assertTrue( MacAddressHelper.parse( 0xFFFFFFFFFFFFL ).isBroadcast() );
        assertFalse( MacAddressHelper.parse( 0x010203040506L ).isBroadcast() );
    }


    @Test
    public void testIsMulticast() throws TenableIoException {
        assertTrue( MacAddressHelper.parse( 0x0180C2000003L ).isMulticast() );
        assertFalse( MacAddressHelper.parse( 0xFFFFFFFFFFFFL ).isMulticast() );
        assertFalse( MacAddressHelper.parse( 0x010203040506L ).isBroadcast() );
    }
}

