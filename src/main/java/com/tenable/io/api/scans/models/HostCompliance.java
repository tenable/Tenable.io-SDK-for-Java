package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class HostCompliance {
    private int hostId;
    private String hostname;
    private int pluginId;
    private String pluginName;
    private String pluginFamily;
    private int count;
    private int severityIndex;
    private int severity;


    /**
     * Gets the unique id of the host.
     *
     * @return the unique id of the host.
     */
    @JsonProperty( "host_id" )
    public int getHostId() {
        return hostId;
    }


    /**
     * Sets the unique id of the host.
     *
     * @param hostId the unique id of the host.
     */
    @JsonProperty( "host_id" )
    public void setHostId( int hostId ) {
        this.hostId = hostId;
    }


    /**
     * Gets the name of the host.
     *
     * @return the name of the host.
     */
    public String getHostname() {
        return hostname;
    }


    /**
     * Sets the name of the host.
     *
     * @param hostname the name of the host.
     */
    public void setHostname( String hostname ) {
        this.hostname = hostname;
    }


    /**
     * Gets the unique id of the vulnerability plugin.
     *
     * @return the unique id of the vulnerability plugin.
     */
    @JsonProperty( "plugin_id" )
    public int getPluginId() {
        return pluginId;
    }


    /**
     * Sets the unique id of the vulnerability plugin.
     *
     * @param pluginId the unique id of the vulnerability plugin.
     */
    @JsonProperty( "plugin_id" )
    public void setPluginId( int pluginId ) {
        this.pluginId = pluginId;
    }


    /**
     * Gets the name of the vulnerability plugin.
     *
     * @return the name of the vulnerability plugin.
     */
    @JsonProperty( "plugin_name" )
    public String getPluginName() {
        return pluginName;
    }


    /**
     * Sets the name of the vulnerability plugin.
     *
     * @param pluginName the name of the vulnerability plugin.
     */
    @JsonProperty( "plugin_name" )
    public void setPluginName( String pluginName ) {
        this.pluginName = pluginName;
    }


    /**
     * Gets the parent family of the vulnerability plugin.
     *
     * @return the parent family of the vulnerability plugin.
     */
    @JsonProperty( "plugin_family" )
    public String getPluginFamily() {
        return pluginFamily;
    }


    /**
     * Sets the parent family of the vulnerability plugin.
     *
     * @param pluginFamily the parent family of the vulnerability plugin.
     */
    @JsonProperty( "plugin_family" )
    public void setPluginFamily( String pluginFamily ) {
        this.pluginFamily = pluginFamily;
    }


    /**
     * Gets the number of vulnerabilities found.
     *
     * @return the number of vulnerabilities found.
     */
    public int getCount() {
        return count;
    }


    /**
     * Sets the number of vulnerabilities found.
     *
     * @param count the number of vulnerabilities found.
     */
    public void setCount( int count ) {
        this.count = count;
    }


    /**
     * Gets the severity index order of the plugin.
     *
     * @return the severity index order of the plugin.
     */
    @JsonProperty( "severity_index" )
    public int getSeverityIndex() {
        return severityIndex;
    }


    /**
     * Sets the severity index order of the plugin.
     *
     * @param severityIndex the severity index order of the plugin.
     */
    @JsonProperty( "severity_index" )
    public void setSeverityIndex( int severityIndex ) {
        this.severityIndex = severityIndex;
    }


    /**
     * Gets the severity of plugin.
     *
     * @return the severity of plugin.
     */
    public int getSeverity() {
        return severity;
    }


    /**
     * Sets the severity of plugin.
     *
     * @param severity the severity of plugin.
     */
    public void setSeverity( int severity ) {
        this.severity = severity;
    }
}
