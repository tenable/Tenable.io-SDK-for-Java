package com.tenable.io.api.policies.models;


import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PolicyDetail {
    private String uuid;
    private PolicyAudits audits;
    private PolicyCredentials credentials;
    private Map<String, PolicyPluginFamily> plugins;
    private PolicyScap scap;
    private PolicySettings settings;


    /**
     * Gets uuid.
     *
     * @return the uuid of the policy
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid of the policy.
     *
     * @param uuid the uuid of the policy
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


    /**
     * Gets the policy audits
     *
     * @return the policy audits
     */
    public PolicyAudits getAudits() {
        return audits;
    }


    /**
     * Sets the policy audits.
     *
     * @param audits the policy audits
     */
    public void setAudits( PolicyAudits audits ) {
        this.audits = audits;
    }


    /**
     * Gets the policy credentials.
     *
     * @return the policy credentials
     */
    public PolicyCredentials getCredentials() {
        return credentials;
    }


    /**
     * Sets the policy credentials.
     *
     * @param credentials the policy credentials
     */
    public void setCredentials( PolicyCredentials credentials ) {
        this.credentials = credentials;
    }


    /**
     * Gets the list of plugins.
     *
     * @return the list of plugins
     */
    public Map<String, PolicyPluginFamily> getPlugins() {
        return plugins;
    }


    /**
     * Sets the list of plugins
     *
     * @param plugins the plugins
     */
    public void setPlugins( Map<String, PolicyPluginFamily> plugins ) {
        this.plugins = plugins;
    }


    /**
     * Gets the policy scap.
     *
     * @return the policy scap
     */
    public PolicyScap getScap() {
        return scap;
    }


    /**
     * Sets the policy scap.
     *
     * @param scap the policy scap
     */
    public void setScap( PolicyScap scap ) {
        this.scap = scap;
    }


    /**
     * Gets the policy settings.
     *
     * @return the policy settings
     */
    public PolicySettings getSettings() {
        return settings;
    }


    /**
     * Sets the policy settings.
     *
     * @param settings the policy settings
     */
    public void setSettings( PolicySettings settings ) {
        this.settings = settings;
    }
}
