package com.tenable.io.api.agentExclusions.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.scans.models.Schedule;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Exclusion {
    private int id;
    private String name;
    private String description;
    private int creationDate;
    private int lastModificationDate;
    private Schedule schedule;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( int id ) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription( String description ) {
        this.description = description;
    }

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
     * Gets last modification date.
     *
     * @return the last modification date
     */
    @JsonProperty( "last_modification_date" )
    public int getLastModificationDate() {
        return lastModificationDate;
    }

    /**
     * Sets last modification date.
     *
     * @param lastModificationDate the last modification date
     */
    @JsonProperty( "last_modification_date" )
    public void setLastModificationDate( int lastModificationDate ) {
        this.lastModificationDate = lastModificationDate;
    }

    /**
     * Gets schedule.
     *
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets schedule.
     *
     * @param schedule the schedule
     */
    public void setSchedule( Schedule schedule ) {
        this.schedule = schedule;
    }
}
