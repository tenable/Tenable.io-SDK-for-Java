package com.tenable.io.api.agentGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentGroup {
    private int id;
    private String name;
    private String ownerId;
    private String owner;
    private int shared;
    private int userPermissions;
    private int creationDate;
    private int lastModificationDate;
    private int agentsCount;
    private String ownerName;
    private String timestamp;


    /**
     * Gets agents count.
     *
     * @return the agents count
     */
    @JsonProperty( "agents_count" )
    public int getAgentsCount() {
        return agentsCount;
    }


    /**
     * Sets agents count.
     *
     * @param agentsCount the agents count
     */
    @JsonProperty( "agents_count" )
    public void setAgentsCount( int agentsCount ) {
        this.agentsCount = agentsCount;
    }


    /**
     * Gets owner name.
     *
     * @return the owner name
     */
    @JsonProperty( "owner_name" )
    public String getOwnerName() {
        return ownerName;
    }


    /**
     * Sets owner name.
     *
     * @param ownerName the owner name
     */
    @JsonProperty( "owner_name" )
    public void setOwnerName( String ownerName ) {
        this.ownerName = ownerName;
    }


    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }


    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp( String timestamp ) {
        this.timestamp = timestamp;
    }


    /**
     * The unique id of the agent group.
     *
     * @return The unique id of the agent group.
     */
    public int getId() {
        return id;
    }


    /**
     * The unique id of the agent group.
     *
     * @param id The unique id of the agent group.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * The name of the agent group.
     *
     * @return The name of the agent group.
     */
    public String getName() {
        return name;
    }


    /**
     * The name of the agent group.
     *
     * @param name The name of the agent group.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * The unique id of the owner of the agent group.
     *
     * @return The unique id of the owner of the agent group.
     */
    @JsonProperty( "owner_id" )
    public String getOwnerId() {
        return ownerId;
    }


    /**
     * The unique id of the owner of the agent group.
     *
     * @param ownerId The unique id of the owner of the agent group.
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( String ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * The username for the owner of the agent group.
     *
     * @return The username for the owner of the agent group.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * The username for the owner of the agent group.
     *
     * @param owner The username for the owner of the agent group.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * The shared status of the agent group.
     *
     * @return The shared status of the agent group.
     */
    public int getShared() {
        return shared;
    }


    /**
     * The shared status of the agent group.
     *
     * @param shared The shared status of the agent group.
     */
    public void setShared( int shared ) {
        this.shared = shared;
    }


    /**
     * The sharing permissions for the agent group.
     *
     * @return The sharing permissions for the agent group.
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * The sharing permissions for the agent group.
     *
     * @param userPermissions The sharing permissions for the agent group.
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }


    /**
     * The creation date of the agent group in unixtime.
     *
     * @return The creation date of the agent group in unixtime.
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * The creation date of the agent group in unixtime.
     *
     * @param creationDate The creation date of the agent group in unixtime.
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * The last modification date for the agent group in unixtime.
     *
     * @return The last modification date for the agent group in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * The last modification date for the agent group in unixtime.
     *
     * @param lastModificationDate The last modification date for the agent group in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }
}
