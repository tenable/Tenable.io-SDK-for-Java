package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;

import static com.tenable.io.core.utilities.IpAddressHelper.ipToBytes;
import static com.tenable.io.core.utilities.IpAddressHelper.ipToInt;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class IpRangeHelper {
    private IpRange ipRange;


    /**
     * Instantiates a new Ip range helper.
     *
     * @param ipRangeCidr the ip range cidr
     * @throws TenableIoException the tenable io exception
     */
    public IpRangeHelper( String ipRangeCidr ) throws TenableIoException {
        this.ipRange = parseIpRange( ipRangeCidr );
    }


    /**
     * Instantiates a new Ip range helper.
     *
     * @param lowestIp  the lowest ip
     * @param highestIp the highest ip
     * @throws TenableIoException the tenable io exception
     */
    public IpRangeHelper( String lowestIp, String highestIp ) throws TenableIoException {
        this.ipRange = new LowHighIpRange( ipToInt( lowestIp ), ipToInt( highestIp ) );
    }


    /**
     * Instantiates a new Ip range helper for special range format "xxx[-xxx].xxx[-xxx].xxx[-xxx].xxx[-xxx]".
     *
     * @param ipRangeByte1 the ip range byte 1 (most signification byte)
     * @param ipRangeByte2 the ip range byte 2
     * @param ipRangeByte3 the ip range byte 3
     * @param ipRangeByte4 the ip range byte 4 (least significant byte)
     * @throws TenableIoException the tenable io exception
     */
    public IpRangeHelper( String ipRangeByte1, String ipRangeByte2, String ipRangeByte3, String ipRangeByte4 ) throws TenableIoException {
        this.ipRange = new IpByteLevelRange( ipRangeByte1, ipRangeByte2, ipRangeByte3, ipRangeByte4 );
    }


    /**
     * Instantiates a new Ip range helper.
     *
     * @param ipRange the ip range
     */
    public IpRangeHelper( IpRange ipRange ) {
        this.ipRange = ipRange;
    }


    /**
     * Returns true if the ip is part of the current range.
     *
     * @param ip the ip
     * @return rue if the ip is part of the current range, false otherwise
     * @throws TenableIoException the tenable sc exception
     */
    public boolean isIpWithinRange( String ip ) throws TenableIoException {
        return ipRange.isIpWithinRange( ip );
    }


    /**
     * Returns true if the ip is part of the current range.
     *
     * @param ip the ip
     * @return rue if the ip is part of the current range, false otherwise
     * @throws TenableIoException the tenable sc exception
     */
    public boolean isIpWithinRange( int ip ) throws TenableIoException {
        return ipRange.isIpWithinRange( ip );
    }


    /**
     * Returns true if ip is part of the range [ip1,ip2] or [ip2,ip1]
     *
     * @param ip  the ip
     * @param ip1 range boundary
     * @param ip2 range boundary
     * @return true if ip is part of the range [ip1,ip2] or [ip2,ip1], false otherwise
     * @throws TenableIoException the tenable sc exception
     */
    public static boolean isIpWithinRange( String ip, String ip1, String ip2 ) throws TenableIoException {
        if( ip == null || ip1 == null || ip2 == null )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "ip and/or ip1 and/or ip2 is(are) null." );

        int intIp = ipToInt( ip );
        int intIp1 = ipToInt( ip1 );
        int intIp2 = ipToInt( ip2 );

        return isIpWithinRange( intIp, intIp1, intIp2 );
    }


    /**
     * Returns true if ip is part of the range [ip1,ip2] or [ip2,ip1]
     *
     * @param ip  the ip
     * @param ip1 range boundary
     * @param ip2 range boundary
     * @return true if ip is part of the range [ip1,ip2] or [ip2,ip1], false otherwise
     * @throws TenableIoException the tenable sc exception
     */
    public static boolean isIpWithinRange( int ip, int ip1, int ip2 ) throws TenableIoException {
        if( ip1 < ip2 )
            return ip >= ip1 && ip <= ip2;

        return ip >= ip2 && ip <= ip1;
    }


    /**
     * Returns true if the ip is part of the given CIDR notated range.
     *
     * @param ip          the ip
     * @param ipRangeCidr the ip range cidr
     * @return rue if the ip is part of the given CIDR notated range, false otherwise
     * @throws TenableIoException the tenable sc exception
     */
    public static boolean isIpWithinRange( String ip, String ipRangeCidr ) throws TenableIoException {
        IpCidr ipCidr = parseIpRange( ipRangeCidr );
        return isIpWithinRange( ipToInt( ip ), ipCidr.getLowestIp(), ipCidr.getHighestIp() );
    }


    /**
     * Parses the given ip/cidr into its constituents.
     *
     * @param ipRangeCidr the ip/cidr to parse
     * @return the parse ip/cidr
     * @throws TenableIoException the tenable io exception
     */
    public static IpCidr parseIpRange( String ipRangeCidr ) throws TenableIoException {
        if( ipRangeCidr == null )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "ip and/or ipRangeCidr is(are) null." );

        String[] cidrParts = ipRangeCidr.split( "/" );
        if( cidrParts.length != 2 )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "ipRangeCidr %s is invalid.", ipRangeCidr ) );

        try {
            int cidr = Integer.parseInt( cidrParts[1] );
            if( cidr < 0 || cidr > 32 )
                throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "ipRangeCidr %s is invalid.", ipRangeCidr ) );

            int netmask = 0;
            for( int i = 0; i < cidr; ++i ) {
                netmask |= ( 1 << 31 - i );
            }
            int lowestIp = ipToInt( cidrParts[0] ) & netmask;
            int highestIp = lowestIp + ( 1 << ( 32 - cidr ) ) - 1;

            return new IpCidr( cidr, netmask, lowestIp, highestIp );
        } catch( NumberFormatException nfe ) {
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "ipRangeCidr %s is invalid.", ipRangeCidr ), nfe );
        }
    }


    /**
     * The interface Ip range.
     */
    public interface IpRange {
        /**
         * Is ip within range boolean.
         *
         * @param ip the ip
         * @return the boolean
         * @throws TenableIoException the tenable io exception
         */
        boolean isIpWithinRange( String ip ) throws TenableIoException;


        /**
         * Is ip within range boolean.
         *
         * @param ip the ip
         * @return the boolean
         * @throws TenableIoException the tenable io exception
         */
        boolean isIpWithinRange( int ip ) throws TenableIoException;
    }


    /**
     * The type Low high ip range.
     */
    public static class LowHighIpRange implements IpRange {
        /**
         * The Lowest ip.
         */
        protected int lowestIp;
        /**
         * The Highest ip.
         */
        protected int highestIp;


        /**
         * Instantiates a new Low high ip range.
         *
         * @param lowestIp  the lowest ip
         * @param highestIp the highest ip
         */
        public LowHighIpRange( int lowestIp, int highestIp ) {
            this.lowestIp = lowestIp;
            this.highestIp = highestIp;
        }


        /**
         * Gets lowest ip.
         *
         * @return the lowest ip
         */
        public int getLowestIp() {
            return lowestIp;
        }


        /**
         * Gets highest ip.
         *
         * @return the highest ip
         */
        public int getHighestIp() {
            return highestIp;
        }


        @Override
        public boolean isIpWithinRange( String ip ) throws TenableIoException {
            return IpRangeHelper.isIpWithinRange( IpAddressHelper.ipToInt( ip ), lowestIp, highestIp );
        }


        @Override
        public boolean isIpWithinRange( int ip ) throws TenableIoException {
            return IpRangeHelper.isIpWithinRange( ip, lowestIp, highestIp );
        }
    }


    /**
     * The type Ip cidr.
     */
    public static class IpCidr extends LowHighIpRange {
        private int cidr;
        private int netmask;


        /**
         * Instantiates a new Ip cidr.
         *
         * @param cidr      the cidr
         * @param netmask   the netmask
         * @param lowestIp  the lowest ip
         * @param highestIp the highest ip
         */
        public IpCidr( int cidr, int netmask, int lowestIp, int highestIp ) {
            super( lowestIp, highestIp );

            this.cidr = cidr;
            this.netmask = netmask;
        }


        /**
         * Gets cidr.
         *
         * @return the cidr
         */
        public int getCidr() {
            return cidr;
        }


        /**
         * Gets netmask.
         *
         * @return the netmask
         */
        public int getNetmask() {
            return netmask;
        }
    }


    public static class IpByteLevelRange implements IpRange {
        private int[][] lowHighBytes;


        public IpByteLevelRange( String ipRangeByte1, String ipRangeByte2, String ipRangeByte3, String ipRangeByte4 ) throws TenableIoException {
            lowHighBytes = new int[][]{ parseByte( ipRangeByte1 ), parseByte( ipRangeByte2 ), parseByte( ipRangeByte3 ), parseByte( ipRangeByte4 ) };
        }


        @Override
        public boolean isIpWithinRange( String ip ) throws TenableIoException {
            return isIpWithinRange( ipToInt( ip ) );
        }


        @Override
        public boolean isIpWithinRange( int ip ) throws TenableIoException {
            int[] bytes = ipToBytes( ip );

            int i = 0;
            for( int b : bytes ) {
                if( b < lowHighBytes[i][0] || b > lowHighBytes[i][1] )
                    return false;

                i++;
            }

            return true;
        }


        private int[] parseByte( String b ) throws TenableIoException {
            if( b == null )
                throw new TenableIoException( TenableIoErrorCode.InvalidParameter, "Range byte is null" );

            String[] parts = b.split( "-" );
            if( parts.length == 0 || parts.length > 2 )
                throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid range byte value %s.", b ) );

            try {
                int low = Integer.parseInt( parts[0] );
                int[] ret = new int[]{ low, parts.length > 1 ? Integer.parseInt( parts[1] ) : low };

                if( ret[0] < 0 || ret[0] > 255 || ret[1] < 0 || ret[1] > 255 )
                    throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid range byte value %s.", b ) );

                return ret;
            } catch( NumberFormatException nfe ) {
                throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "Invalid range byte value %s.", b ) );
            }
        }
    }
}
