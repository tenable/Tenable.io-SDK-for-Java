package com.tenable.io.api.exports.models;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class CancelExport {
    private String uuid;
    private Status status;

    /**
     * Sets the cancel export request UUID.
     *
     * @param uuid the cancel export request UUID
     */
    public void setUuid( String uuid ) { this.uuid = uuid; }

    /**
     * Gets the cancel export request UUID.
     *
     * @return the cancel export request UUID
     */
    public String getUuid() { return this.uuid; }

    /**
     * Sets the status of the cancel export request.
     *
     * @param status the status for the export request
     */
    public void setStatus( Status status ) { this.status = status; }


    /**
     * Gets the status of the cancel export request
     *
     * @return the status of the cancel export request
     */
    public Status getStatus() { return this.status; }
}
