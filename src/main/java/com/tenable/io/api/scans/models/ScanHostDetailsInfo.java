package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanHostDetailsInfo {
    private String hostStart;
    private String macAddress;
    private String hostFqdn;
    private String hostEnd;
    private List<String> operatingSystem;
    private String hostIp;


    /**
     * Gets the host start.
     *
     * @return the host start
     */
    @JsonProperty( "host_start" )
    public String getHostStart() {
        return hostStart;
    }


    /**
     * Sets the host start.
     *
     * @param hostStart the host start
     */
    @JsonProperty( "host_start" )
    public void setHostStart( String hostStart ) {
        this.hostStart = hostStart;
    }


    /**
     * Gets the mac address.
     *
     * @return the mac address
     */
    @JsonProperty( "mac-address" )
    public String getMacAddress() {
        return macAddress;
    }


    /**
     * Sets the mac address.
     *
     * @param macAddress the mac address
     */
    @JsonProperty( "mac-address" )
    public void setMacAddress( String macAddress ) {
        this.macAddress = macAddress;
    }


    /**
     * Gets the host fqdn.
     *
     * @return the host fqdn
     */
    @JsonProperty( "host-fqdn" )
    public String getHostFqdn() {
        return hostFqdn;
    }


    /**
     * Sets the host fqdn.
     *
     * @param hostFqdn the host fqdn
     */
    @JsonProperty( "host-fqdn" )
    public void setHostFqdn( String hostFqdn ) {
        this.hostFqdn = hostFqdn;
    }


    /**
     * Gets the host end.
     *
     * @return the host end
     */
    @JsonProperty( "host_end" )
    public String getHostEnd() {
        return hostEnd;
    }


    /**
     * Sets the host end.
     *
     * @param hostEnd the host end
     */
    @JsonProperty( "host_end" )
    public void setHostEnd( String hostEnd ) {
        this.hostEnd = hostEnd;
    }


    /**
     * Gets the operating system.
     *
     * @return the operating system
     */
    @JsonProperty( "operating-system" )
    public List<String> getOperatingSystem() {
        return operatingSystem;
    }


    /**
     * Sets the operating system.
     *
     * @param operatingSystem the operating system
     */
    @JsonProperty( "operating-system" )
    public void setOperatingSystem( List<String> operatingSystem ) {
        this.operatingSystem = operatingSystem;
    }


    /**
     * Gets the host ip.
     *
     * @return the host ip
     */
    @JsonProperty( "host-ip" )
    public String getHostIp() {
        return hostIp;
    }


    /**
     * Sets the host ip.
     *
     * @param hostIp the host ip
     */
    @JsonProperty( "host-ip" )
    public void setHostIp( String hostIp ) {
        this.hostIp = hostIp;
    }
}
