package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class IpHelperTest {

    @Test
    public void testIpParsing() throws TenableIoException {
        String ip = "172.217.4.142";
        int intIp = IpAddressHelper.ipToInt( ip );
        assertEquals( intIp,0xACD9048E );
        assertEquals( ip, IpAddressHelper.intToIp( intIp ) );

        ip = "0.0.0.0";
        intIp = IpAddressHelper.ipToInt( ip );
        assertEquals( intIp,0 );
        assertEquals( ip, IpAddressHelper.intToIp( intIp ) );

        ip = "255.255.255.255";
        intIp = IpAddressHelper.ipToInt( ip );
        assertEquals( intIp,0xFFFFFFFF );
        assertEquals( ip, IpAddressHelper.intToIp( intIp ) );


        ip = "255.255.255.309";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "255.255.309.255";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "255.309.255.255";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "309.255.255.255";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "255.xx.255.255";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "255.255.255";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "255.255.255.255.255";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        ip = "hello";
        try {
            intIp = IpAddressHelper.ipToInt( ip );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }
    }


    @Test
    public void testIpRange() throws TenableIoException {
        IpRangeHelper.IpCidr ipCidr = IpRangeHelper.parseIpRange("172.217.4.142/24" );
        assertEquals( ipCidr.getCidr(), 24 );
        assertEquals( ipCidr.getNetmask(), 0xFFFFFF00 );
        assertEquals( ipCidr.getLowestIp(), IpAddressHelper.ipToInt("172.217.4.0" ) );
        assertEquals( ipCidr.getHighestIp(), IpAddressHelper.ipToInt("172.217.4.255" ) );

        ipCidr = IpRangeHelper.parseIpRange("172.217.4.141/31" );
        assertEquals( ipCidr.getCidr(), 31 );
        assertEquals( ipCidr.getNetmask(), 0xFFFFFFFE );
        assertEquals( ipCidr.getLowestIp(), IpAddressHelper.ipToInt("172.217.4.140" ) );
        assertEquals( ipCidr.getHighestIp(), IpAddressHelper.ipToInt("172.217.4.141" ) );

        ipCidr = IpRangeHelper.parseIpRange("172.217.4.141/32" );
        assertEquals( ipCidr.getCidr(), 32 );
        assertEquals( ipCidr.getNetmask(), 0xFFFFFFFF );
        assertEquals( ipCidr.getLowestIp(), IpAddressHelper.ipToInt("172.217.4.141" ) );
        assertEquals( ipCidr.getHighestIp(), IpAddressHelper.ipToInt("172.217.4.141" ) );

        try {
            ipCidr = IpRangeHelper.parseIpRange("172.217.4.141/33" );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        try {
            ipCidr = IpRangeHelper.parseIpRange("172.217.4.141/-2" );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        try {
            ipCidr = IpRangeHelper.parseIpRange("172.217.4.141/xx" );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }

        try {
            ipCidr = IpRangeHelper.parseIpRange("172.217.4.141|33" );
        } catch( TenableIoException tioe ) {
            assertEquals( tioe.getErrorCode(), TenableIoErrorCode.InvalidParameter );
        }
    }


    @Test
    public void testInitIpRangeHelper() throws TenableIoException {
        IpRangeHelper ipRangeHelper = new IpRangeHelper( "172.217.4.142/24" );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.142" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.0" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.255" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.5.142" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.3.142" ) );

        ipRangeHelper = new IpRangeHelper( "172.217.4.141/31" );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.140" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.141" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.142" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.139" ) );

        ipRangeHelper = new IpRangeHelper( "172.217.4.141/32" );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.141" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.140" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.142" ) );

        ipRangeHelper = new IpRangeHelper( "172.217.4.0", "172.217.4.255" );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.142" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.0" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.255" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.5.142" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.3.142" ) );

        ipRangeHelper = new IpRangeHelper( "172.217.4.140", "172.217.4.141" );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.140" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.141" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.142" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.139" ) );

        ipRangeHelper = new IpRangeHelper( "172.217.4.141", "172.217.4.141" );
        assertTrue( ipRangeHelper.isIpWithinRange( "172.217.4.141" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.140" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "172.217.4.142" ) );

        ipRangeHelper = new IpRangeHelper( "10-20", "100-120", "50", "70-80" );
        assertTrue( ipRangeHelper.isIpWithinRange( "10.100.50.70" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "20.120.50.80" ) );
        assertTrue( ipRangeHelper.isIpWithinRange( "15.110.50.75" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "9.110.50.75" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "21.110.50.75" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "10.99.50.75" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "10.121.50.75" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "10.120.50.69" ) );
        assertFalse( ipRangeHelper.isIpWithinRange( "10.120.50.81" ) );
    }

    @Test
    public void testTargetHelper() throws TenableIoException {
        TargetsHelper targetsHelper = new TargetsHelper(
                "172-174.217-230.5.142-150," +
                        "1.10.100.1," +
                        "google.com," +
                        "10.100.1.30/24," +
                        "100.200.210.50-100.200.220.60," +
                        "ec2-52-71-36-167.compute-1.amazonaws.com[52.71.36.167]" );

        // 172-174.217-230.5.142-150
        assertTrue( targetsHelper.isTarget( "172.217.5.142" ) );
        assertTrue( targetsHelper.isTarget( "174.230.5.150" ) );
        assertTrue( targetsHelper.isTarget( "173.220.5.144" ) );
        assertFalse( targetsHelper.isTarget( "173.240.5.144" ) );
        assertFalse( targetsHelper.isTarget( "175.220.5.144" ) );
        assertFalse( targetsHelper.isTarget( "174.240.5.144" ) );

        // 1.10.100.1
        assertTrue( targetsHelper.isTarget( "1.10.100.1" ) );
        assertFalse( targetsHelper.isTarget( "1.10.100.2" ) );

        // google.com
        assertTrue( targetsHelper.isTarget( "google.com" ) );
        assertFalse( targetsHelper.isTarget( "google1.com" ) );

        // 10.100.1.30/24
        assertTrue( targetsHelper.isTarget( "10.100.1.0" ) );
        assertTrue( targetsHelper.isTarget( "10.100.1.255" ) );
        assertTrue( targetsHelper.isTarget( "10.100.1.31" ) );
        assertFalse( targetsHelper.isTarget( "10.100.2.31" ) );
        assertFalse( targetsHelper.isTarget( "10.100.0.31" ) );

        // 100.200.210.50-100.200.220.
        assertTrue( targetsHelper.isTarget( "100.200.210.50" ) );
        assertTrue( targetsHelper.isTarget( "100.200.220.60" ) );
        assertTrue( targetsHelper.isTarget( "100.200.215.40" ) );
        assertTrue( targetsHelper.isTarget( "100.200.219.55" ) );
        assertFalse( targetsHelper.isTarget( "100.200.221.55" ) );
        assertFalse( targetsHelper.isTarget( "100.200.209.55" ) );
        assertFalse( targetsHelper.isTarget( "100.200.210.49" ) );
        assertFalse( targetsHelper.isTarget( "100.200.220.61" ) );

        //"ec2-52-71-36-167.compute-1.amazonaws.com[52.71.36.167]" );
        assertTrue( targetsHelper.isTarget( "ec2-52-71-36-167.compute-1.amazonaws.com" ) );
        assertTrue( targetsHelper.isTarget( "52.71.36.167" ) );
        assertFalse( targetsHelper.isTarget( "ec1-52-71-36-167.compute-1.amazonaws.com" ) );
        assertFalse( targetsHelper.isTarget( "52.71.36.169" ) );
    }
}
