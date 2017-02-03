package com.tenable.io.api.server.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerStatus {
    private String status;
    private int progress;
    private int code;


    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }


    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode( int code ) {
        this.code = code;
    }


    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus( String status ) {
        this.status = status;
    }


    /**
     * Gets progress.
     *
     * @return the progress
     */
    public int getProgress() {
        return progress;
    }


    /**
     * Sets progress.
     *
     * @param progress the progress
     */
    public void setProgress( int progress ) {
        this.progress = progress;
    }
}
