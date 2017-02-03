package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginInformation {
    private String plugninVersion;
    private int pluginId;
    private String pluginType;
    private String pluginFamily;
    private String pluginPublicationDate;
    private String pluginModificationDate;


    /**
     * Gets plugnin version.
     *
     * @return the plugnin version
     */
    @JsonProperty( "plugin_version" )
    public String getPlugninVersion() {
        return plugninVersion;
    }


    /**
     * Sets plugnin version.
     *
     * @param plugninVersion the plugnin version
     */
    @JsonProperty( "plugin_version" )
    public void setPlugninVersion( String plugninVersion ) {
        this.plugninVersion = plugninVersion;
    }


    /**
     * Gets plugin id.
     *
     * @return the plugin id
     */
    @JsonProperty( "plugin_id" )
    public int getPluginId() {
        return pluginId;
    }


    /**
     * Sets plugin id.
     *
     * @param pluginId the plugin id
     */
    @JsonProperty( "plugin_id" )
    public void setPluginId( int pluginId ) {
        this.pluginId = pluginId;
    }


    /**
     * Gets plugin type.
     *
     * @return the plugin type
     */
    @JsonProperty( "plugin_type" )
    public String getPluginType() {
        return pluginType;
    }


    /**
     * Sets plugin type.
     *
     * @param pluginType the plugin type
     */
    @JsonProperty( "plugin_type" )
    public void setPluginType( String pluginType ) {
        this.pluginType = pluginType;
    }


    /**
     * Gets plugin family.
     *
     * @return the plugin family
     */
    @JsonProperty( "plugin_family" )
    public String getPluginFamily() {
        return pluginFamily;
    }


    /**
     * Sets plugin family.
     *
     * @param pluginFamily the plugin family
     */
    @JsonProperty( "plugin_family" )
    public void setPluginFamily( String pluginFamily ) {
        this.pluginFamily = pluginFamily;
    }


    /**
     * Gets plugin publication date.
     *
     * @return the plugin publication date
     */
    @JsonProperty( "plugin_publication_date" )
    public String getPluginPublicationDate() {
        return pluginPublicationDate;
    }


    /**
     * Sets plugin publication date.
     *
     * @param pluginPublicationDate the plugin publication date
     */
    @JsonProperty( "plugin_publication_date" )
    public void setPluginPublicationDate( String pluginPublicationDate ) {
        this.pluginPublicationDate = pluginPublicationDate;
    }


    /**
     * Gets plugin modification date.
     *
     * @return the plugin modification date
     */
    @JsonProperty( "plugin_modification_date" )
    public String getPluginModificationDate() {
        return pluginModificationDate;
    }


    /**
     * Sets plugin modification date.
     *
     * @param pluginModificationDate the plugin modification date
     */
    @JsonProperty( "plugin_modification_date" )
    public void setPluginModificationDate( String pluginModificationDate ) {
        this.pluginModificationDate = pluginModificationDate;
    }
}
