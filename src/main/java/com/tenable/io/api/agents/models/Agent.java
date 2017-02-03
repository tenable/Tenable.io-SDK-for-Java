package com.tenable.io.api.agents.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Agent {
    private String distro;
    private int id;
    private String ip;
    private String lastScanned;
    private String name;
    private String platform;
    private String token;
    private String uuid;


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
    public String getLastScanned() {
        return lastScanned;
    }


    /**
     * The last scanned date for the agent in unixtime.
     *
     * @param lastScanned The last scanned date for the agent in unixtime.
     */
    @JsonProperty( "last_scanned" )
    public void setLastScanned( String lastScanned ) {
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
     * The token of the agent.
     *
     * @return The token of the agent.
     */
    public String getToken() {
        return token;
    }


    /**
     * The token of the agent.
     *
     * @param token The token of the agent.
     */
    public void setToken( String token ) {
        this.token = token;
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
}
