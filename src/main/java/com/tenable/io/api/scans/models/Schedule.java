package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Schedule {
    private boolean enabled;
    private boolean control;
    private RRules rRules;
    private String startTime;
    private String timezone;


    /**
     * Get whether the schedule is enabled.
     *
     * @return whether the schedule is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }


    /**
     * Sets whether the schedule is enabled.
     *
     * @param enabled whether the schedule is enabled
     */
    public void setEnabled( boolean enabled ) {
        this.enabled = enabled;
    }


    /**
     * Is control boolean.
     *
     * @return the boolean
     */
    public boolean isControl() {
        return control;
    }


    /**
     * Sets control.
     *
     * @param control the control
     */
    public void setControl( boolean control ) {
        this.control = control;
    }


    /**
     * Gets the schedule rules.
     *
     * @return the schedule rules objects
     */
    @JsonProperty( "rrules" )
    public RRules getrRules() {
        return rRules;
    }


    /**
     * Sets the schedule rules.
     *
     * @param rRules the schedule rules
     */
    @JsonProperty( "rrules" )
    public void setrRules( RRules rRules ) {
        this.rRules = rRules;
    }


    /**
     * Gets the start time.
     *
     * @return the start time
     */
    @JsonProperty( "starttime" )
    public String getStartTime() {
        return startTime;
    }


    /**
     * Sets the start time.
     *
     * @param startTime the start time
     */
    @JsonProperty( "starttime" )
    public void setStartTime( String startTime ) {
        this.startTime = startTime;
    }


    /**
     * Gets the timezone.
     *
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }


    /**
     * Sets the timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone( String timezone ) {
        this.timezone = timezone;
    }

}
