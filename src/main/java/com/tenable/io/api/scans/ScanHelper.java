package com.tenable.io.api.scans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.scans.models.History;
import com.tenable.io.api.scans.models.Scan;
import com.tenable.io.api.scans.models.ScanDetails;
import com.tenable.io.api.scans.models.ScanListResult;
import com.tenable.io.api.scans.models.ScanStatus;
import com.tenable.io.core.exceptions.TenableIoException;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScanHelper {
    private static final long MILLISEC_IN_A_DAY = 3600L * 24L * 1000L;
    private static Logger logger = LoggerFactory.getLogger( ScanHelper.class );

    /**
     * The string literal indicating a scan export request is ready for download.
     */
    public final String STATUS_EXPORT_READY = "ready";

    /**
     * The list of Statuses indicating a scan is stopped.
     */
    public final List<ScanStatus> STATUSES_STOPPED = Arrays.asList( new ScanStatus[]{
            ScanStatus.STOPPED, ScanStatus.ABORTED, ScanStatus.COMPLETED, ScanStatus.CANCELED, ScanStatus.EMPTY,
            ScanStatus.IMPORTED
    } );

    private TenableIoClient client;

    private int sleepInterval = 5000;


    /**
     * Instantiates a new Scan helper.
     *
     * @param client the client
     */
    public ScanHelper( TenableIoClient client ) {
        this.client = client;
    }


    /**
     * Get a scan by id.
     *
     * @param id the id of the scan
     * @return the scan ref object
     * @throws TenableIoException the tenable IO exception
     */
    public ScanRef getScan( int id ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        // getting scan details to validate existence of the scan
        scanApi.details( id );
        // getObjectId() returns null if scan does not belong to current user
        // return new ScanRef( this.client, scanApi.details( id ).getInfo().getObjectId() );
        return new ScanRef( this.client, id );
    }


    /**
     * Return list of scans
     *
     * @return the list of scans
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanRef> getScans() throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        ScanListResult allScans = scanApi.list();
        return getScans( allScans, null, null );
    }


    /**
     * Return list of scans inside a folder
     *
     * @param folderId the folder id to search scans under
     * @return the list of scans
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanRef> getScans( int folderId ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        ScanListResult allScans = scanApi.list( folderId );
        return getScans( allScans, null, null );
    }


    /**
     * Return list of scans by name.
     *
     * @param name the name to search for
     * @return the list of scans
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanRef> getScansByName( String name ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        ScanListResult allScans = scanApi.list();
        return getScans( allScans, name, null );
    }


    /**
     * Return list of scans by name.
     *
     * @param name     the name to search for
     * @param folderId the folder id to search scans under
     * @return the list of scans
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanRef> getScansByName( String name, int folderId ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        ScanListResult allScans = scanApi.list( folderId );
        return getScans( allScans, name, null );
    }


    /**
     * Return list of scans with names matching a regular expression
     *
     * @param nameRegex the name regular expression pattern
     * @return the list of scans matching the regular expression
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanRef> getScansByRegex( String nameRegex ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        ScanListResult allScans = scanApi.list();
        return getScans( allScans, null, nameRegex );
    }


    /**
     * Return list of scans with names matching a regular expression
     *
     * @param nameRegex the name regular expression pattern
     * @param folderId  the folder id to search scans under
     * @return the list of scans matching the regular expression
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanRef> getScansByRegex( String nameRegex, int folderId ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();
        ScanListResult allScans = scanApi.list( folderId );
        return getScans( allScans, null, nameRegex );
    }


    /**
     * Stop existing scans and wait until all are stopped.
     *
     * @throws TenableIoException the tenable IO exception
     */
    public void stopAll() throws TenableIoException {
        List<ScanRef> scans = getScans();
        stopAll( scans );
    }


    /**
     * Stop existing scans and wait until all are stopped.
     *
     * @param folderId stop scans under this folder only
     * @throws TenableIoException the tenable IO exception
     */
    public void stopAll( int folderId ) throws TenableIoException {
        List<ScanRef> scans = getScans( folderId );
        stopAll( scans );
    }

    /**
     * Stop scans and wait until all are stopped.
     *
     * @param scans List of ScanRef. Stop only this list of scans
     * @throws TenableIoException the tenable IO exception
     */
    public void stopAll( List<ScanRef> scans ) throws TenableIoException {
        for( ScanRef item : scans ) {
            try {
                item.stop( false );
            } catch( TenableIoException e ) {
            }
        }
        for( ScanRef item : scans ) {
            item.waitUntilStopped();
        }
    }


    /**
     * Iterates through all the scans and trims the scan history. Leaves the most recent numMostRecentToKeep history.
     * Setting numMostRecentToKeep to 0 will delete all scan history.
     *
     * @param numMostRecentToKeep the number of most recent history to keep per scan
     * @throws TenableIoException the tenable io exception
     */
    public void trimScanHistory( int numMostRecentToKeep ) throws TenableIoException {
        ScansApi scanApi = client.getScansApi();

        ScanListResult result = scanApi.list();
        logger.debug( String.format( "Found %d scans.", result.getScans().size() ) );

        Comparator<History> comparator = new ScanHistoryLastModifiedDateDescending();

        for( Scan scan : result.getScans() ) {
            ScanDetails details = scanApi.details( scan.getId() );

            // more than 100 histories?
            if( details.getHistories() != null && details.getHistories().size() > numMostRecentToKeep ) {
                // first order them by timestamp
                List<History> histories = new ArrayList<>( details.getHistories() );
                Collections.sort( histories, comparator );

                logger.info( String.format( "Scan ID# %d has %d histories. Trimming oldest %d histories.", scan.getId(), details.getHistories().size(), details.getHistories().size() - numMostRecentToKeep ) );

                // trim histories
                for( int i = numMostRecentToKeep; i < histories.size(); i++ ) {
                    try {
                        scanApi.deleteHistory( scan.getId(), histories.get( i ).getHistoryId() );
                    } catch( TenableIoException te ) {
                        // log and continue
                        logger.error( String.format( "Error while trying to delete scan history. Scan ID# %d, history ID: %d.", scan.getId(), histories.get( i ).getHistoryId() ) );
                    }
                }
            }
        }
    }


    /**
     * Gets sleep interval.
     *
     * @return the sleep interval
     */
    public int getSleepInterval() {
        return sleepInterval;
    }


    /**
     * Sets sleep interval.
     *
     * @param sleepInterval the sleep interval
     */
    public void setSleepInterval( int sleepInterval ) {
        this.sleepInterval = sleepInterval;
    }


    private List<ScanRef> getScans( ScanListResult scans, String name, String regex ) throws TenableIoException {
        List<ScanRef> result = new ArrayList<>();
        if( scans != null && scans.getScans() != null ) {
            for( Scan scan : scans.getScans() ) {
                if( name != null ) {
                    if( scan.getName().equals( name ) ) {
                        result.add( new ScanRef( this.client, scan.getId() ) );
                    }
                } else if( regex != null ) {
                    if( scan.getName().matches( regex ) ) {
                        result.add( new ScanRef( this.client, scan.getId() ) );
                    }
                } else {
                    result.add( new ScanRef( this.client, scan.getId() ) );
                }
            }
        }
        return result;
    }


    private class ScanHistoryLastModifiedDateDescending implements Comparator<History> {
        public int compare( History h1, History h2 ) {
            return Integer.compare( h2.getLastModificationDate(), h1.getLastModificationDate() );
        }
    }
}
