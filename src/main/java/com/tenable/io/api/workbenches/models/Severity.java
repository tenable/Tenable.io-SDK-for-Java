package com.tenable.io.api.workbenches.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Severity {
    private int count;
    private int level;
    private String name;


    /**
     * The number of vulnerabilities found for the given severity level.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }


    /**
     * The number of vulnerabilities found for the given severity level.
     *
     * @param count the count
     */
    public void setCount( int count ) {
        this.count = count;
    }


    /**
     * The numeric value of the severity level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }


    /**
     * The numeric value of the severity level.
     *
     * @param level the level
     */
    public void setLevel( int level ) {
        this.level = level;
    }


    /**
     * The readable severity level, i.e. Info, Low, Medium, High or Critical.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * The readable severity level, i.e. Info, Low, Medium, High or Critical.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }
}
