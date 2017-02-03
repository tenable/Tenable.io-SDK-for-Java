package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanComplianceCountsHistory {
    private int total;
    private int pass;
    private int warn;
    private int fail;
    private int reportDate;


    /**
     * Gets total number of compliance issues found in the scan.
     *
     * @return total number of compliance issues found in the scan.
     */
    public int getTotal() {
        return total;
    }


    /**
     * Sets total number of compliance issues found in the scan.
     *
     * @param total total number of compliance issues found in the scan.
     */
    public void setTotal( int total ) {
        this.total = total;
    }


    /**
     * Gets number of compliance issues found in the scan with a passing status.
     *
     * @return number of compliance issues found in the scan with a passing status.
     */
    public int getPass() {
        return pass;
    }


    /**
     * Sets number of compliance issues found in the scan with a passing status.
     *
     * @param pass number of compliance issues found in the scan with a passing status.
     */
    public void setPass( int pass ) {
        this.pass = pass;
    }


    /**
     * Gets number of compliance issues found in the scan with a warn status.
     *
     * @return number of compliance issues found in the scan with a warn status.
     */
    public int getWarn() {
        return warn;
    }


    /**
     * Sets number of compliance issues found in the scan with a warn status.
     *
     * @param warn number of compliance issues found in the scan with a warn status.
     */
    public void setWarn( int warn ) {
        this.warn = warn;
    }


    /**
     * Gets number of compliance issues found in the scan with a fail status.
     *
     * @return number of compliance issues found in the scan with a fail status.
     */
    public int getFail() {
        return fail;
    }


    /**
     * Sets number of compliance issues found in the scan with a fail status.
     *
     * @param fail number of compliance issues found in the scan with a fail status.
     */
    public void setFail( int fail ) {
        this.fail = fail;
    }


    /**
     * Gets the data and time in milliseconds from the epoc that represents when the scan finished.
     *
     * @return the data and time in milliseconds from the epoc that represents when the scan finished.
     */
    @JsonProperty( "report_date" )
    public int getReportDate() {
        return reportDate;
    }


    /**
     * Sets the data and time in milliseconds from the epoc that represents when the scan finished.
     *
     * @param reportDate the data and time in milliseconds from the epoc that represents when the scan finished.
     */
    @JsonProperty( "report_date" )
    public void setReportDate( int reportDate ) {
        this.reportDate = reportDate;
    }
}
