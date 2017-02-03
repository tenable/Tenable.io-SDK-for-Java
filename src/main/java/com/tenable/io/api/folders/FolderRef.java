package com.tenable.io.api.folders;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.folders.models.Folder;
import com.tenable.io.api.scans.ScanRef;
import com.tenable.io.api.scans.interfaces.RunnableScan;
import com.tenable.io.core.exceptions.TenableIoException;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FolderRef {
    private TenableIoClient client;
    private int id;


    /**
     * Instantiates a new Folder ref.
     *
     * @param client the api client
     * @param id     the folder id
     */
    public FolderRef( TenableIoClient client, int id ) {
        this.client = client;
        this.id = id;
    }


    /**
     * Get folder id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Get scans in the folder
     *
     * @return A list of ScanRef for the scans in the folder.
     * @throws TenableIoException the Tenable IO exception
     */
    public List<ScanRef> scans() throws TenableIoException {
        return this.client.getScanHelper().getScans( this.id );
    }


    /**
     * Stop all the scans in the folder.
     *
     * @return The same instance of FolderRef.
     * @throws TenableIoException   the Tenable IO exception
     * @throws InterruptedException the interrupted exception
     */
    public FolderRef stopScans() throws TenableIoException, InterruptedException {
        this.client.getScanHelper().stopAll( this );
        return this;
    }


    /**
     * Add a scan to the folder.
     *
     * @param scan An instance of ScanRef for the scan
     * @return The same instance of FolderRef.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef add( RunnableScan scan ) throws TenableIoException {
        if( scan != null ) {
            scan.moveTo( this );
        }
        return this;
    }


    /**
     * Add a scan to the folder.
     *
     * @param scanId The ID of the scan
     * @return The same instance of FolderRef.
     * @throws TenableIoException the Tenable IO exception
     */
    public FolderRef add( int scanId ) throws TenableIoException {
        ScanRef scan = this.client.getScanHelper().getScan( scanId );
        if( scan != null ) {
            scan.moveTo( this );
        }
        return this;
    }


    /**
     * Get folder details
     *
     * @return the folder details
     * @throws TenableIoException the Tenable IO exception
     */
    public Folder info() throws TenableIoException {
        return this.client.getFolderHelper().id( this.id );
    }


    /**
     * Get the folder name.
     *
     * @return the folder name
     * @throws TenableIoException the Tenable IO exception
     */
    public String name() throws TenableIoException {
        Folder folder = info();
        if( folder != null ) {
            return folder.getName();
        }
        return null;
    }


    /**
     * Get the folder type
     *
     * @return the folder type
     * @throws TenableIoException the Tenable IO exception
     */
    public String type() throws TenableIoException {
        Folder folder = info();
        if( folder != null ) {
            return folder.getType();
        }
        return null;
    }


    /**
     * Delete the folder.
     *
     * @throws TenableIoException the Tenable IO exception
     */
    public void delete() throws TenableIoException {
        this.client.getFoldersApi().delete( this.id );
    }


}
