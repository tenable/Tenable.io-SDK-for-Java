package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginOutput {
    private String pluginOutput;
    private String hosts;
    private int severity;
    private JsonNode ports;


    /**
     * Gets the text of the plugin output.
     *
     * @return the text of the plugin output.
     */
    @JsonProperty( "plugin_output" )
    public String getPluginOutput() {
        return pluginOutput;
    }


    /**
     * Sets the text of the plugin output.
     *
     * @param pluginOutput the text of the plugin output.
     */
    @JsonProperty( "plugin_output" )
    public void setPluginOutput( String pluginOutput ) {
        this.pluginOutput = pluginOutput;
    }


    /**
     * Gets other hosts with the same output.
     *
     * @return other hosts with the same output.
     */
    public String getHosts() {
        return hosts;
    }


    /**
     * Sets other hosts with the same output.
     *
     * @param hosts other hosts with the same output.
     */
    public void setHosts( String hosts ) {
        this.hosts = hosts;
    }


    /**
     * Gets the severity the output.
     *
     * @return the severity the output.
     */
    public int getSeverity() {
        return severity;
    }


    /**
     * Sets the severity the output.
     *
     * @param severity the severity the output.
     */
    public void setSeverity( int severity ) {
        this.severity = severity;
    }


    /**
     * Gets an object containing ports and hostnames
     *
     * @return the ports
     */
    public JsonNode getPorts() {
        return ports;
    }


    /**
     * Sets object containing ports and hostnames
     *
     * @param ports the ports
     */
    public void setPorts( JsonNode ports ) {
        this.ports = ports;
    }
}

