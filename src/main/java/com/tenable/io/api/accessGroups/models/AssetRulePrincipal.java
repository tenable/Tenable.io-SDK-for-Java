package com.tenable.io.api.accessGroups.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AssetRulePrincipal {
    private AccessGroupPrincipalType type;
    private String id;
    private String name;
    private List<AccessGroupPrincipalPermission> permissions;


    /**
     * Gets the type of principal (user or group).
     *
     * @return the type of principal.
     */
    public String getType() {
        return type.getValue();
    }

    /**
     * Sets the type of principal (user or group).
     *
     * @param type the type of principal.
     */
    public void setType( Object type ) {
        if (type instanceof AccessGroupPrincipalType) {
            this.type = (AccessGroupPrincipalType) type;
        } else {
            this.type = AccessGroupPrincipalType.valueOf( type.toString().toUpperCase() );
        }
    }


    /**
     * Gets the uuid of user or user group.
     *
     * @return the uuid of user or user group.
     */
    @JsonProperty( "principal_id" )
    public String getId() {
        return id;
    }

    /**
     * Sets the uuid of user or user group.
     *
     * @param id the uuid of user or user group.
     */
    @JsonProperty( "principal_id" )
    public void setId( String id ) {
        this.id = id;
    }


    /**
     * Gets the name of user or user group.
     *
     * @return the name of user or user group.
     */
    @JsonProperty( "principal_name" )
    public String getName() {
        return name;
    }


    /**
     * Sets the name of user or user group.
     *
     * @param name the name of user or user group.
     */
    @JsonProperty( "principal_name" )
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the permissions for the access-group.
     *
     * @return the permissions for the access-group.
     */
    @JsonProperty( "permissions" )
    public List<AccessGroupPrincipalPermission> getPermissions() {
        return permissions;
    }


    /**
     * Sets the permissions for the access-group.
     *
     * @param permissions the permissions for the access-group.
     */
    @JsonProperty( "permissions" )
    public void setPermissions( List<AccessGroupPrincipalPermission> permissions ) {
        this.permissions = permissions;
    }
}
