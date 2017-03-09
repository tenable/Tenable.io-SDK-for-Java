package com.tenable.io.api.exlusions.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.tenable.io.api.scans.models.Schedule;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class ExclusionRequest {
    private String name;
    private String description;
    private String members;
    private Schedule schedule;


    /**
     * Gets the name of the exclusion.
     *
     * @return The name of the exclusion.
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
     * Sets the name of the exclusion.
     *
     * @param name the name of the exclusion.
     */
    public ExclusionRequest withName( String name ) {
        this.name = name;
        return this;
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
     * Sets the description of the exclusion.
     *
     * @param description the description of the exclusion.
     */
    public ExclusionRequest withDescription( String description ) {
        this.description = description;
        return this;
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
     * Sets the members of the exclusion.
     *
     * @param members the members of the exclusion.
     */
    public ExclusionRequest withMembers( String members ) {
        this.members = members;
        return this;
    }


    /**
     * Gets the schedule object for the exclusion.
     *
     * @return the schedule object for the exclusion.
     */
    public Schedule getSchedule() {
        return schedule;
    }


    /**
     * Sets the schedule object for the exclusion.
     *
     * @param schedule the schedule object for the exclusion.
     */
    public void setSchedule( Schedule schedule ) {
        this.schedule = schedule;
    }


    /**
     * Sets the schedule object for the exclusion.
     *
     * @param schedule the schedule object for the exclusion.
     */
    public ExclusionRequest withSchedule( Schedule schedule ) {
        this.schedule = schedule;
        return this;
    }
}
