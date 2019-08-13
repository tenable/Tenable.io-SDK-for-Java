package com.tenable.io.api.scans.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanHostDetails {
    private ScanHostDetailsInfo info;
    private List<ScanHostCompliance> compliance;
    private List<ScanHostVulnerability> vulnerabilities;


    /**
     * Gets host details info.
     *
     * @return the info
     */
    public ScanHostDetailsInfo getInfo() {
        return info;
    }


    /**
     * Sets host details info.
     *
     * @param info the info
     */
    public void setInfo( ScanHostDetailsInfo info ) {
        this.info = info;
    }


    /**
     * Get list of host compliance.
     *
     * @return the host compliance list
     */
    public List<ScanHostCompliance> getCompliance() {
        return compliance;
    }


    /**
     * Sets the list of host compliance.
     *
     * @param compliance the compliance list
     */
    public void setCompliance( List<ScanHostCompliance> compliance ) {
        this.compliance = compliance;
    }


    /**
     * Gets the list of host vulnerabilities.
     *
     * @return the vulnerabilities list
     */
    public List<ScanHostVulnerability> getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets the list of host vulnerabilities.
     *
     * @param vulnerabilities the list of host vulnerabilities
     */
    public void setVulnerabilities( List<ScanHostVulnerability> vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }
}
