package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginDescription {
    private int severity;
    private String pluginName;
    private PluginAttributes pluginAttributes;
    private String pluginFamily;
    private String pluginId;
    private String className;


    /**
     * Gets severity.
     *
     * @return the severity
     */
    public int getSeverity() {
        return severity;
    }


    /**
     * Sets severity.
     *
     * @param severity the severity
     */
    public void setSeverity( int severity ) {
        this.severity = severity;
    }


    /**
     * Gets plugin name.
     *
     * @return the plugin name
     */
    @JsonProperty( "pluginname" )
    public String getPluginName() {
        return pluginName;
    }


    /**
     * Sets plugin name.
     *
     * @param pluginName the plugin name
     */
    @JsonProperty( "pluginname" )
    public void setPluginName( String pluginName ) {
        this.pluginName = pluginName;
    }


    /**
     * Gets plugin attributes.
     *
     * @return the plugin attributes
     */
    @JsonProperty( "pluginattributes" )
    public PluginAttributes getPluginAttributes() {
        return pluginAttributes;
    }


    /**
     * Sets plugin attributes.
     *
     * @param pluginAttributes the plugin attributes
     */
    @JsonProperty( "pluginattributes" )
    public void setPluginAttributes( PluginAttributes pluginAttributes ) {
        this.pluginAttributes = pluginAttributes;
    }


    /**
     * Gets plugin family.
     *
     * @return the plugin family
     */
    @JsonProperty( "pluginfamily" )
    public String getPluginFamily() {
        return pluginFamily;
    }


    /**
     * Sets plugin family.
     *
     * @param pluginFamily the plugin family
     */
    @JsonProperty( "pluginfamily" )
    public void setPluginFamily( String pluginFamily ) {
        this.pluginFamily = pluginFamily;
    }


    /**
     * Gets plugin id.
     *
     * @return the plugin id
     */
    @JsonProperty( "pluginid" )
    public String getPluginId() {
        return pluginId;
    }


    /**
     * Sets plugin id.
     *
     * @param pluginId the plugin id
     */
    @JsonProperty( "pluginid" )
    public void setPluginId( String pluginId ) {
        this.pluginId = pluginId;
    }


    /**
     * Gets class name.
     *
     * @return the class name
     */
    @JsonProperty( "classname" )
    public String getClassName() {
        return className;
    }


    /**
     * Sets class name.
     *
     * @param className the class name
     */
    @JsonProperty( "classname" )
    public void setClassName( String className ) {
        this.className = className;
    }
}
