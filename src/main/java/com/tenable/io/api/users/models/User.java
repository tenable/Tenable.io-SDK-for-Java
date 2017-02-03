package com.tenable.io.api.users.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class User {
    private int id;
    private String username;
    private String name;
    private String email;
    private UserRole permissions;
    private int lastLogin;
    private String type;
    private int loginFailCount;
    private int lastLoginAttempt;
    private String uuidId;
    private int aggregate;
    private int containerId;
    private String containerName;
    private String containerUuid;
    private boolean enabled;
    private boolean lockout;
    private int loginFailTotal;
    private boolean whatsNew;


    /**
     * Gets aggregate.
     *
     * @return the aggregate
     */
    public int getAggregate() {
        return aggregate;
    }


    /**
     * Sets aggregate.
     *
     * @param aggregate the aggregate
     */
    public void setAggregate( int aggregate ) {
        this.aggregate = aggregate;
    }


    /**
     * Gets container id.
     *
     * @return the container id
     */
    @JsonProperty( "container_id" )
    public int getContainerId() {
        return containerId;
    }


    /**
     * Sets container id.
     *
     * @param containerId the container id
     */
    @JsonProperty( "container_id" )
    public void setContainerId( int containerId ) {
        this.containerId = containerId;
    }


    /**
     * Gets container name.
     *
     * @return the container name
     */
    @JsonProperty( "container_name" )
    public String getContainerName() {
        return containerName;
    }


    /**
     * Sets container name.
     *
     * @param containerName the container name
     */
    @JsonProperty( "container_name" )
    public void setContainerName( String containerName ) {
        this.containerName = containerName;
    }


    /**
     * Gets container uuid.
     *
     * @return the container uuid
     */
    @JsonProperty( "container_uuid" )
    public String getContainerUuid() {
        return containerUuid;
    }


    /**
     * Sets container uuid.
     *
     * @param containerUuid the container uuid
     */
    @JsonProperty( "container_uuid" )
    public void setContainerUuid( String containerUuid ) {
        this.containerUuid = containerUuid;
    }


    /**
     * Boolean indicating whether the user's account is enabled.
     *
     * @return boolean indicating whether the user's account is enabled.
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Boolean indicating whether the user's account is enabled.
     *
     * @param enabled boolean indicating whether the user's account is enabled
     */
    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }


    /**
     * Is lockout boolean.
     *
     * @return the boolean
     */
    public boolean isLockout() {
        return lockout;
    }


    /**
     * Sets lockout.
     *
     * @param lockout the lockout
     */
    public void setLockout( boolean lockout ) {
        this.lockout = lockout;
    }


    /**
     * Gets login fail total.
     *
     * @return the login fail total
     */
    @JsonProperty( "login_fail_total" )
    public int getLoginFailTotal() {
        return loginFailTotal;
    }


    /**
     * Sets login fail total.
     *
     * @param loginFailTotal the login fail total
     */
    @JsonProperty( "login_fail_total" )
    public void setLoginFailTotal( int loginFailTotal ) {
        this.loginFailTotal = loginFailTotal;
    }


    /**
     * Is whats new boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "whatsnew" )
    public boolean isWhatsNew() {
        return whatsNew;
    }


    /**
     * Sets whats new.
     *
     * @param whatsNew the whats new
     */
    @JsonProperty( "whatsnew" )
    public void setWhatsNew( boolean whatsNew ) {
        this.whatsNew = whatsNew;
    }


    /**
     * Gets The unique id of the user.
     *
     * @return The unique id of the user
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the user.
     *
     * @param id The unique id of the user
     */
    public void setId( int id ) {
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
     * Gets the real name of the user.
     *
     * @return the real name of the user
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the real name of the user.
     *
     * @param name the real name of the user
     */
    public void setName( String name ) {
        this.name = name;
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
     * Gets the role of the user.
     *
     * @return the role of the user
     */
    public UserRole getPermissions() {
        return permissions;
    }


    /**
     * Sets the role of the user.
     *
     * @param permissions the role of the user
     */
    public void setPermissions( UserRole permissions ) {
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
     * Gets the type of user (local or ldap).
     *
     * @return the type of user (local or ldap)
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of user (local or ldap).
     *
     * @param type the type of user (local or ldap)
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the aggregate number of failed logins for the user.
     *
     * @return the laggregate number of failed logins for the user
     */
    @JsonProperty( "login_fail_count" )
    public int getLoginFailCount() {
        return loginFailCount;
    }


    /**
     * Sets the aggregate number of failed logins for the user.
     *
     * @param loginFailCount the aggregate number of failed logins for the user
     */
    @JsonProperty( "login_fail_count" )
    public void setLoginFailCount( int loginFailCount ) {
        this.loginFailCount = loginFailCount;
    }


    /**
     * Gets the timestamp of the last failed login attempt for the user.
     *
     * @return the timestamp of the last failed login attempt for the user
     */
    @JsonProperty( "last_login_attempt" )
    public int getLastLoginAttempt() {
        return lastLoginAttempt;
    }


    /**
     * Sets the timestamp of the last failed login attempt for the user.
     *
     * @param lastLoginAttempt the timestamp of the last failed login attempt for the user
     */
    @JsonProperty( "last_login_attempt" )
    public void setLastLoginAttempt( int lastLoginAttempt ) {
        this.lastLoginAttempt = lastLoginAttempt;
    }


    /**
     * Gets the user UUID ID (new ID).
     *
     * @return the user UUID ID (new ID)
     */
    @JsonProperty( "uuid_id" )
    public String getUuidId() {
        return uuidId;
    }


    /**
     * Sets user UUID ID (new ID).
     *
     * @param uuidId the user UUID ID (new ID)
     */
    @JsonProperty( "uuid_id" )
    public void setUuidId( String uuidId ) {
        this.uuidId = uuidId;
    }
}
