package com.tenable.io.api.workbenches.models;


import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetVulnerabilities {
    private List<Severity> severities;
    private int total;


    /**
     * Gets severities.
     *
     * @return the severities
     */
    public List<Severity> getSeverities() {
        return severities;
    }


    /**
     * Sets severities.
     *
     * @param severities the severities
     */
    public void setSeverities( List<Severity> severities ) {
        this.severities = severities;
    }


    /**
     * Gets total.
     *
     * @return the total
     */
    public int getTotal() {
        return total;
    }


    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal( int total ) {
        this.total = total;
    }
}
