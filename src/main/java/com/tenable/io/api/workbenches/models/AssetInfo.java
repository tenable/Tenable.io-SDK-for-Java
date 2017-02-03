package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetInfo {
    private String firstSeen;
    private List<String> fqdn;
    private List<String> ipv4;
    private List<String> ipv6;
    private String lastAuthenticatedScanDate;
    private String lastSeen;
    private List<String> macAddress;
    private List<String> netbiosName;
    private List<String> operatingSystem;
    private List<String> systemType;


    /**
     * Gets first seen.
     *
     * @return the first seen
     */
    @JsonProperty( "first_seen" )
    public String getFirstSeen() {
        return firstSeen;
    }


    /**
     * Sets first seen.
     *
     * @param firstSeen the first seen
     */
    @JsonProperty( "first_seen" )
    public void setFirstSeen( String firstSeen ) {
        this.firstSeen = firstSeen;
    }


    /**
     * Gets fqdn.
     *
     * @return the fqdn
     */
    public List<String> getFqdn() {
        return fqdn;
    }


    /**
     * Sets fqdn.
     *
     * @param fqdn the fqdn
     */
    public void setFqdn( List<String> fqdn ) {
        this.fqdn = fqdn;
    }


    /**
     * Gets ipv 4.
     *
     * @return the ipv 4
     */
    public List<String> getIpv4() {
        return ipv4;
    }


    /**
     * Sets ipv 4.
     *
     * @param ipv4 the ipv 4
     */
    public void setIpv4( List<String> ipv4 ) {
        this.ipv4 = ipv4;
    }


    /**
     * Gets ipv 6.
     *
     * @return the ipv 6
     */
    public List<String> getIpv6() {
        return ipv6;
    }


    /**
     * Sets ipv 6.
     *
     * @param ipv6 the ipv 6
     */
    public void setIpv6( List<String> ipv6 ) {
        this.ipv6 = ipv6;
    }


    /**
     * Gets last authenticated scan date.
     *
     * @return the last authenticated scan date
     */
    @JsonProperty( "last_authenticated_scan_date" )
    public String getLastAuthenticatedScanDate() {
        return lastAuthenticatedScanDate;
    }


    /**
     * Sets last authenticated scan date.
     *
     * @param lastAuthenticatedScanDate the last authenticated scan date
     */
    @JsonProperty( "last_authenticated_scan_date" )
    public void setLastAuthenticatedScanDate( String lastAuthenticatedScanDate ) {
        this.lastAuthenticatedScanDate = lastAuthenticatedScanDate;
    }


    /**
     * Gets last seen.
     *
     * @return the last seen
     */
    @JsonProperty( "last_seen" )
    public String getLastSeen() {
        return lastSeen;
    }


    /**
     * Sets last seen.
     *
     * @param lastSeen the last seen
     */
    @JsonProperty( "last_seen" )
    public void setLastSeen( String lastSeen ) {
        this.lastSeen = lastSeen;
    }


    /**
     * Gets mac address.
     *
     * @return the mac address
     */
    @JsonProperty( "mac_address" )
    public List<String> getMacAddress() {
        return macAddress;
    }


    /**
     * Sets mac address.
     *
     * @param macAddress the mac address
     */
    @JsonProperty( "mac_address" )
    public void setMacAddress( List<String> macAddress ) {
        this.macAddress = macAddress;
    }


    /**
     * Gets netbios name.
     *
     * @return the netbios name
     */
    @JsonProperty( "netbios_name" )
    public List<String> getNetbiosName() {
        return netbiosName;
    }


    /**
     * Sets netbios name.
     *
     * @param netbiosName the netbios name
     */
    @JsonProperty( "netbios_name" )
    public void setNetbiosName( List<String> netbiosName ) {
        this.netbiosName = netbiosName;
    }


    /**
     * Gets operating system.
     *
     * @return the operating system
     */
    @JsonProperty( "operating_system" )
    public List<String> getOperatingSystem() {
        return operatingSystem;
    }


    /**
     * Sets operating system.
     *
     * @param operatingSystem the operating system
     */
    @JsonProperty( "operating_system" )
    public void setOperatingSystem( List<String> operatingSystem ) {
        this.operatingSystem = operatingSystem;
    }


    /**
     * Gets system type.
     *
     * @return the system type
     */
    @JsonProperty( "system_type" )
    public List<String> getSystemType() {
        return systemType;
    }


    /**
     * Sets system type.
     *
     * @param systemType the system type
     */
    @JsonProperty( "system_type" )
    public void setSystemType( List<String> systemType ) {
        this.systemType = systemType;
    }
}
