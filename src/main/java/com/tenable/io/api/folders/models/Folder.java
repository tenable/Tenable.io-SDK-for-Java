package com.tenable.io.api.folders.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Folder {
    private int id;
    private String name;
    private String type;
    private int defaultTag;
    private int custom;
    private int unreadCount;


    /**
     * Gets the unique id of the folder.
     *
     * @return the unique id of the folder.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the folder.
     *
     * @param id the unique id of the folder.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the name of the folder.
     *
     * @return the name of the folder.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the folder.
     *
     * @param name the name of the folder.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type of the folder (main, trash, custom).
     *
     * @param type the type of the folder (main, trash, custom).
     */
    public void setType( String type ) {
        this.type = type;
    }


    /**
     * Gets whether or not the folder is the default (1 or 0).
     *
     * @return whether or not the folder is the default (1 or 0).
     */
    @JsonProperty( "default_tag" )
    public int getDefaultTag() {
        return defaultTag;
    }


    /**
     * Sets whether or not the folder is the default (1 or 0).
     *
     * @param defaultTag whether or not the folder is the default (1 or 0).
     */
    @JsonProperty( "default_tag" )
    public void setDefaultTag( int defaultTag ) {
        this.defaultTag = defaultTag;
    }


    /**
     * Gets the custom status of the folder (1 or 0).
     *
     * @return the custom status of the folder (1 or 0).
     */
    public int getCustom() {
        return custom;
    }


    /**
     * Sets the custom status of the folder (1 or 0).
     *
     * @param custom the custom status of the folder (1 or 0).
     */
    public void setCustom( int custom ) {
        this.custom = custom;
    }


    /**
     * Gets the number of unread scans in the folder.
     *
     * @return the number of unread scans in the folder.
     */
    @JsonProperty( "unread_count" )
    public int getUnreadCount() {
        return unreadCount;
    }


    /**
     * Sets the number of unread scans in the folder.
     *
     * @param unreadCount the number of unread scans in the folder.
     */
    @JsonProperty( "unread_count" )
    public void setUnreadCount( int unreadCount ) {
        this.unreadCount = unreadCount;
    }
}
