package com.tenable.io.api.scans.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Remediation {
    private String value;
    private String remediation;
    private int hosts;
    private int vulns;


    /**
     * Gets the unique id of the remediation.
     *
     * @return the unique id of the remediation.
     */
    public String getValue() {
        return value;
    }


    /**
     * Sets the unique id of the remediation.
     *
     * @param value the unique id of the remediation.
     */
    public void setValue( String value ) {
        this.value = value;
    }


    /**
     * Gets specific information related to the vulnerability and steps to remedy.
     *
     * @return specific information related to the vulnerability and steps to remedy.
     */
    public String getRemediation() {
        return remediation;
    }


    /**
     * Sets specific information related to the vulnerability and steps to remedy.
     *
     * @param remediation specific information related to the vulnerability and steps to remedy.
     */
    public void setRemediation( String remediation ) {
        this.remediation = remediation;
    }


    /**
     * Gets the number of hosts affected.
     *
     * @return the number of hosts affected.
     */
    public int getHosts() {
        return hosts;
    }


    /**
     * Sets the number of hosts affected.
     *
     * @param hosts the number of hosts affected.
     */
    public void setHosts( int hosts ) {
        this.hosts = hosts;
    }


    /**
     * Gets the number of vulnerabilities associated with the remedy.
     *
     * @return the number of vulnerabilities associated with the remedy.
     */
    public int getVulns() {
        return vulns;
    }


    /**
     * Sets the number of vulnerabilities associated with the remedy.
     *
     * @param vulns the number of vulnerabilities associated with the remedy.
     */
    public void setVulns( int vulns ) {
        this.vulns = vulns;
    }
}
