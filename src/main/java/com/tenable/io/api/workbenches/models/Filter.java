package com.tenable.io.api.workbenches.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Filter {
    private String filter;
    private FilterOperator quality;
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
     * With filter filter.
     *
     * @param filter the filter
     * @return the filter
     */
    public Filter withFilter( String filter ) {
        this.filter = filter;
        return this;
    }


    /**
     * Gets quality.
     *
     * @return the quality
     */
    public FilterOperator getQuality() {
        return quality;
    }


    /**
     * Sets quality.
     *
     * @param quality the quality
     */
    public void setQuality( FilterOperator quality ) {
        this.quality = quality;
    }


    /**
     * With quality filter.
     *
     * @param quality the quality
     * @return the filter
     */
    public Filter withQuality( FilterOperator quality ) {
        this.quality = quality;
        return this;
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


    /**
     * With value filter.
     *
     * @param value the value
     * @return the filter
     */
    public Filter withValue( String value ) {
        this.value = value;
        return this;
    }
}
