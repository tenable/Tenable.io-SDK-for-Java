package com.tenable.io.api.scans.interfaces;


import com.tenable.io.api.folders.FolderRef;
import com.tenable.io.api.scans.models.FileFormat;
import com.tenable.io.api.scans.models.History;
import com.tenable.io.api.scans.models.ScanDetails;
import com.tenable.io.api.scans.models.ScanStatus;
import com.tenable.io.core.exceptions.TenableIoException;

import java.io.File;
import java.util.Date;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 * ScanBaseOp: Common scan operations
 */
public interface ScanBaseOp {
    /**
     * Download a scan report
     *
     * @param destinationFile The file to save the report to.
     * @param historyId       The history id to download the report for.
     * @param format          The report format.
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     */
    RunnableScan download( File destinationFile, int historyId, FileFormat format ) throws TenableIoException;


    /**
     * Download a scan report
     *
     * @param destinationFile The file to save the report to.
     * @param format          The report format.
     * @return the scan ref
     * @throws TenableIoException   the Tenable IO exception
     */
    RunnableScan download( File destinationFile, FileFormat format ) throws TenableIoException;


    /**
     * Get scan histories
     *
     * @return the list of scan histories
     * @throws TenableIoException the Tenable IO exception
     */
    List<History> getHistory() throws TenableIoException;


    /**
     * Get scan histories
     *
     * @param since only histories since this date will be returned
     * @return the list of scan histories
     * @throws TenableIoException the Tenable IO exception
     */
    List<History> getHistory( Date since ) throws TenableIoException;


    /**
     * Get scan id.
     *
     * @return the id
     */
    int getId();


    /**
     * Delete the scan
     *
     * @throws TenableIoException the Tenable IO exception
     */
    void delete() throws TenableIoException;


    /**
     * Get scan details
     *
     * @return the scan details
     * @throws TenableIoException the Tenable IO exception
     */
    ScanDetails getDetails() throws TenableIoException;


    /**
     * Get scan details
     *
     * @param historyId the history id
     * @return the scan details
     * @throws TenableIoException the Tenable IO exception
     */
    ScanDetails getDetails( int historyId ) throws TenableIoException;


    /**
     * Get the name of the scan.
     *
     * @return the name
     * @throws TenableIoException the Tenable IO exception
     */
    String getName() throws TenableIoException;


    /**
     * Get the name of the scan.
     *
     * @param historyId the scan history to get name for
     * @return the name
     * @throws TenableIoException the Tenable IO exception
     */
    String getName( int historyId ) throws TenableIoException;


    /**
     * Get the scan's status.
     *
     * @return the scan status
     * @throws TenableIoException the Tenable IO exception
     */
    ScanStatus getStatus() throws TenableIoException;


    /**
     * Get the scan's status.
     *
     * @param historyId the scan history to get status for
     * @return the scan status
     * @throws TenableIoException the Tenable IO exception
     */
    ScanStatus getStatus( int historyId ) throws TenableIoException;


    /**
     * Check if the scan is stopped.
     *
     * @return True if stopped, False otherwise.
     * @throws TenableIoException the Tenable IO exception
     */
    boolean isStopped() throws TenableIoException;


    /**
     * Check if the scan is stopped.
     *
     * @param historyId The scan history to check.
     * @return True if stopped, False otherwise.
     * @throws TenableIoException the Tenable IO exception
     */
    boolean isStopped( int historyId ) throws TenableIoException;


    /**
     * Get the folder the scan is in.
     *
     * @return An instance of FolderRef.
     * @throws TenableIoException the Tenable IO exception
     */
    FolderRef getFolder() throws TenableIoException;


    /**
     * Get the folder the scan is in.
     *
     * @param historyId The scan history to get folder for.
     * @return An instance of FolderRef.
     * @throws TenableIoException the Tenable IO exception
     */
    FolderRef getFolder( int historyId ) throws TenableIoException;
}
