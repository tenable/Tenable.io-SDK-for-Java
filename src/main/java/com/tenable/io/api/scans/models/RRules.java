package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class RRules {
    private String freq;
    private int interval;
    private String byWeekDay;
    private int byMonthDay;
    private String stringValue;


    /**
     * Instantiates a new RRules.
     *
     * @param value the value
     */
    public RRules( String value ) {
        this.stringValue = value;
    }


    public RRules() {
    }


    /**
     * Gets the frequency.
     *
     * @return the freq
     */
    public String getFreq() {
        return freq;
    }


    /**
     * Sets the frequency.
     *
     * @param freq the freq
     */
    public void setFreq( String freq ) {
        this.freq = freq;
    }


    /**
     * Gets the interval.
     *
     * @return the interval
     */
    public int getInterval() {
        return interval;
    }


    /**
     * Sets the interval.
     *
     * @param interval the interval
     */
    public void setInterval( int interval ) {
        this.interval = interval;
    }


    /**
     * Gets the day of week.
     *
     * @return the day of week
     */
    @JsonProperty( "byweekday" )
    public String getByWeekDay() {
        return byWeekDay;
    }


    /**
     * Sets the day of week
     *
     * @param byWeekDay the day of week
     */
    @JsonProperty( "byweekday" )
    public void setByWeekDay( String byWeekDay ) {
        this.byWeekDay = byWeekDay;
    }


    /**
     * Gets the day of month.
     *
     * @return the day of month
     */
    @JsonProperty( "bymonthday" )
    public int getByMonthDay() {
        return byMonthDay;
    }


    /**
     * Sets the day of month.
     *
     * @param byMonthDay the day of month
     */
    @JsonProperty( "bymonthday" )
    public void setByMonthDay( int byMonthDay ) {
        this.byMonthDay = byMonthDay;
    }


    /**
     * Gets string value.
     *
     * @return the string value
     */
    public String getStringValue() {
        return stringValue;
    }


    /**
     * Sets string value.
     *
     * @param stringValue the string value
     */
    public void setStringValue( String stringValue ) {
        this.stringValue = stringValue;
    }
}
