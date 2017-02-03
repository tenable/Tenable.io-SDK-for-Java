package com.tenable.io.api.editors.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Family {
    private int id;
    private int count;
    private String status;


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
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }


    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount( int count ) {
        this.count = count;
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
}
