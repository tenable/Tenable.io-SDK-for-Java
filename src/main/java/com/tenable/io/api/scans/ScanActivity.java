package com.tenable.io.api.scans;

import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.scans.models.ScanDetails;
import com.tenable.io.core.exceptions.TenableIoException;

import java.util.Date;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanActivity implements Comparable<ScanActivity> {
    private Date timestamp;
    private Integer scanId;
    private String scheduleUuid;
    private Integer historyId;
    private String historyUuid;

    private TenableIoClient client;


    ScanActivity( TenableIoClient client, Date timestamp, Integer scanId, String scheduleUuid, Integer historyId, String historyUuid ) {
        this.client = client;

        this.timestamp = timestamp;
        this.scanId = scanId;
        this.scheduleUuid = scheduleUuid;
        this.historyId = historyId;
        this.historyUuid = historyUuid;
    }

    public ScanRef getScan() throws TenableIoException {
        // Scan helper pass client and scanId
        if ( scanId == null )
            return null;

        return new ScanRef( client, scanId );
    }

    public ScanDetails getScanDetails() throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        if ( scanId == null )
            return null;

        return scanApi.details( scanId, historyId );
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the scan id.
     *
     * @return the scan id
     */
    public Integer getScanId() {
        return scanId;
    }

    /**
     * Gets the schedule uuid.
     *
     * @return the schedule uuid
     */
    public String getScheduleUuid() {
        return scheduleUuid;
    }

    /**
     * Gets the history id.
     *
     * @return the history id
     */
    public Integer getHistoryId() {
        return historyId;
    }

    /**
     * Gets the history uuid.
     *
     * @return the history uuid
     */
    public String getHistoryUuid() {
        return historyUuid;
    }

    /**
     * Implements Comparable interface to sort ScanActivity by most recent timestamp field.  Scans that are running will have a null
     * timestamp field.
     *
     * @param scanActivity     ScanActivity instance we are comparing this object with
     * @return the compareTo value of -1, 0 or 1 if this object's Date is more recent than, equal to or less recent than compared Date
     */
    public int compareTo( ScanActivity scanActivity ) {
        if ( timestamp == null ) {
            return -1;
        } else if ( scanActivity.timestamp == null ) {
            return 1;
        }
        return  scanActivity.timestamp.compareTo( timestamp );
    }
}
