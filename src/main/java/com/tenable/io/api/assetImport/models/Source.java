package com.tenable.io.api.assetImport.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Source {
    private String name;
    private Calendar lastSeen;
    private Calendar firstSeen;


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return name; }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) { this.name = name; }


    /**
     * Gets last seen.
     *
     * @return the last seen
     */
    @JsonProperty( "last_seen" )
    public Calendar getLastSeen() { return lastSeen; }


    /**
     * Sets last seen.
     *
     * @param lastSeen the last seen
     */
    @JsonProperty( "last_seen" )
    public void setLastSeen( Calendar lastSeen ) { this.lastSeen = lastSeen; }


    /**
     * Gets first seen.
     *
     * @return the first seen
     */
    @JsonProperty( "first_seen" )
    public Calendar getFirstSeen() { return firstSeen; }


    /**
     * Sets first seen.
     *
     * @param firstSeen the first seen
     */
    @JsonProperty( "first_seen" )
    public void setFirstSeen( Calendar firstSeen ) { this.firstSeen = firstSeen; }
}
