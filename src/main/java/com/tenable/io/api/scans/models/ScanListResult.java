package com.tenable.io.api.scans.models;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanListResult {
    private List<Scan> scans;
    private int timestamp;

    /**
     * Get the list of scans.
     *
     * @return the list of scans
     */
    public List<Scan> getScans() {
        return scans;
    }


    /**
     * Sets the list of scans
     *
     * @param scans the list of scans
     */
    public void setScans( List<Scan> scans ) {
        this.scans = scans;
    }


    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }


    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp( int timestamp ) {
        this.timestamp = timestamp;
    }
}
