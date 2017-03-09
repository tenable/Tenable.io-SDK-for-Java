package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanHost {
    private int hostId;
    private String hostIndex;
    private String hostname;
    private String progress;
    private int critical;
    private int high;
    private int medium;
    private int low;
    private int info;
    private int totalChecksConsidered;
    private int numChecksConsidered;
    private int scanProgressTotal;
    private int scanProgressCurrent;
    private int score;


    /**
     * Gets the unique id of the host.
     *
     * @return the unique id of the host.
     */
    @JsonProperty( "host_id" )
    public int getHostId() {
        return hostId;
    }


    /**
     * Sets the unique id of the host.
     *
     * @param hostId the unique id of the host.
     */
    @JsonProperty( "host_id" )
    public void setHostId( int hostId ) {
        this.hostId = hostId;
    }


    /**
     * Gets the index for the host.
     *
     * @return the index for the host.
     */
    @JsonProperty( "host_index" )
    public String getHostIndex() {
        return hostIndex;
    }


    /**
     * Sets the index for the host.
     *
     * @param hostIndex the index for the host.
     */
    @JsonProperty( "host_index" )
    public void setHostIndex( String hostIndex ) {
        this.hostIndex = hostIndex;
    }


    /**
     * Gets the overall severity rating of the host.
     *
     * @return the overall severity rating of the host.
     */
    public String getHostname() {
        return hostname;
    }


    /**
     * Sets the overall severity rating of the host.
     *
     * @param hostname the overall severity rating of the host.
     */
    public void setHostname( String hostname ) {
        this.hostname = hostname;
    }


    /**
     * Gets the scan progress of the host.
     *
     * @return the scan progress of the host.
     */
    public String getProgress() {
        return progress;
    }


    /**
     * Sets the scan progress of the host.
     *
     * @param progress the scan progress of the host.
     */
    public void setProgress( String progress ) {
        this.progress = progress;
    }


    /**
     * Gets the percentage of critical findings on the host.
     *
     * @return the percentage of critical findings on the host.
     */
    public int getCritical() {
        return critical;
    }


    /**
     * Sets the percentage of critical findings on the host.
     *
     * @param critical the percentage of critical findings on the host.
     */
    public void setCritical( int critical ) {
        this.critical = critical;
    }


    /**
     * Gets the percentage of high findings on the host.
     *
     * @return the percentage of high findings on the host.
     */
    public int getHigh() {
        return high;
    }


    /**
     * Sets the percentage of high findings on the host.
     *
     * @param high the percentage of high findings on the host.
     */
    public void setHigh( int high ) {
        this.high = high;
    }


    /**
     * Gets the percentage of medium findings on the host.
     *
     * @return the percentage of medium findings on the host.
     */
    public int getMedium() {
        return medium;
    }


    /**
     * Sets the percentage of medium findings on the host.
     *
     * @param medium the percentage of medium findings on the host.
     */
    public void setMedium( int medium ) {
        this.medium = medium;
    }


    /**
     * Gets the percentage of low findings on the host.
     *
     * @return the percentage of low findings on the host.
     */
    public int getLow() {
        return low;
    }


    /**
     * Sets the percentage of low findings on the host.
     *
     * @param low the percentage of low findings on the host.
     */
    public void setLow( int low ) {
        this.low = low;
    }


    /**
     * Gets the percentage of info findings on the host.
     *
     * @return the percentage of info findings on the host.
     */
    public int getInfo() {
        return info;
    }


    /**
     * Sets the percentage of info findings on the host.
     *
     * @param info the percentage of info findings on the host.
     */
    public void setInfo( int info ) {
        this.info = info;
    }


    /**
     * Gets the total number of checks considered on the host.
     *
     * @return the total number of checks considered on the host.
     */
    @JsonProperty( "totalchecksconsidered" )
    public int getTotalChecksConsidered() {
        return totalChecksConsidered;
    }


    /**
     * Sets the total number of checks considered on the host.
     *
     * @param totalChecksConsidered the total number of checks considered on the host.
     */
    @JsonProperty( "totalchecksconsidered" )
    public void setTotalChecksConsidered( int totalChecksConsidered ) {
        this.totalChecksConsidered = totalChecksConsidered;
    }


    /**
     * Gets the number of checks considered on the host.
     *
     * @return the number of checks considered on the host.
     */
    @JsonProperty( "numchecksconsidered" )
    public int getNumChecksConsidered() {
        return numChecksConsidered;
    }


    /**
     * Sets the number of checks considered on the host.
     *
     * @param numChecksConsidered the number of checks considered on the host.
     */
    @JsonProperty( "numchecksconsidered" )
    public void setNumChecksConsidered( int numChecksConsidered ) {
        this.numChecksConsidered = numChecksConsidered;
    }


    /**
     * Gets the total scan progress for the host.
     *
     * @return the total scan progress for the host.
     */
    @JsonProperty( "scanprogresstotal" )
    public int getScanProgressTotal() {
        return scanProgressTotal;
    }


    /**
     * Sets the total scan progress for the host.
     *
     * @param scanProgressTotal the total scan progress for the host.
     */
    @JsonProperty( "scanprogresstotal" )
    public void setScanProgressTotal( int scanProgressTotal ) {
        this.scanProgressTotal = scanProgressTotal;
    }


    /**
     * Gets the current scan progress for the host.
     *
     * @return the current scan progress for the host.
     */
    @JsonProperty( "scanprogresscurrent" )
    public int getScanProgressCurrent() {
        return scanProgressCurrent;
    }


    /**
     * Sets the current scan progress for the host.
     *
     * @param scanProgressCurrent the current scan progress for the host.
     */
    @JsonProperty( "scanprogresscurrent" )
    public void setScanProgressCurrent( int scanProgressCurrent ) {
        this.scanProgressCurrent = scanProgressCurrent;
    }


    /**
     * Gets the overall score for the host.
     *
     * @return the overall score for the host.
     */
    public int getScore() {
        return score;
    }


    /**
     * Sets the overall score for the host.
     *
     * @param score the overall score for the host.
     */
    public void setScore( int score ) {
        this.score = score;
    }
}
