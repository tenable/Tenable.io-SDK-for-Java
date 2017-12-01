package com.tenable.io.api.agents.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.agentGroups.models.AgentGroup;

import java.util.List;
import java.util.UUID;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Agent {
    private String distro;
    private int id;
    private String ip;
    private Integer lastScanned;
    private String name;
    private String platform;
    private String uuid;
    private Integer linkedOn;
    private Integer lastConnect;
    private String pluginFeedId;
    private String coreBuild;
    private String coreVersion;
    private List<AgentGroup> groups;
    private String status;


    /**
     * The agent software distribution.
     *
     * @return The agent software distribution.
     */
    public String getDistro() {
        return distro;
    }


    /**
     * The agent software distribution.
     *
     * @param distro The agent software distribution.
     */
    public void setDistro( String distro ) {
        this.distro = distro;
    }


    /**
     * The unique id of the agent.
     *
     * @return The unique id of the agent.
     */
    public int getId() {
        return id;
    }


    /**
     * The unique id of the agent.
     *
     * @param id The unique id of the agent.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * The IP address of the agent.
     *
     * @return The IP address of the agent.
     */
    public String getIp() {
        return ip;
    }


    /**
     * The IP address of the agent.
     *
     * @param ip The IP address of the agent.
     */
    public void setIp( String ip ) {
        this.ip = ip;
    }


    /**
     * The last scanned date for the agent in unixtime.
     *
     * @return The last scanned date for the agent in unixtime.
     */
    @JsonProperty( "last_scanned" )
    public Integer getLastScanned() {
        return lastScanned;
    }


    /**
     * The last scanned date for the agent in unixtime.
     *
     * @param lastScanned The last scanned date for the agent in unixtime.
     */
    @JsonProperty( "last_scanned" )
    public void setLastScanned( Integer lastScanned ) {
        this.lastScanned = lastScanned;
    }


    /**
     * The name of the agent.
     *
     * @return The name of the agent.
     */
    public String getName() {
        return name;
    }


    /**
     * The name of the agent.
     *
     * @param name The name of the agent.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * The platform of the agent.
     *
     * @return The platform of the agent.
     */
    public String getPlatform() {
        return platform;
    }


    /**
     * The platform of the agent.
     *
     * @param platform The platform of the agent.
     */
    public void setPlatform( String platform ) {
        this.platform = platform;
    }

    /**
     * The uuid of the agent.
     *
     * @return The uuid of the agent.
     */
    public String getUuid() {
        return uuid;
    }


    /**
     * The uuid of the agent.
     *
     * @param uuid The uuid of the agent.
     */
    public void setUuid( String uuid ) {
        this.uuid = uuid;
    }

    /**
     * Gets linked on.
     *
     * @return the linked on
     */
    @JsonProperty( "linked_on" )
    public Integer getLinkedOn() { return linkedOn; }

    /**
     * Sets linked on.
     *
     * @param linkedOn the linked on
     */
    @JsonProperty( "linked_on" )
    public void setLinkedOn( Integer linkedOn ) { this.linkedOn = linkedOn; }

    /**
     * Gets last connect.
     *
     * @return the last connect
     */
    @JsonProperty( "last_connect" )
    public Integer getLastConnect() { return lastConnect; }

    /**
     * Sets last connect.
     *
     * @param lastConnect the last connect
     */
     @JsonProperty( "last_connect" )
    public void setLastConnect( Integer lastConnect ) { this.lastConnect = lastConnect; }

    /**
     * Gets plugin feed id.
     *
     * @return the plugin feed id
     */
    @JsonProperty( "plugin-feed-id" )
    public String getPluginFeedId() { return pluginFeedId; }

    /**
     * Sets plugin feed id.
     *
     * @param pluginFeedId the public feed id
     */
    @JsonProperty( "plugin-feed-id" )
    public void setPluginFeedId( String pluginFeedId ) { this.pluginFeedId = pluginFeedId; }

    /**
     * Gets core build.
     *
     * @return the core build
     */
    @JsonProperty( "core_build" )
    public String getCoreBuild() { return coreBuild; }

    /**
     * Sets core build.
     *
     * @param coreBuild the core build
     */
    @JsonProperty( "core_build" )
    public void setCoreBuild( String coreBuild ) { this.coreBuild = coreBuild; }

    /**
     * Gets core version.
     *
     * @return the core version
     */
    @JsonProperty( "core_version" )
    public String getCoreVersion() { return coreVersion; }

    /**
     * Sets core version.
     *
     * @param coreVersion the core version
     */
    @JsonProperty( "core_version" )
    public void setCoreVersion( String coreVersion ) { this.coreVersion = coreVersion; }

    /**
     * Gets groups.
     *
     * @return the groups
     */
    public List<AgentGroup> getGroups() { return groups; }

    /**
     * Sets groups.
     *
     * @param groups the groups
     */
    public void setGroups( List<AgentGroup> groups ) { this.groups = groups; }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() { return status; }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus( String status ) { this.status = status; }
}
