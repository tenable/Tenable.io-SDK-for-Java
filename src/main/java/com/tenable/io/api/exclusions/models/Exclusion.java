package com.tenable.io.api.exclusions.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.scans.models.Schedule;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Exclusion {
    private int id;
    private String name;
    private String description;
    private String members;
    private int creationDate;
    private int lastModificationDate;
    private Schedule schedule;


    /**
     * Gets the unique id of the exclusion.
     *
     * @return the unique id of the exclusion.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the unique id of the exclusion.
     *
     * @param id the unique id of the exclusion.
     */
    public void setId( int id ) {
        this.id = id;
    }


    /**
     * Gets the name of the exclusion.
     *
     * @return the name of the exclusion.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name of the exclusion.
     *
     * @param name the name of the exclusion.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the description of the exclusion.
     *
     * @return the description of the exclusion.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description of the exclusion.
     *
     * @param description the description of the exclusion.
     */
    public void setDescription( String description ) {
        this.description = description;
    }


    /**
     * Gets the members of the exclusion.
     *
     * @return the members of the exclusion.
     */
    public String getMembers() {
        return members;
    }


    /**
     * Sets the members of the exclusion.
     *
     * @param members the members of the exclusion.
     */
    public void setMembers( String members ) {
        this.members = members;
    }


    /**
     * Gets the creation date of the exclusion in unixtime.
     *
     * @return the creation date of the exclusion in unixtime.
     */
    @JsonProperty( "creation_date" )
    public int getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creation date of the exclusion in unixtime.
     *
     * @param creationDate the creation date of the exclusion in unixtime.
     */
    @JsonProperty( "creation_date" )
    public void setCreationDate( int creationDate ) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the last modification date for the exclusion in unixtime.
     *
     * @return the last modification date for the exclusion in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * Sets the last modification date for the exclusion in unixtime.
     *
     * @param lastModificationDate the last modification date for the exclusion in unixtime.
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * Gets a time window to limit the exclusion.
     *
     * @return the time window to limit the exclusion.
     */
    public Schedule getSchedule() {
        return schedule;
    }


    /**
     * Sets a time window to limit the exclusion.
     *
     * @param schedule a time window to limit the exclusion.
     */
    public void setSchedule( Schedule schedule ) {
        this.schedule = schedule;
    }
}
