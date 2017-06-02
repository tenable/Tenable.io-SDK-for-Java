package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 * <p>
 * This is a helper class to parse comma separated target and determine if they are hostname, IP, IP range with CIDR or dash separated IP range
 */
public class TargetsHelper {
    private static final Pattern IP_ADDRESS = Pattern.compile( "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})" );
    private static final Pattern ONLY_IP_ADDRESS = Pattern.compile( "^" + IP_ADDRESS + "$" );
    private static final Pattern SLASH_FORMAT = Pattern.compile( "^" + IP_ADDRESS + "/(?<cidr>\\d{1,3})$" );
    private static final Pattern IP_ADDRESS_RANGE = Pattern.compile( "^(?<ip1>" + IP_ADDRESS + ")-(?<ip2>" + IP_ADDRESS + ")$" );
    private static final Pattern IP_ADDRESS_WITH_RANGE = Pattern.compile( "^(?<byte1>\\d{1,3}(?:-\\d{1,3})?)\\.(?<byte2>\\d{1,3}(?:-\\d{1,3})?)\\.(?<byte3>\\d{1,3}(?:-\\d{1,3})?)\\.(?<byte4>\\d{1,3}(?:-\\d{1,3})?)$" );
    private static final Pattern HOSTNAME_AND_IP = Pattern.compile( "(?<hostname>.+)\\[(?<ip>" + IP_ADDRESS + ")]" );

    private List<Target> targets;


    /**
     * Instantiates a new Targets helper.
     *
     * @param commaSeparatedTargets the comma separated targets
     * @throws TenableIoException the tenable io exception
     */
    public TargetsHelper( String commaSeparatedTargets ) throws TenableIoException {
        targets = parseTargets( commaSeparatedTargets );
    }


    /**
     * Returns true if the given ipOrHostname matches any of the targets.
     *
     * @param ipOrHostname the ip or hostname
     * @return true if the given ipOrHostname matches any of the targets, false otherwise
     * @throws TenableIoException the tenable io exception
     */
    public boolean isTarget( String ipOrHostname ) throws TenableIoException {
        for( Target target : targets ) {
            if( target.match( ipOrHostname ) )
                return true;
        }

        return false;
    }


    private List<Target> parseTargets( String commaSeparatedTargets ) throws TenableIoException {
        // first split them
        String[] targets = commaSeparatedTargets.split( "," );

        List<Target> ret = new ArrayList<>( targets.length );

        for( String target : targets ) {
            Matcher matcher = null;
            // is it an IP range in the form x.x.x.x-x.x.x.x
            if( ( matcher = IP_ADDRESS_RANGE.matcher( target ) ).matches() ) {
                ret.add( new Target().withIpRange( matcher.group( "ip1" ), matcher.group( "ip2" ) ) );
            } else if( ( matcher = SLASH_FORMAT.matcher( target ) ).matches() ) {
                ret.add( new Target().withIpRange( matcher.group( 0 ) ) );
            } else if( ( matcher = ONLY_IP_ADDRESS.matcher( target ) ).matches() ) {
                ret.add( new Target().withIp( matcher.group( 0 ) ) );
            } else if( ( matcher = IP_ADDRESS_WITH_RANGE.matcher( target ) ).matches() ) {
                ret.add( new Target().withIpRange( matcher.group( "byte1" ), matcher.group( "byte2" ), matcher.group( "byte3" ), matcher.group( "byte4" ) ) );
            } else if( ( matcher = HOSTNAME_AND_IP.matcher( target ) ).matches() ) {
                ret.add(new Target().withHostname(matcher.group("hostname")));
                ret.add(new Target().withIp(matcher.group("ip")));
            } else { //hostname
                ret.add( new Target().withHostname( target.toLowerCase() ) );
            }
        }

        return ret;
    }


    private class Target {
        private static final int IP = 0;
        private static final int HOSTNAME = 1;
        private static final int RANGE = 2;

        private int type = -1;
        private String ip;
        private String hostname;
        private IpRangeHelper ipRange;


        /**
         * Gets ip.
         *
         * @return the ip
         */
        public String getIp() {
            return ip;
        }


        /**
         * With ip target.
         *
         * @param ip the ip
         * @return the target
         */
        public Target withIp( String ip ) {
            this.ip = ip;
            type = IP;
            return this;
        }


        /**
         * Gets hostname.
         *
         * @return the hostname
         */
        public String getHostname() {
            return hostname;
        }


        /**
         * With hostname target.
         *
         * @param hostname the hostname
         * @return the target
         */
        public Target withHostname( String hostname ) {
            this.hostname = hostname;
            type = HOSTNAME;
            return this;
        }


        /**
         * Gets ip range.
         *
         * @return the ip range
         */
        public IpRangeHelper getIpRange() {
            return ipRange;
        }


        /**
         * With ip range target.
         *
         * @param ipRangeCidr the ip range cidr
         * @return the target
         * @throws TenableIoException the tenable io exception
         */
        public Target withIpRange( String ipRangeCidr ) throws TenableIoException {
            this.ipRange = new IpRangeHelper( ipRangeCidr );
            type = RANGE;
            return this;
        }


        /**
         * With ip range target.
         *
         * @param lowestIp  the lowest ip
         * @param highestIp the highest ip
         * @return the target
         * @throws TenableIoException the tenable io exception
         */
        public Target withIpRange( String lowestIp, String highestIp ) throws TenableIoException {
            this.ipRange = new IpRangeHelper( lowestIp, highestIp );
            type = RANGE;
            return this;
        }


        /**
         * With ip range target.
         *
         * @param ipRangeByte1 the ip range byte 1 (most signification byte)
         * @param ipRangeByte2 the ip range byte 2
         * @param ipRangeByte3 the ip range byte 3
         * @param ipRangeByte4 the ip range byte 4 (least significant byte)
         * @return the target
         * @throws TenableIoException the tenable io exception
         */
        public Target withIpRange( String ipRangeByte1, String ipRangeByte2, String ipRangeByte3, String ipRangeByte4  ) throws TenableIoException {
            this.ipRange = new IpRangeHelper( ipRangeByte1, ipRangeByte2, ipRangeByte3, ipRangeByte4 );
            type = RANGE;
            return this;
        }


        /**
         * Match boolean.
         *
         * @param ipOrHostname the ip or hostname
         * @return the boolean
         * @throws TenableIoException the tenable io exception
         */
        public boolean match( String ipOrHostname ) throws TenableIoException {
            boolean ret = false;

            switch( type ) {
                case IP:
                    if( getIp().equals( ipOrHostname ) ) ret = true;
                    break;
                case HOSTNAME:
                    if( getHostname().equals( ipOrHostname.toLowerCase() ) ) ret = true;
                    break;
                case RANGE:
                    Matcher matcher;
                    if( ( matcher = IP_ADDRESS.matcher( ipOrHostname ) ).matches() ) {
                        if( getIpRange().isIpWithinRange( matcher.group( 0 ) ) ) ret = true;
                    }
                    break;
            }

            return ret;
        }
    }
}
