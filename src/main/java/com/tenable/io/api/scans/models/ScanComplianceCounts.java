package com.tenable.io.api.scans.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanComplianceCounts {
    private int total;
    private int pass;
    private int warn;
    private int fail;


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
}
