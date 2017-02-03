package com.tenable.io.api.plugins.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginFamilyDetail {
    private int id;
    private String name;
    private List<PluginInfo> plugins;


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets plugins.
     *
     * @return the plugins
     */
    public List<PluginInfo> getPlugins() {
        return plugins;
    }


    /**
     * Sets plugins.
     *
     * @param plugins the plugins
     */
    public void setPlugins( List<PluginInfo> plugins ) {
        this.plugins = plugins;
    }
}
