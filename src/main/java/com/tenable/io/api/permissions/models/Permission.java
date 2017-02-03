package com.tenable.io.api.permissions.models;


import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class Permission {
    private int owner;
    private String type;
    private int permissions;
    private int id;
    private String name;


    /**
     * Gets the unique id of the owner of the object.
     *
     * @return the unique id of the owner of the object.
     */
    public int getOwner() {
        return owner;
    }


    /**
     * Sets the unique id of the owner of the object.
     *
     * @param owner the unique id of the owner of the object.
     */
    public void setOwner( int owner ) {
        this.owner = owner;
    }


    /**
     * Gets the type of permission (default, user, group).
     *
     * @return the type of permission (default, user, group).
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of permission (default, user, group).
     *
     * @param type the type of permission (default, user, group).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets the permission value (0, 16, 32, 64) to grant access.
     *
     * @return the permission value (0, 16, 32, 64) to grant access.
     */
    public int getPermissions() {
        return permissions;
    }


    /**
     * Sets the permission value (0, 16, 32, 64) to grant access.
     *
     * @param permissions the permission value (0, 16, 32, 64) to grant access.
     */
    public void setPermissions( int permissions ) {
        this.permissions = permissions;
    }


    /**
     * Gets the unique id of the user if type is user.
     *
     * @return the unique id of the user if type is user.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the user if type is user.
     *
     * @param id the unique id of the user if type is user.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the name of the user or group.
     *
     * @return the name of the user or group.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the user or group.
     *
     * @param name the name of the user or group.
     */
    public void setName( String name ) {
        this.name = name;
    }
}
