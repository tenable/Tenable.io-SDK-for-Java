package com.tenable.io.api.scans.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class HostDetails {
    private HostDetailsInfo info;
    private List<HostCompliance> compliance;
    private HostVulnerability vulnerabilities;


    /**
     * Gets host details info.
     *
     * @return the info
     */
    public HostDetailsInfo getInfo() {
        return info;
    }


    /**
     * Sets host details info.
     *
     * @param info the info
     */
    public void setInfo( HostDetailsInfo info ) {
        this.info = info;
    }


    /**
     * Get list of host compliance.
     *
     * @return the host compliance list
     */
    public List<HostCompliance> getCompliance() {
        return compliance;
    }


    /**
     * Sets the list of host compliance.
     *
     * @param compliance the compliance list
     */
    public void setCompliance( List<HostCompliance> compliance ) {
        this.compliance = compliance;
    }


    /**
     * Gets the list of host vulnerabilities.
     *
     * @return the vulnerabilities list
     */
    public HostVulnerability getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets the list of host vulnerabilities.
     *
     * @param vulnerabilities the list of host vulnerabilities
     */
    public void setVulnerabilities( HostVulnerability vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }
}
