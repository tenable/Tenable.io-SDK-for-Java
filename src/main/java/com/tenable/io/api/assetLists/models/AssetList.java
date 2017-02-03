package com.tenable.io.api.assetLists.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.permissions.models.Permission;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetList {
    private int id;
    private boolean defaultList;
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
     * The unique id of the list.
     *
     * @return The unique id of the list.
     */
    public int getId() {
        return id;
    }


    /**
     * The unique id of the list.
     *
     * @param id The unique id of the list.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * If true, this list is the default.
     *
     * @return If true, this list is the default.
     */
    @JsonProperty( "default_list" )
    public boolean isDefaultList() {
        return defaultList;
    }


    /**
     * If true, this list is the default.
     *
     * @param defaultList If true, this list is the default.
     */
    @JsonProperty( "default_list" )
    public void setDefaultList( boolean defaultList ) {
        this.defaultList = defaultList;
    }


    /**
     * The name of the list.
     *
     * @return The name of the list.
     */
    public String getName() {
        return name;
    }


    /**
     * The name of the list.
     *
     * @param name The name of the list.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * The members of the list.
     *
     * @return The members of the list.
     */
    public String getMembers() {
        return members;
    }


    /**
     * The members of the list.
     *
     * @param members The members of the list.
     */
    public void setMembers( String members ) {
        this.members = members;
    }


    /**
     * The list type (user or system). Only administrators can create lists using the 'system' type.
     *
     * @return The list type (user or system). Only administrators can create lists using the 'system' type.
     */
    public String getType() {
        return type;
    }


    /**
     * The list type (user or system). Only administrators can create lists using the 'system' type.
     *
     * @param type The list type (user or system). Only administrators can create lists using the 'system' type.
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * The name of the owner of the list. A user of 'nessus_ms_agent' indicates it is a system asset list.
     *
     * @return The name of the owner of the list. A user of 'nessus_ms_agent' indicates it is a system asset list.
     */
    public String getOwner() {
        return owner;
    }


    /**
     * The name of the owner of the list. A user of 'nessus_ms_agent' indicates it is a system asset list.
     *
     * @param owner The name of the owner of the list. A user of 'nessus_ms_agent' indicates it is a system asset list.
     */
    public void setOwner( String owner ) {
        this.owner = owner;
    }


    /**
     * The unique id of the owner of the list.
     *
     * @return The unique id of the owner of the list.
     */
    @JsonProperty( "owner_id" )
    public int getOwnerId() {
        return ownerId;
    }


    /**
     * The unique id of the owner of the list.
     *
     * @param ownerId The unique id of the owner of the list.
     */
    @JsonProperty( "owner_id" )
    public void setOwnerId( int ownerId ) {
        this.ownerId = ownerId;
    }


    /**
     * The last modification date for the exclusion in unixtime.
     *
     * @return The last modification date for the exclusion in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * The last modification date for the exclusion in unixtime.
     *
     * @param lastModificationDate The last modification date for the exclusion in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * The shared status of the list.
     *
     * @return The shared status of the list.
     */
    public int getShared() {
        return shared;
    }


    /**
     * The shared status of the list.
     *
     * @param shared The shared status of the list.
     */
    public void setShared( int shared ) {
        this.shared = shared;
    }


    /**
     * The current user permissions for the list.
     *
     * @return The current user permissions for the list.
     */
    @JsonProperty( "user_permissions" )
    public int getUserPermissions() {
        return userPermissions;
    }


    /**
     * The current user permissions for the list.
     *
     * @param userPermissions The current user permissions for the list.
     */
    @JsonProperty( "user_permissions" )
    public void setUserPermissions( int userPermissions ) {
        this.userPermissions = userPermissions;
    }
}
