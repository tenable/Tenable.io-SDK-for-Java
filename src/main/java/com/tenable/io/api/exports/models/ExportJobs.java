package com.tenable.io.api.exports.models;


import java.util.List;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class ExportJobs {
    private List<Export> exports;


    /**
     * Sets the list of exports statuses of the export request.
     *
     * @param exports the status for the export request
     */
    public void setExports( List<Export> exports ) { this.exports = exports; }


    /**
     * Gets the list of all exports of the export request
     *
     * @return the list of all exports statuses of the export request
     */
    public List<Export> getExports() { return this.exports; }
}
