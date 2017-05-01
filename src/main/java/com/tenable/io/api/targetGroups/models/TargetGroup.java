package com.tenable.io.api.targetGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TargetGroup {
    private int id;
    private boolean defaultGroup;
    private String name;
    private String members;
    private String type;
    private String owner;
    private int ownerId;
    private int lastModificationDate;
    private int creationDate;
    private int shared;
    private int userPermissions;
    private List<Permission> acls;


    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets list of permissions
     *
     * @return the list of permissions
     */
    public List<Permission> getAcls() {
        return acls;
    }


    /**
     * Sets list of permissions
     *
     * @param acls the list of permissions
     */
    public void setAcls( List<Permission> acls ) {
        this.acls = acls;
    }


    /**
     * The unique id of the TargetGroup.
     *
     * @return The unique id of the TargetGroup.
     */
    public int getId() {
        return id;
    }


    /**
     * The unique id of the TargetGroup.
     *
     * @param id The unique id of the TargetGroup.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * If true, this TargetGroup is the default.
     *
     * @return If true, this TargetGroup is the default.
     */
    @JsonProperty( "default_group" )
    public boolean isDefaultGroup() {
        return defaultGroup;
    }


    /**
     * If true, this TargetGroup is the default.
     *
     * @param defaultGroup If true, this TargetGroup is the default.
     */
    @JsonProperty( "default_group" )
    public void setDefaultGroup( boolean defaultGroup ) {
        this.defaultGroup = defaultGroup;
    }


    /**
     * The name of the TargetGroup.
     *
     * @return The name of the TargetGroup.
     */
    public String getName() {
        return name;
    }


    /**
     * The name of the TargetGroup.
     *
     * @param name The name of the TargetGroup.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * The members of the TargetGroup.
     *
     * @return The members of the TargetGroup.
     */
    public String getMembers() {
        return members;
    }


    /**
     * The members of the TargetGroup.
     *
     * @param members The members of the TargetGroup.
     */
    public void setMembers( String members ) {
        this.members = members;
    }


    /**
     * The TargetGroup type (user or system). Only administrators can create TargetGroup using the 'system' type.
     *
     * @return The TargetGroup type (user or system). Only administrators can create TargetGroup using the 'system' type.
     */
    public String getType() {
        return type;
    }


    /**
     * The TargetGroup type (user or system). Only administrators can create TargetGroup using the 'system' type.
     *
     * @param type The TargetGroup type (user or system). Only administrators can create TargetGroup using the 'system' type.
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * The name of the owner of the TargetGroup. A user of 'nessus_ms_agent' indicates it is a system TargetGroup.
     *
     * @return The name of the owner of the TargetGroup. A user of 'nessus_ms_agent' indicates it is a system TargetGroup.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * The name of the owner of the TargetGroup. A user of 'nessus_ms_agent' indicates it is a system TargetGroup.
     *
     * @param owner The name of the owner of the TargetGroup. A user of 'nessus_ms_agent' indicates it is a system TargetGroup.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * The unique id of the owner of the TargetGroup.
     *
     * @return The unique id of the owner of the TargetGroup.
     */
    @JsonProperty( "owner_id" )
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * The unique id of the owner of the TargetGroup.
     *
     * @param ownerId The unique id of the owner of the TargetGroup.
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( int ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * The last modification date for the TargetGroup in unixtime.
     *
     * @return The last modification date for the TargetGroup in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * The last modification date for the TargetGroup in unixtime.
     *
     * @param lastModificationDate The last modification date for the TargetGroup in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * The shared status of the TargetGroup.
     *
     * @return The shared status of the TargetGroup.
     */
    public int getShared() {
        return shared;
    }


    /**
     * The shared status of the TargetGroup.
     *
     * @param shared The shared status of the TargetGroup.
     */
    public void setShared( int shared ) {
        this.shared = shared;
    }


    /**
     * The current user permissions for the TargetGroup.
     *
     * @return The current user permissions for the TargetGroup.
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * The current user permissions for the TargetGroup.
     *
     * @param userPermissions The current user permissions for the TargetGroup.
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }
}
