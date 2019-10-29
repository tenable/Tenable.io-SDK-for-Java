package com.tenable.io.api.scans;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.folders.FolderRef;
import com.tenable.io.api.scans.interfaces.RunnableScan;
import com.tenable.io.api.scans.interfaces.RunningScan;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.api.scans.models.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 * Scan Reference Object containing id of a scan and helper operations on a scan.
 */
public class ScanRef implements RunnableScan, RunningScan {
    private Map<Integer, String> historyIdToUuidLookup;
    private TenableIoClient client;
    private int id;
    private String scanUuid;
    private String scheduleUuid;


    /**
     * Instantiates a new Scan ref.
     *
     * @param client the api client
     * @param id     the scan id
     */
    public ScanRef( TenableIoClient client, int id ) {
        this.client = client;
        this.id = id;
        clearScanUuids();
    }


    /**
     * Get scan id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Create a copy of the scan.
     *
     * @return An instance of ScanRef that references the newly copied scan.
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan copy() throws TenableIoException {
        Scan copy = this.client.getScansApi().copy( this.id );
        return new ScanRef( this.client, copy.getId() );
    }


    /**
     * Delete the scan
     *
     * @throws TenableIoException the Tenable IO exception
     */
    public void delete() throws TenableIoException {
        this.client.getScansApi().delete( this.id );
    }


    /**
     * Get scan details
     *
     * @return the scan details
     * @throws TenableIoException the Tenable IO exception
     */
    public ScanDetails getDetails() throws TenableIoException {
        return this.client.getScansApi().details( this.id );
    }


    /**
     * Get scan details
     *
     * @param historyId the history id
     * @return the scan details
     * @throws TenableIoException the Tenable IO exception
     */
    public ScanDetails getDetails( int historyId ) throws TenableIoException {
        return this.client.getScansApi().details( this.id, historyId );
    }


    /**
     * Download a scan report
     *
     * @param destinationFile The file to save the report to.
     * @param format          The report format.
     * @param chapters        The report chapters to download. multiple chapters can be separated by semi-colon
     * @return the scan ref
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan download( File destinationFile, FileFormat format, String chapters ) throws TenableIoException {
        waitUntilStopped();
        ExportScanSettings settings = new ExportScanSettings();
        settings.setFormat( format );
        settings.setChapters( chapters );

        String fileId = this.client.getScansApi().exportRequest( this.id, settings );
        String status = this.client.getScansApi().exportStatus( this.id, fileId );
        while( !status.equals( this.client.getScanHelper().STATUS_EXPORT_READY ) ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
            status = this.client.getScansApi().exportStatus( this.id, fileId );
        }
        this.client.getScansApi().exportDownload( this.id, fileId, destinationFile );

        return this;
    }

    /**
     * Download a scan report
     * Defaults to only download the vuln_hosts_summary chapter
     *
     * @param destinationFile The file to save the report to.
     * @param format          The report format.
     * @return the scan ref
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan download( File destinationFile, FileFormat format ) throws TenableIoException {
        waitUntilStopped();
        ExportScanSettings settings = new ExportScanSettings();
        settings.setFormat( format );
        settings.setChapters( "vuln_hosts_summary" );

        String fileId = this.client.getScansApi().exportRequest( this.id, settings );
        String status = this.client.getScansApi().exportStatus( this.id, fileId );
        while( !status.equals( this.client.getScanHelper().STATUS_EXPORT_READY ) ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
            status = this.client.getScansApi().exportStatus( this.id, fileId );
        }
        this.client.getScansApi().exportDownload( this.id, fileId, destinationFile );

        return this;
    }


    /**
     * Download a scan report
     *
     * @param destinationFile The file to save the report to.
     * @param historyId       The history id to download the report for.
     * @param format          The report format.
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan download( File destinationFile, int historyId, FileFormat format ) throws TenableIoException {
        waitUntilStopped( historyId );
        ExportScanSettings settings = new ExportScanSettings();
        settings.setFormat( format );

        String fileId = this.client.getScansApi().exportRequest( this.id, historyId, settings );
        String status = this.client.getScansApi().exportStatus( this.id, fileId );
        while( !status.equals( this.client.getScanHelper().STATUS_EXPORT_READY ) ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
            status = this.client.getScansApi().exportStatus( this.id, fileId );
        }
        this.client.getScansApi().exportDownload( this.id, fileId, destinationFile );

        return this;
    }


    /**
     * Get scan histories
     *
     * @return the list of scan histories
     * @throws TenableIoException the Tenable IO exception
     */
    public List<History> getHistory() throws TenableIoException {
        List<History> result = new ArrayList<>();
        ScanDetails details = this.getDetails();
        if( details != null )
            result = details.getHistories();
        return result;
    }


    /**
     * Get scan histories
     *
     * @param since only histories since this date will be returned
     * @return the list of scan histories
     * @throws TenableIoException the Tenable IO exception
     */
    public List<History> getHistory( Date since ) throws TenableIoException {
        List<History> result = new ArrayList<>();
        ScanDetails details = this.getDetails();
        if( details != null ) {
            for( History history : details.getHistories() ) {
                if( ( new Date( (long)history.getCreationDate() * 1000 ) ).after( since ) ) {
                    result.add( history );
                }
            }
        }
        return result;
    }


    /**
     * Get last (most recent) scan history object
     *
     * @return the last scan history object
     * @throws TenableIoException the Tenable IO exception
     */
    public History getLastHistory() throws TenableIoException {
        List<History> histories = this.getDetails().getHistories();
        if( histories.size() == 0 ) {
            return null;
        }

        Collections.sort(histories, new Comparator<History>() {
            @Override
            public int compare(History h1, History h2) {
                return Integer.compare( h2.getLastModificationDate(), h1.getLastModificationDate() );
            }
        });
        return histories.get( 0 );
    }


    /**
     * Launch the scan.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunningScan launch() throws TenableIoException {
        if( !this.isStopped() ) {
            throw new TenableIoException( TenableIoErrorCode.Generic, "Scan is currently running or cannot be launched." );
        }
        clearScanUuids();
        this.client.getScansApi().launch( this.id, null );
        while( getStatus() == ScanStatus.PENDING ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
        }
        return this;
    }


    /**
     * Launch the scan.
     *
     * @param wait If True, the method blocks until the scan's status is not pending
     * @return the same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunningScan launch( boolean wait ) throws TenableIoException {
        if( !this.isStopped() ) {
            throw new TenableIoException( TenableIoErrorCode.Generic, "Scan is currently running or cannot be launched." );
        }
        clearScanUuids();
        this.client.getScansApi().launch( this.id, null );
        if( wait ) {
            while( getStatus() == ScanStatus.PENDING ) {
                try {
                    Thread.sleep( this.client.getScanHelper().getSleepInterval() );
                } catch( InterruptedException e ) {
                }
            }
        }
        return this;
    }


    /**
     * Launch the scan on a given date and time
     *
     * @param startTime date and time for the scan to start.
     * @param timeZone  timezone for the startTime
     * @param targets   scanTargets
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunningScan launch( Date startTime, String timeZone, String targets ) throws TenableIoException {
        clearScanUuids();

        Settings scanSettings = new Settings();
        SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyyMMdd'T'HHmmss" );
        String start = sdf1.format( startTime );
        scanSettings.setStartTime( start );
        scanSettings.setLaunch( LaunchFrequency.ONE_TIME );
        scanSettings.setTextTargets( targets );
        scanSettings.setTimezone( timeZone );
        RRules rules = new RRules();
        rules.setFreq( "ONETIME" );
        scanSettings.setrRules( rules );

        this.client.getScansApi().configure( this.id, null, scanSettings );
        return this;
    }


    /**
     * Pause the scan. This method will block until the status of the scan is not pausing.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan pause() throws TenableIoException {
        this.client.getScansApi().pause( this.id );
        while( getStatus() == ScanStatus.PAUSING ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
        }
        return this;
    }


    /**
     * Pause the scan.
     *
     * @param wait If true this method will block until the status of the scan is not pausing.
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan pause( boolean wait ) throws TenableIoException {
        this.client.getScansApi().pause( this.id );
        if( wait ) {
            while( getStatus() == ScanStatus.PAUSING ) {
                try {
                    Thread.sleep( this.client.getScanHelper().getSleepInterval() );
                } catch( InterruptedException e ) {
                }
            }
        }
        return this;
    }


    /**
     * Resume the scan. This method will block until the status of the scan is not resuming.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunningScan resume() throws TenableIoException {
        this.client.getScansApi().resume( this.id );
        while( getStatus() == ScanStatus.RESUMING ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
        }
        return this;
    }


    /**
     * Resume the scan.
     *
     * @param wait If true this method will block until the status of the scan is not resuming.
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunningScan resume( boolean wait ) throws TenableIoException {
        this.client.getScansApi().resume( this.id );
        if( wait ) {
            while( getStatus() == ScanStatus.RESUMING ) {
                try {
                    Thread.sleep( this.client.getScanHelper().getSleepInterval() );
                } catch( InterruptedException e ) {
                }
            }
        }
        return this;
    }


    /**
     * Stop the scan. This method will block until the scan's status is stopped.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan stop() throws TenableIoException {
        this.client.getScansApi().stop( this.id );
        ScanStatus status = getStatus();
        waitUntilStopped();
        return this;
    }


    /**
     * Stop the scan.
     *
     * @param wait If True, the method blocks until the scan's status is stopped.
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan stop( boolean wait ) throws TenableIoException {
        this.client.getScansApi().stop( this.id );
        if( wait ) {
            waitUntilStopped();
        }
        return this;
    }


    /**
     * Blocks until the scan is stopped.
     *
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan waitUntilStopped() throws TenableIoException {
        while( !this.isStopped() ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
        }
        return this;
    }


    /**
     * Blocks until the scan is stopped.
     *
     * @param historyId The scan history id to wait for.
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan waitUntilStopped( int historyId ) throws TenableIoException {
        while( !this.isStopped( historyId ) ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
        }
        return this;
    }


    /**
     * Blocks until the scan is stopped, or cancel if it isn't stopped within the specified seconds.
     *
     * @param seconds the seconds to wait
     * @return The same ScanRef instance
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan waitOrCancelAfter( int seconds ) throws TenableIoException {
        long startTime = System.currentTimeMillis();
        long waitTime = seconds * 1000;
        while( !this.isStopped() && ( System.currentTimeMillis() - startTime ) < waitTime ) {
            try {
                Thread.sleep( this.client.getScanHelper().getSleepInterval() );
            } catch( InterruptedException e ) {
            }
        }
        if( !Arrays.asList( client.getScanHelper().STATUSES_STOPPED ).contains( getStatus() ) ) {
            stop( false );
        }
        return this;
    }


    /**
     * Get the name of the scan.
     *
     * @return the name
     * @throws TenableIoException the Tenable IO exception
     */
    public String getName() throws TenableIoException {
        return this.getDetails().getInfo().getName();
    }


    /**
     * Get the name of the scan.
     *
     * @param historyId the scan history to get name for
     * @return the name
     * @throws TenableIoException the Tenable IO exception
     */
    public String getName( int historyId ) throws TenableIoException {
        return this.getDetails( historyId ).getInfo().getName();
    }


    /**
     * Get the scan's status.
     *
     * @return the scan status
     * @throws TenableIoException the Tenable IO exception
     */
    public ScanStatus getStatus() throws TenableIoException {
        return this.client.getScansApi().latestStatus( this.id );
    }


    /**
     * Get the scan's status.
     *
     * @param historyId the scan history to get status for
     * @return the scan status
     * @throws TenableIoException the Tenable IO exception
     */
    public ScanStatus getStatus( Integer historyId ) throws TenableIoException {
        if( scanUuid == null || scheduleUuid == null || ( historyId != null && !historyIdToUuidLookup.containsKey( historyId ) ) ) {
            ScanDetails details = getDetails();
            scanUuid = details.getInfo().getUuid();
            scheduleUuid = details.getInfo().getScheduleUuid();

            if( details.getHistories() != null ) {
                historyIdToUuidLookup = new HashMap<>( details.getHistories().size() );
                for( History history : details.getHistories() ) {
                    historyIdToUuidLookup.put( history.getHistoryId(), history.getUuid() );
                }
            }

            return details.getInfo().getStatus();
        }

        if(  historyId != null && !historyIdToUuidLookup.containsKey( historyId ) )
            throw new TenableIoException( TenableIoErrorCode.InvalidParameter, String.format( "History ID %d in Scan %s does not exist.", historyId, scanUuid ) );

        return this.client.getScansApi().getScanHistoryStatus( scheduleUuid, historyId == null ? scanUuid : historyIdToUuidLookup.get( historyId ) ).getStatus();
    }


    /**
     * Get the folder the scan is in.
     *
     * @return An instance of FolderRef.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef getFolder() throws TenableIoException {
        int folderId = this.getDetails().getInfo().getFolderId();
        return new FolderRef( this.client, folderId );
    }


    /**
     * Get the folder the scan is in.
     *
     * @param historyId The scan history to get folder for.
     * @return An instance of FolderRef.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef getFolder( int historyId ) throws TenableIoException {
        int folderId = this.getDetails( historyId ).getInfo().getFolderId();
        return new FolderRef( this.client, folderId );
    }


    /**
     * Move the scan to a folder.
     *
     * @param folder An instance of FolderRef identifying the folder to move the scan to.
     * @return The same ScanRef instance.
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan moveTo( FolderRef folder ) throws TenableIoException {
        this.client.getScansApi().folder( this.id, folder.getId() );
        return this;
    }


    /**
     * Move the scan into the trash folder.
     *
     * @return The same ScanRef instance.
     * @throws TenableIoException the Tenable IO exception
     */
    public RunnableScan trash() throws TenableIoException {
        FolderRef trash = this.client.getFolderHelper().trashFolder();
        this.moveTo( trash );
        return this;
    }


    /**
     * Check if the scan is stopped.
     *
     * @return True if stopped, False otherwise.
     * @throws TenableIoException the Tenable IO exception
     */
    public boolean isStopped() throws TenableIoException {
        return client.getScanHelper().STATUSES_STOPPED.contains( getStatus() );
    }


    /**
     * Check if the scan is stopped.
     *
     * @param historyId The scan history to check.
     * @return True if stopped, False otherwise.
     * @throws TenableIoException the Tenable IO exception
     */
    public boolean isStopped( int historyId ) throws TenableIoException {
        return client.getScanHelper().STATUSES_STOPPED.contains( getStatus( historyId ) );
    }


    private void clearScanUuids() {
        this.scheduleUuid = null;
        this.scanUuid = null;
        this.historyIdToUuidLookup = null;
    }
}
