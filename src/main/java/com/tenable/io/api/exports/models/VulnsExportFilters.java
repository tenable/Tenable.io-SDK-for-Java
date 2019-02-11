package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.models.SeverityLevel;
import com.tenable.io.api.models.VulnerabilityState;

import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class VulnsExportFilters {
    private List<SeverityLevel> severity;
    private List<VulnerabilityState> state;
    private List<String> pluginFamily;
    private long since;
    private String cidrRange;
    private long firstFound;
    private long lastFound;
    private long lastFixed;
    private Map<String, String[]> tags;


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

    /**
     * Sets the start date (in Unix time) for the range of vulnerability data you want to export,
     * based on when a scan first found a vulnerability on an asset.
     *
     * @param firstFound
     */
    public void setFirstFound( long firstFound ) { this.firstFound = firstFound; }

    public long getFirstFound() { return this.firstFound; }

    /**
     * Sets the start date (in Unix time) for the range of vulnerability data you want to export,
     * based on when a scan last found a vulnerability on an asset.
     *
     * @param lastFound
     */
    public void setLastFound( long lastFound ) { this.lastFound = lastFound; }

    public long getLastFound() { return this.lastFound; }

    /**
     * Sets the start date (in Unix time) for the range of vulnerability data you want to export,
     * based on when the vulnerability state was changed to fixed.
     *
     * @param lastFixed
     */
    public void setLastFixed( long lastFixed ) { this.lastFixed = lastFixed; }

    public long getLastFixed() { return this.lastFixed; }

    /**
     * Sets the cidr_range filter for the assets to include in the export.
     *
     * @param cidrRange the cidr range
     */
    public void setCidrRange( String cidrRange ) { this.cidrRange = cidrRange; }

    public String getCidrRange() { return this.cidrRange; }

    /**
     * Setting this filter will return vulnerabilities for all assets that have been assigned the specified tags.
     *
     * @param tags the asset tags
     */
    public void setTags( Map<String, String[]> tags ) { this.tags = tags; }


    /**
     * Gets the asset tags filter.
     *
     * @return the asset tags
     */
    public Map<String, String[]> getTags() { return tags; }
}
