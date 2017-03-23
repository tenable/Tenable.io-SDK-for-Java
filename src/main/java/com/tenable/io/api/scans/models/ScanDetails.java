package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.editors.models.Filter;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanDetails {
    private ScanDetailsInfo info;
    private List<ScanHost> hosts;
    private List<ScanHost> comphosts;
    private List<Note> notes;
    private RemediationsResult remediations;
    private List<ScanVulnerability> vulnerabilities;
    private List<ScanVulnerability> compliances;
    private List<History> histories;
    private List<Filter> filters;


    /**
     * Gets the scan details info object.
     *
     * @return the info
     */
    public ScanDetailsInfo getInfo() {
        return info;
    }


    /**
     * Sets the scan details info object.
     *
     * @param info the scan details info object
     */
    public void setInfo( ScanDetailsInfo info ) {
        this.info = info;
    }


    /**
     * Gets the list of hosts object.
     *
     * @return the host list
     */
    public List<ScanHost> getHosts() {
        return hosts;
    }


    /**
     * Sets the list of hosts object.
     *
     * @param hosts the host list
     */
    public void setHosts( List<ScanHost> hosts ) {
        this.hosts = hosts;
    }


    /**
     * Gets the list of compromised hosts.
     *
     * @return the list of compromised hosts
     */
    public List<ScanHost> getComphosts() {
        return comphosts;
    }


    /**
     * Sets the list of compromised hosts
     *
     * @param comphosts the list of compromised hosts
     */
    public void setComphosts( List<ScanHost> comphosts ) {
        this.comphosts = comphosts;
    }


    /**
     * Gets the list of notes.
     *
     * @return the list of notes
     */
    public List<Note> getNotes() {
        return notes;
    }


    /**
     * Sets the list of notes.
     *
     * @param notes the list of notes
     */
    public void setNotes( List<Note> notes ) {
        this.notes = notes;
    }


    /**
     * Gets the remediations.
     *
     * @return the remediations
     */
    public RemediationsResult getRemediations() {
        return remediations;
    }


    /**
     * Sets the remediations.
     *
     * @param remediations the remediations
     */
    public void setRemediations( RemediationsResult remediations ) {
        this.remediations = remediations;
    }


    /**
     * Gets the list of vulnerabilities.
     *
     * @return the list of vulnerabilities
     */
    public List<ScanVulnerability> getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets the list of vulnerabilities.
     *
     * @param vulnerabilities the list of vulnerabilities
     */
    public void setVulnerabilities( List<ScanVulnerability> vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }


    /**
     * Gets the list of compliances.
     *
     * @return the list of compliances
     */
    @JsonProperty( "compliance" )
    public List<ScanVulnerability> getCompliances() {
        return compliances;
    }


    /**
     * Sets the list of compliances.
     *
     * @param compliances the list of compliances
     */
    public void setCompliances( List<ScanVulnerability> compliances ) {
        this.compliances = compliances;
    }


    /**
     * Gets the list of histories objects.
     *
     * @return the list of histories objects
     */
    @JsonIgnore
    public List<History> getHistories() {
        return histories;
    }


    /**
     * Sets the list of histories objects.
     *
     * @param histories the list of histories objects
     */
    @JsonProperty( "history" )
    public void setHistories( List<History> histories ) {
        this.histories = histories;
    }


    /**
     * Gets the list of filters.
     *
     * @return the list of filters
     */
    public List<Filter> getFilters() {
        return filters;
    }


    /**
     * Sets the list of filters.
     *
     * @param filters the list of filters
     */
    public void setFilters( List<Filter> filters ) {
        this.filters = filters;
    }
}
