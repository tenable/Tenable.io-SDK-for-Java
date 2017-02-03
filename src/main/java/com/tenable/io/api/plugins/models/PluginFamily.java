package com.tenable.io.api.plugins.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PluginFamily {
    private int id;
    private String name;
    private int count;


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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
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
}
