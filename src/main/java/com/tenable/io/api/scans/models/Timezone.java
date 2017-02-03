package com.tenable.io.api.scans.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Timezone {
    private String name;
    private String value;


    /**
     * Gets the readable name of the timezone.
     *
     * @return the readable name of the timezone.
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the readable name of the timezone.
     *
     * @param name the readable name of the timezone.
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Gets the system value for the timezone.
     *
     * @return the system value for the timezone.
     */
    public String getValue() {
        return value;
    }


    /**
     * Sets the system value for the timezone.
     *
     * @param value the system value for the timezone.
     */
    public void setValue( String value ) {
        this.value = value;
    }
}
