package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.models.SeverityLevel;
import com.tenable.io.api.models.VulnerabilityState;

import java.util.List;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class VulnsExportFilters {
    private List<SeverityLevel> severity;
    private List<VulnerabilityState> state;
    private List<String> pluginFamily;
    private long since;


    /**
     * Sets the list of severities to include in the export
     * Defaults to all severity levels
     *
     * @param severity List of vulnerability severities
     */
    public void setSeverity(List<SeverityLevel> severity ) { this.severity = severity; }

    /**
     * Gets the list of severities
     *
     * @return the severities
     */
    public List<SeverityLevel> getSeverity() { return this.severity; }

    /**
     * Sets the list of vulnerability states to include in the export (OPEN, REOPENED, or FIXED)
     * Defaults to 'OPEN' and 'REOPENED'
     *
     * @param list of vulnerability states
     */
    public void setState( List<VulnerabilityState> state ) { this.state = state; }

    /**
     * Gets the list of vulnerability states
     *
     * @return the list of vulnerability states
     */
    public List<VulnerabilityState> getState() { return this.state; }

    /**
     * Sets the list of plugin family of the exported vulnerabilities
     * This filter is case sensitive
     *
     * @param a list of plugin family names
     */
    @JsonProperty( "plugin_family" )
    public void setPluginFamily( List<String> pluginFamily ) { this.pluginFamily = pluginFamily; }

    /**
     * Gets the list of plugin family names
     *
     * @return the list of plugin family names
     */
    @JsonProperty( "plugin_family" )
    public List<String> getPluginFamily() { return this.pluginFamily; }

    /**
     * Sets the start date (in Unix time) for the the range of new or updated vulnerability data to export
     * Defaults to all regardless of date
     *
     * @param since
     */
    public void setSince( long since ) { this.since = since; }

    public long getSince() { return this.since; }
}
