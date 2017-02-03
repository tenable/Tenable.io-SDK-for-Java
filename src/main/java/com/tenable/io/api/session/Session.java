package com.tenable.io.api.session;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Session {
    private String id;
    private String username;
    private String email;
    private String name;
    private String type;
    private int permissions;
    private int lastLogin;
    private int containerId;
    private String[] groups;


    /**
     * Gets the unique id of the user.
     *
     * @return the unique id of the user
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the unique id of the user.
     *
     * @param id the unique id of the user
     */
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * Gets the username for the user.
     *
     * @return the username for the user
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username for the user.
     *
     * @param username the username for the user
     */
    public void setUsername( String username ) {
        this.username = username;
    }


    /**
     * Gets the email address for the user.
     *
     * @return the email address for the user
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email address for the user.
     *
     * @param email the email address for the user
     */
    public void setEmail( String email ) {
        this.email = email;
    }


    /**
     * Gets the full name for the user.
     *
     * @return the full name for the user
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the full name for the user.
     *
     * @param name the full name for the user
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the type of user.
     *
     * @return the type of user
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of user.
     *
     * @param type the type of user
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the user role.
     *
     * @return the user role.
     */
    public int getPermissions() {
        return permissions;
    }


    /**
     * Sets the user role..
     *
     * @param permissions the user role.
     */
    public void setPermissions( int permissions ) {
        this.permissions = permissions;
    }


    /**
     * Gets the last login for the user in unixtime.
     *
     * @return the last login for the user in unixtime
     */
    @JsonProperty( "lastlogin" )
    public int getLastLogin() {
        return lastLogin;
    }


    /**
     * Sets the last login for the user in unixtime.
     *
     * @param lastLogin the last login for the user in unixtime
     */
    @JsonProperty( "lastlogin" )
    public void setLastLogin( int lastLogin ) {
        this.lastLogin = lastLogin;
    }


    /**
     * Gets the container id for the user.
     *
     * @return the container id for the user
     */
    @JsonProperty( "container_id" )
    public int getContainerId() {
        return containerId;
    }


    /**
     * Sets the container id for the user.
     *
     * @param containerId the container id for the user
     */
    @JsonProperty( "container_id" )
    public void setContainerId( int containerId ) {
        this.containerId = containerId;
    }


    /**
     * Get the list of groups that the user belongs to.
     *
     * @return the list of groups that the user belongs to
     */
    public String[] getGroups() {
        return groups;
    }


    /**
     * Sets the list of groups that the user belongs to.
     *
     * @param groups the list of groups that the user belongs to
     */
    public void setGroups( String[] groups ) {
        this.groups = groups;
    }
}
