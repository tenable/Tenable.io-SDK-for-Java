package com.tenable.io.api.scans.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TimezonesResult {
    private List<Timezone> timezones;


    /**
     * Get timezones list.
     *
     * @return the timezone list
     */
    public List<Timezone> getTimezones() {
        return timezones;
    }


    /**
     * Sets timezones list.
     *
     * @param timezones the timezones
     */
    public void setTimezones( List<Timezone> timezones ) {
        this.timezones = timezones;
    }
}
