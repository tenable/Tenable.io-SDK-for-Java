package com.tenable.io.api.workbenches.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WbAssetActivity {
    private Date timestamp;
    private String scanId;
    private String scheduleId;


    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets scan id.
     *
     * @return the scan id
     */
    public String getScanId() {
        return scanId;
    }

    /**
     * Sets scan id.
     *
     * @param scanId the scan id
     */
    @JsonProperty( "scan_id" )
    public void setScanId(String scanId) {
        this.scanId = scanId;
    }

    /**
     * Gets schedule id.
     *
     * @return the schedule id
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * Sets schedule id.
     *
     * @param scheduleId the schedule id
     */
    @JsonProperty( "schedule_id" )
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
}
