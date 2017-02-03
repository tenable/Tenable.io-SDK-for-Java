package com.tenable.io.api.scans.models;


import com.tenable.io.api.editors.models.Filter;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanDetails {
    private ScanDetailsInfo info;
    private List<Host> hosts;
    private List<Host> comphosts;
    private List<Note> notes;
    private RemediationsResult remediations;
    private List<Vulnerability> vulnerabilities;
    private List<Vulnerability> compliance;
    private List<History> history;
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
    public List<Host> getHosts() {
        return hosts;
    }


    /**
     * Sets the list of hosts object.
     *
     * @param hosts the host list
     */
    public void setHosts( List<Host> hosts ) {
        this.hosts = hosts;
    }


    /**
     * Gets the list of compromised hosts.
     *
     * @return the list of compromised hosts
     */
    public List<Host> getComphosts() {
        return comphosts;
    }


    /**
     * Sets the list of compromised hosts
     *
     * @param comphosts the list of compromised hosts
     */
    public void setComphosts( List<Host> comphosts ) {
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
    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets the list of vulnerabilities.
     *
     * @param vulnerabilities the list of vulnerabilities
     */
    public void setVulnerabilities( List<Vulnerability> vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }


    /**
     * Gets the list of compliance.
     *
     * @return the list of compliance
     */
    public List<Vulnerability> getCompliance() {
        return compliance;
    }


    /**
     * Sets the list of compliance.
     *
     * @param compliance the list of compliance
     */
    public void setCompliance( List<Vulnerability> compliance ) {
        this.compliance = compliance;
    }


    /**
     * Gets the list of history objects.
     *
     * @return the list of history objects
     */
    public List<History> getHistory() {
        return history;
    }


    /**
     * Sets the list of history objects.
     *
     * @param history the list of history objects
     */
    public void setHistory( List<History> history ) {
        this.history = history;
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
