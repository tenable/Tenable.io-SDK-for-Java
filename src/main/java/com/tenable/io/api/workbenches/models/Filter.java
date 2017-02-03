package com.tenable.io.api.workbenches.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Filter {
    private String filter;
    private String quality;
    private String value;


    /**
     * Gets filter.
     *
     * @return the filter
     */
    public String getFilter() {
        return filter;
    }


    /**
     * Sets filter.
     *
     * @param filter the filter
     */
    public void setFilter( String filter ) {
        this.filter = filter;
    }


    /**
     * Gets quality.
     *
     * @return the quality
     */
    public String getQuality() {
        return quality;
    }


    /**
     * Sets quality.
     *
     * @param quality the quality
     */
    public void setQuality( String quality ) {
        this.quality = quality;
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }


    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue( String value ) {
        this.value = value;
    }
}
