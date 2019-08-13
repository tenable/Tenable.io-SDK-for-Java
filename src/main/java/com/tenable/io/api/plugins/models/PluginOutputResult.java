package com.tenable.io.api.plugins.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginOutputResult {
    private PluginOutputInfo info;
    private List<PluginOutput> output;


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
     * @return the plugin output lis
     */
    public List<PluginOutput> getOutput() {
        return output;
    }


    /**
     * Sets the plugin output list.
     *
     * @param output the plugin output list
     */
    public void setOutput(List<PluginOutput> output) {
        this.output = output;
    }
}
