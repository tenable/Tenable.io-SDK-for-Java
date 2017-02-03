package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class RemediationsResult {
    private List<Remediation> remediations;
    private int numHosts;
    private int numCves;
    private int numImpactedHosts;
    private int numRemediatedCves;


    /**
     * Gets the list of remediation.
     *
     * @return the remediation list
     */
    public List<Remediation> getRemediations() {
        return remediations;
    }


    /**
     * Sets the remediation list.
     *
     * @param remediations the remediation list
     */
    public void setRemediations( List<Remediation> remediations ) {
        this.remediations = remediations;
    }


    /**
     * Gets the number of hosts.
     *
     * @return the number of hosts
     */
    @JsonProperty( "num_hosts" )
    public int getNumHosts() {
        return numHosts;
    }


    /**
     * Sets the number of hosts.
     *
     * @param numHosts the number of hosts
     */
    @JsonProperty( "num_hosts" )
    public void setNumHosts( int numHosts ) {
        this.numHosts = numHosts;
    }


    /**
     * Gets the number of security vulnerabilities and exposures.
     *
     * @return the number of security vulnerabilities and exposures
     */
    @JsonProperty( "num_cves" )
    public int getNumCves() {
        return numCves;
    }


    /**
     * Sets the number of security vulnerabilities and exposures.
     *
     * @param numCves the number of security vulnerabilities and exposures
     */
    @JsonProperty( "num_cves" )
    public void setNumCves( int numCves ) {
        this.numCves = numCves;
    }


    /**
     * Gets the number of impacted hosts.
     *
     * @return the number of impacted hosts
     */
    @JsonProperty( "num_impacted_hosts" )
    public int getNumImpactedHosts() {
        return numImpactedHosts;
    }


    /**
     * Sets the number of impacted hosts.
     *
     * @param numImpactedHosts the number of impacted hosts
     */
    @JsonProperty( "num_impacted_hosts" )
    public void setNumImpactedHosts( int numImpactedHosts ) {
        this.numImpactedHosts = numImpactedHosts;
    }


    /**
     * Gets the number of remediated security vulnerabilities and exposures.
     *
     * @return the number of remediated security vulnerabilities and exposures
     */
    @JsonProperty( "num_remediated_cves" )
    public int getNumRemediatedCves() {
        return numRemediatedCves;
    }


    /**
     * Sets the number of remediated security vulnerabilities and exposures.
     *
     * @param numRemediatedCves the number of remediated security vulnerabilities and exposures
     */
    @JsonProperty( "num_remediated_cves" )
    public void setNumRemediatedCves( int numRemediatedCves ) {
        this.numRemediatedCves = numRemediatedCves;
    }
}
