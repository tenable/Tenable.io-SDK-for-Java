package com.tenable.io.api.scans.interfaces;


import com.tenable.io.core.exceptions.TenableIoException;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 * RunningScan interface implements step builder design pattern.
 * RunningScan interface enforces that operations on a scan are done in a specific order.
 */
public interface RunningScan extends ScanBaseOp {
    /**
     * Blocks until the scan is stopped.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan waitUntilStopped() throws TenableIoException, InterruptedException;


    /**
     * Blocks until the scan is stopped.
     *
     * @param historyId The scan history id to wait for.
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan waitUntilStopped( int historyId ) throws TenableIoException, InterruptedException;


    /**
     * Blocks until the scan is stopped, or cancel if it isn't stopped within the specified seconds.
     *
     * @param seconds the seconds to wait
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan waitOrCancelAfter( int seconds ) throws TenableIoException, InterruptedException;


    /**
     * Stop the scan. This method will block until the scan's status is stopped.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan stop() throws TenableIoException, InterruptedException;


    /**
     * Stop the scan.
     *
     * @param wait If True, the method blocks until the scan's status is stopped.
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan stop( boolean wait ) throws TenableIoException, InterruptedException;


    /**
     * Pause the scan. This method will block until the status of the scan is not pausing.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan pause() throws TenableIoException, InterruptedException;


    /**
     * Pause the scan.
     *
     * @param wait If true this method will block until the status of the scan is not pausing.
     * @return The same ScanRef instance
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    RunnableScan pause( boolean wait ) throws TenableIoException, InterruptedException;
}
