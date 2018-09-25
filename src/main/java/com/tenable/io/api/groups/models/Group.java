package com.tenable.io.api.groups.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Group {
    private int id;
    private String name;
    private int permissions;
    private int userCount;
    private UUID uuid;


    /**
     * Gets the unique id of the group.
     *
     * @return the unique id of the group.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the group.
     *
     * @param id the unique id of the group.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the name of the group.
     *
     * @return the name of the group.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the group.
     *
     * @param name the name of the group.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the permissions for the group.
     *
     * @return the permissions for the group.
     */
    public int getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions for the group.
     *
     * @param permissions the permissions for the group.
     */
    public void setPermissions( int permissions ) {
        this.permissions = permissions;
    }

    /**
     * Gets the uuid for the group.
     *
     * @return the uuid for the group.
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Sets the unique uuid of the group.
     *
     * @param uuid the unique uuid of the group.
     */
    public void setUuid( UUID uuid ) {
        this.uuid = uuid;
    }

    /**
     * Gets the number of users in the group.
     *
     * @return the number of users in the group.
     */
    @JsonProperty( "user_count" )
    public int getUserCount() {
        return userCount;
    }


    /**
     * Sets the number of users in the group.
     *
     * @param userCount the number of users in the group.
     */
    @JsonProperty( "user_count" )
    public void setUserCount( int userCount ) {
        this.userCount = userCount;
    }
}
