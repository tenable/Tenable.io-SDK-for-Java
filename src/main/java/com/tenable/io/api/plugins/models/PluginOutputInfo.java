package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginOutputInfo {
    private PluginDescription pluginDescription;


    /**
     * Gets plugin description.
     *
     * @return the plugin description
     */
    @JsonProperty( "plugindescription" )
    public PluginDescription getPluginDescription() {
        return pluginDescription;
    }


    /**
     * Sets plugin description.
     *
     * @param pluginDescription the plugin description
     */
    @JsonProperty( "plugindescription" )
    public void setPluginDescription( PluginDescription pluginDescription ) {
        this.pluginDescription = pluginDescription;
    }
}
