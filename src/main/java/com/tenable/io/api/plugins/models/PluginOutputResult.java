package com.tenable.io.api.plugins.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginOutputResult {
    private PluginOutputInfo info;
    private List<PluginOutput> outputs;


    /**
     * Gets plugin info.
     *
     * @return the info
     */
    public PluginOutputInfo getInfo() {
        return info;
    }


    /**
     * Sets plugin info.
     *
     * @param info the info
     */
    public void setInfo( PluginOutputInfo info ) {
        this.info = info;
    }


    /**
     * Gets list of plugin output.
     *
     * @return the plugin outputs list
     */
    public List<PluginOutput> getOutputs() {
        return outputs;
    }


    /**
     * Sets the plugin output list.
     *
     * @param outputs the plugin output list
     */
    public void setOutputs( List<PluginOutput> outputs ) {
        this.outputs = outputs;
    }
}
