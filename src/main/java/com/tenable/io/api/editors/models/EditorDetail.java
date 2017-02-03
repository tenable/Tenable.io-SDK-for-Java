package com.tenable.io.api.editors.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class EditorDetail {
    private String uuid;
    private int userPermissions;
    private String owner;
    private String title;
    private String name;
    private boolean isAgent;
    private List<Filter> filterAttributes;
    private EditorSettings settings;
    private Credentials credentials;
    private Compliance compliance;
    private EditorPlugins plugins;


    /**
     * Gets the editor uuid.
     *
     * @return the editor uuid
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * Sets the editor uuid.
     *
     * @param uuid the editor uuid
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }


    /**
     * Gets user permissions.
     *
     * @return the user permissions
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * Sets user permissions.
     *
     * @param userPermissions the user permissions
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }


    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }


    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle( String title ) {
        this.title = title;
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
     * Is agent boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "is_agent" )
    public boolean isAgent() {
        return isAgent;
    }


    /**
     * Sets if it's agent.
     *
     * @param agent the agent boolean
     */
    @JsonProperty( "is_agent" )
    public void setAgent( boolean agent ) {
        isAgent = agent;
    }


    /**
     * Gets filter attributes.
     *
     * @return the filter attributes
     */
    @JsonProperty( "filter_attributes" )
    public List<Filter> getFilterAttributes() {
        return filterAttributes;
    }


    /**
     * Sets filter attributes.
     *
     * @param filterAttributes the filter attributes
     */
    @JsonProperty( "filter_attributes" )
    public void setFilterAttributes( List<Filter> filterAttributes ) {
        this.filterAttributes = filterAttributes;
    }


    /**
     * Gets settings.
     *
     * @return the settings
     */
    public EditorSettings getSettings() {
        return settings;
    }


    /**
     * Sets settings.
     *
     * @param settings the settings
     */
    public void setSettings( EditorSettings settings ) {
        this.settings = settings;
    }


    /**
     * Gets credentials.
     *
     * @return the credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }


    /**
     * Sets credentials.
     *
     * @param credentials the credentials
     */
    public void setCredentials( Credentials credentials ) {
        this.credentials = credentials;
    }


    /**
     * Gets compliance.
     *
     * @return the compliance
     */
    public Compliance getCompliance() {
        return compliance;
    }


    /**
     * Sets compliance.
     *
     * @param compliance the compliance
     */
    public void setCompliance( Compliance compliance ) {
        this.compliance = compliance;
    }


    /**
     * Gets plugins.
     *
     * @return the plugins
     */
    public EditorPlugins getPlugins() {
        return plugins;
    }


    /**
     * Sets plugins.
     *
     * @param plugins the plugins
     */
    public void setPlugins( EditorPlugins plugins ) {
        this.plugins = plugins;
    }
}
