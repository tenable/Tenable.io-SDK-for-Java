package com.tenable.io.api.scans.interfaces;


import com.tenable.io.api.folders.FolderRef;
import com.tenable.io.core.exceptions.TenableIoException;

import java.util.Date;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 * RunnableScan interface implements step builder design pattern.
 * RunnableScan interface enforces that operations on a scan are done in a specific order.
 */
public interface RunnableScan extends ScanBaseOp {
    /**
     * Launch the scan.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     */
    RunningScan launch() throws TenableIoException;


    /**
     * Launch the scan.
     *
     * @param wait If True, the method blocks until the scan's status is not pending
     * @return the same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     */
    RunningScan launch( boolean wait ) throws TenableIoException;

    /**
     * Launch the scan on a given date and time
     *
     * @param startTime date and time for the scan to start.
     * @param timeZone timezone for the startTime
     * @param targets scanTargets
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     */
    RunningScan launch(Date startTime, String timeZone, String targets) throws TenableIoException;


    /**
     * Resume the scan. This method will block until the status of the scan is not resuming.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     */
    RunningScan resume() throws TenableIoException;


    /**
     * Resume the scan.
     *
     * @param wait If true this method will block until the status of the scan is not resuming.
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     */
    RunningScan resume( boolean wait ) throws TenableIoException;


    /**
     * Create a copy of the scan.
     *
     * @return An instance of ScanRef that references the newly copied scan.
     * @throws TenableIoException   the Tenable IO exception
     */
    RunnableScan copy() throws TenableIoException;


    /**
     * Move the scan to a folder.
     *
     * @param folder An instance of FolderRef identifying the folder to move the scan to.
     * @return The same ScanRef instance.
     * @throws TenableIoException the Tenable IO exception
     */
    RunnableScan moveTo( FolderRef folder ) throws TenableIoException;


    /**
     * Move the scan into the trash folder.
     *
     * @return The same ScanRef instance.
     * @throws TenableIoException the Tenable IO exception
     */
    RunnableScan trash() throws TenableIoException;
}
