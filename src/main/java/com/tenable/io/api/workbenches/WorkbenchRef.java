package com.tenable.io.api.workbenches;


import com.tenable.io.api.models.AssetVulnerabilities;
import com.tenable.io.api.models.Vulnerability;
import com.tenable.io.core.exceptions.TenableIoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchRef implements ParseWorkbenchByAsset, ParseWorkbenchByVulnerability {
    private static Logger logger = LoggerFactory.getLogger( WorkbenchRef.class );

    private File exportFile;
    private WorkbenchNessusFileParser parser;
    private boolean isClosed;


    /**
     * Instantiates a new Workbench ref.
     *
     * @param exportFile the export file
     * @param pageSize   the page size
     */
    public WorkbenchRef( File exportFile, int pageSize ) {
        this.exportFile = exportFile;
        this.parser = new WorkbenchNessusFileParser( exportFile, pageSize );
        this.isClosed = false;
    }


    /**
     * Parses the next page's worth of AssetVulnerabilities object and returns it.
     * Returns an empty list if the last items has been reached.
     *
     * @return the next page's worth of AssetVulnerabilities object
     * @throws TenableIoException thrown if a parameter is invalid or the nessus file cannot be found or when encountering deserialization error
     */
    @Override
    public List<AssetVulnerabilities> getNextAssetPage() throws TenableIoException {
        List<AssetVulnerabilities> page;
        if( !isClosed ) {
            page = parser.getNextAssetPage();
            checkPageAndCloseFile( page );
        }
        else page = Collections.emptyList();

        return page;
    }


    /**
     * Parses the next page's worth of Vulnerability object and returns it.
     * Returns an empty list if the last items has been reached.
     *
     * @return the next page's worth of Vulnerability object
     * @throws TenableIoException thrown if a parameter is invalid or the nessus file cannot be found or when encountering deserialization error
     */
    @Override
    public List<Vulnerability> getNextVulnerabilitiesPage() throws TenableIoException {
        List<Vulnerability> page;
        if( !isClosed ) {
            page = parser.getNextVulnerabilitiesPage();
            checkPageAndCloseFile( page );
        }
        else page = Collections.emptyList();

        return page;
    }


    /**
     * Call this method to delete the exported Nessus file once done with parsing.
     * The file will automatically deleted when the next page is requested or when using this object within a try-with-resources statement
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        isClosed = true;
        if( this.exportFile.exists() ) {
            this.exportFile.delete();
        }
    }


    private void checkPageAndCloseFile( List page ) {
        if( page == null || page.size() == 0 ) {
            try {
                close();
            } catch( Exception e ) {
                logger.warn( String.format( "Error while trying to delete nessus file %s.", exportFile.getAbsolutePath() ), e );
            }
        }
    }
}
