package com.tenable.io.api.workbenches;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.scans.models.Vulnerability;
import com.tenable.io.api.workbenches.models.*;
import com.tenable.io.core.exceptions.TenableIoException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchHelper {
    private TenableIoClient client;
    private int sleepInterval = 5000;


    /**
     * Instantiates a new Scan helper.
     *
     * @param client the client
     */
    public WorkbenchHelper( TenableIoClient client ) {
        this.client = client;
    }


    /**
     * Gets all assets with 0 or more vuln(s) bound by date up to today
     *
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @return all assets with 0 or more vuln(s) bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<VulnerabilityAsset> getAllRecentAssetsWithVulns( int startingFromDays ) throws TenableIoException {
        List<VulnerabilityAsset> allAssets = client.getWorkbenchesApi().assets( new FilteringOptions().withDateRange( startingFromDays ) );
        List<VulnerabilityAsset> assetsWithVulns = client.getWorkbenchesApi().assetsVulnerabilities( new FilteringOptions().withDateRange( startingFromDays ) );

        if( assetsWithVulns.size() > 0 ) {
            Map<String, VulnerabilityAsset> assetsWithVulnsMap = new HashMap<>( assetsWithVulns.size() );
            for( VulnerabilityAsset asset : assetsWithVulns ) {
                assetsWithVulnsMap.put( asset.getId(), asset );
            }
            for( VulnerabilityAsset asset : allAssets ) {
                if( assetsWithVulnsMap.containsKey( asset.getId() ) )
                    asset.setSeverities( assetsWithVulnsMap.get( asset.getId() ).getSeverities() );
            }
        }

        return allAssets;
    }


    /**
     * Gets all assets with the given vuln bound by date up to today
     *
     * @param pluginId The id of the vuln/plugin to return the affected assets of
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @return all assets with the given vuln bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<VulnerabilityOutput> getAllRecentAssetsByVuln( int pluginId, int startingFromDays ) throws TenableIoException {
        List<VulnerabilityOutputResult> results = client.getWorkbenchesApi().vulnerabilityOutput( pluginId, new FilteringOptions().withDateRange( startingFromDays ) );
        List<VulnerabilityOutput> vulnerabilityOutputs = new ArrayList<>( results.size() );

        for( VulnerabilityOutputResult result : results ) {
            for( VulnerabilityState state : result.getStates() ) {
                for( VulnerabilityOutput asset : state.getResults() ) {
                    vulnerabilityOutputs.add( asset );
                }
            }
        }

        return vulnerabilityOutputs;
    }


    /**
     * Gets all vulns associated with 0 or more asset(s) bound by date up to today.
     *
     * @param startingFromDays the starting from days
     * @return all vulns associated with 0 or more asset(s) bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<Vulnerability> getAllRecentVulnerabilities( int startingFromDays ) throws TenableIoException {
        return client.getWorkbenchesApi().vulnerabilities( new ExtendedFilteringOptions().withAge( 0 ).withDateRange( startingFromDays ) );
    }


    /**
     * Gets all vulns associated with the given asset bound by date up to today.
     *
     * @param assetId asset ID
     * @param startingFromDays the starting from days
     * @return all vulns associated with the given asset bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<Vulnerability> getAllRecentVulnerabilitiesByAsset( String assetId, int startingFromDays ) throws TenableIoException {
        return client.getWorkbenchesApi().assetVulnerabilities( assetId, new FilteringOptions().withDateRange( startingFromDays ) );
    }


    /**
     * Exports workbench bound by date up to today to the given file
     *
     * @param destinationFile the destination file
     * @param startingFromDays the starting from days
     * @throws TenableIoException
     */
    public void exportToFile( File destinationFile, int startingFromDays ) throws TenableIoException {
        int fileId = client.getWorkbenchesApi().exportRequest( new ExportOptions().withFormat( FileFormat.NESSUS ).withReport( ReportType.VULNERABILITIES ).withChapter( "vuln_by_plugin;vuln_by_asset;vuln_hosts_summary" ).withDateRange( startingFromDays ) );
        waitUntilFileReady( fileId );
        client.getWorkbenchesApi().exportDownload( fileId, destinationFile );
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


    private void waitUntilFileReady( int fileId ) throws TenableIoException {
        while( !"ready".equals( client.getWorkbenchesApi().exportStatus( fileId ) ) ) {
            try {
                Thread.sleep( getSleepInterval() );
            } catch( InterruptedException e ) {}
        }
    }
}


