package com.tenable.io.api.workbenches;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.models.SeverityLevel;
import com.tenable.io.api.scans.models.ScanVulnerability;
import com.tenable.io.api.workbenches.models.*;
import com.tenable.io.core.exceptions.TenableIoException;

import java.io.File;
import java.util.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchHelper {
    private TenableIoClient client;
    private int sleepInterval = 5000;

    private static String EXPORT_FILE_DIRECTORY;

    static {
        EXPORT_FILE_DIRECTORY = System.getProperty( "tenableIoExportDirectory" );
        if( EXPORT_FILE_DIRECTORY == null ) {
            EXPORT_FILE_DIRECTORY = System.getenv( "TENABLEIO_EXPORT_DIRECTORY" );

            if( EXPORT_FILE_DIRECTORY == null ) {
                EXPORT_FILE_DIRECTORY = System.getProperty( "java.io.tmpdir" );
            }
        }
    }


    /**
     * Instantiates a new Scan helper.
     *
     * @param client the client
     */
    public WorkbenchHelper( TenableIoClient client ) {
        this.client = client;
    }


    /**
     * Gets a paginated list of all assets with their list of vulnerabilities bound by date up to today
     *
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @param pageSize         the page size
     * @return a paginated list of all assets with their list of vulnerabilities bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public ParseWorkbenchByAsset getAllRecentAssetsWithVulns( int startingFromDays, int pageSize ) throws TenableIoException {
        return getAllRecentAssetsWithVulns( startingFromDays, pageSize, SeverityLevel.INFO );
    }


    /**
     * Gets a paginated list of all assets with their list of vulnerabilities bound by date up to today
     * The minimum severity of the returns vulnerability can be controlled with minimumSeverity
     *
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @param pageSize         the page size
     * @param minimumSeverity  the minimum severity of the vulnerabilities to return
     * @return a paginated list of all assets with their list of vulnerabilities bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public ParseWorkbenchByAsset getAllRecentAssetsWithVulns( int startingFromDays, int pageSize, SeverityLevel minimumSeverity ) throws TenableIoException {
        return getNessusExport( startingFromDays, pageSize, minimumSeverity, null );
    }


    /**
     * Gets all assets with the given vuln bound by date up to today
     *
     * @param pluginId         The id of the vuln/plugin to return the affected assets of
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @return all assets with the given vuln bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public ParseWorkbenchByAsset getAllRecentAssetsByVuln( long pluginId, int startingFromDays, int pageSize ) throws TenableIoException {
        return getNessusExport( startingFromDays, pageSize, SeverityLevel.INFO, pluginId );
    }


    /**
     * Gets all vulnerabilities bound by date up to today.
     *
     * @param startingFromDays the number of days to gather the vulnerabilities from (to today)
     * @param pageSize         the page size
     * @return all vulnerabilities bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public ParseWorkbenchByVulnerability getAllRecentVulnerabilities( int startingFromDays, int pageSize ) throws TenableIoException {
        return getNessusExport( startingFromDays, pageSize, SeverityLevel.INFO, null );
    }


    /**
     * Gets all vulnerabilities bound by date up to today.
     * The minimum severity of the returns vulnerability can be controlled with minimumSeverity
     *
     * @param startingFromDays the number of days to gather the vulnerabilities from (to today)
     * @param pageSize         the page size
     * @param minimumSeverity  the minimum severity of the vulnerabilities to return
     * @return all vulnerabilities bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public ParseWorkbenchByVulnerability getAllRecentVulnerabilities( int startingFromDays, int pageSize, SeverityLevel minimumSeverity ) throws TenableIoException {
        return getNessusExport( startingFromDays, pageSize, minimumSeverity, null );
    }


    /**
     * Gets all vulns associated with the given asset bound by date up to today.
     *
     * @param hostName         the host name
     * @param startingFromDays the starting from days
     * @return all vulns associated with the given asset bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public ParseWorkbenchByVulnerability getAllRecentVulnerabilitiesByAsset( String hostName, int startingFromDays, int pageSize ) throws TenableIoException {
        return getNessusExport( startingFromDays, pageSize, SeverityLevel.INFO, null, new Filter().withFilter( "host.hostname" ).withQuality( FilterOperator.EQUAL ).withValue( hostName ) );
    }


    private WorkbenchRef getNessusExport( int startingFromDays, int pageSize, SeverityLevel minimumSeverity, Long pluginId, Filter... additionalFilters ) throws TenableIoException {
        String absoluteFilePath = EXPORT_FILE_DIRECTORY + File.separator + UUID.randomUUID();
        File exportFile = new File( absoluteFilePath );

        List<Filter> filters = new ArrayList<Filter>();
        // For now, All filter doesn't exists but does return all severity values
        filters.add( new Filter().withFilter( "severity" ).withQuality( FilterOperator.GREATER_THAN ).withValue( minimumSeverity.getIntValue() > 0 ? SeverityLevel.forIntValue(  minimumSeverity.getIntValue() - 1 ).getFilterValue() : "All" ) );

        if( additionalFilters != null && additionalFilters.length > 0 ) {
            for( Filter filter : additionalFilters )
                filters.add( filter );
        }

        ExportOptions options = new ExportOptions().withFormat( FileFormat.NESSUS )
                .withReport( ReportType.VULNERABILITIES )
                .withChapter( "vuln_by_asset" )
                .withStartDate( startingFromDays )
                .withFilters( filters )
                .withPluginId( pluginId ); // can be null

        exportToFile( exportFile, options );
        return new WorkbenchRef( exportFile, pageSize );
    }


    /**
     * Gets a paginated list of all assets with their list of vulnerabilities bound by date up to today
     *
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @return a paginated list of all assets with their list of vulnerabilities bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<WbVulnerabilityAsset> getAllRecentAssetsWithVulnsApi( int startingFromDays ) throws TenableIoException {
        List<WbVulnerabilityAsset> allAssets = client.getWorkbenchesApi().assets( new FilteringOptions().withDateRange( startingFromDays ) );
        List<WbVulnerabilityAsset> assetsWithVulns = client.getWorkbenchesApi().assetsVulnerabilities( new FilteringOptions().withDateRange( startingFromDays ) );

        if( assetsWithVulns.size() > 0 ) {
            Map<String, WbVulnerabilityAsset> assetsWithVulnsMap = new HashMap<>( assetsWithVulns.size() );
            for( WbVulnerabilityAsset asset : assetsWithVulns ) {
                assetsWithVulnsMap.put( asset.getId(), asset );
            }
            for( WbVulnerabilityAsset asset : allAssets ) {
                if( assetsWithVulnsMap.containsKey( asset.getId() ) )
                    asset.setSeverities( assetsWithVulnsMap.get( asset.getId() ).getSeverities() );
            }
        }

        return allAssets;
    }


    /**
     * Gets all assets with the given vuln bound by date up to today
     *
     * @param pluginId         The id of the vuln/plugin to return the affected assets of
     * @param startingFromDays the number of days to gather the assets from (to today)
     * @return all assets with the given vuln bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<WbVulnerabilityOutput> getAllRecentAssetsByVulnApi( int pluginId, int startingFromDays ) throws TenableIoException {
        List<WbVulnerabilityOutputResult> results = client.getWorkbenchesApi().vulnerabilityOutput( pluginId, new FilteringOptions().withDateRange( startingFromDays ) );
        List<WbVulnerabilityOutput> vulnerabilityOutputs = new ArrayList<>( results.size() );

        for( WbVulnerabilityOutputResult result : results ) {
            for( WbVulnerabilityState state : result.getStates() ) {
                for( WbVulnerabilityOutput asset : state.getResults() ) {
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
    public List<ScanVulnerability> getAllRecentVulnerabilitiesApi( int startingFromDays ) throws TenableIoException {
        return client.getWorkbenchesApi().vulnerabilities( new ExtendedFilteringOptions().withAge( 0 ).withDateRange( startingFromDays ) );
    }


    /**
     * Gets all vulns associated with the given asset bound by date up to today.
     *
     * @param assetId          asset ID
     * @param startingFromDays the starting from days
     * @return all vulns associated with the given asset bound by date up to today
     * @throws TenableIoException the tenable io exception
     */
    public List<ScanVulnerability> getAllRecentVulnerabilitiesByAssetApi( String assetId, int startingFromDays ) throws TenableIoException {
        return client.getWorkbenchesApi().assetVulnerabilities( assetId, new FilteringOptions().withDateRange( startingFromDays ) );
    }


    /**
     * Exports workbench bound by date up to today to the given file
     *
     * @param destinationFile  the destination file
     * @param startingFromDays the starting from days
     * @throws TenableIoException the tenable io exception
     */
    public void exportToFile( File destinationFile, int startingFromDays ) throws TenableIoException {
        int fileId = client.getWorkbenchesApi().exportRequest( new ExportOptions().withFormat( FileFormat.NESSUS ).withReport( ReportType.VULNERABILITIES ).withChapter( "vuln_by_plugin;vuln_by_asset;vuln_hosts_summary" ).withDateRange( startingFromDays ) );
        waitUntilFileReady( fileId );
        client.getWorkbenchesApi().exportDownload( fileId, destinationFile );
    }


    /**
     * Exports workbench report
     *
     * @param destinationFile the destination file
     * @param options         export options
     * @throws TenableIoException the tenable io exception
     */
    public void exportToFile( File destinationFile, ExportOptions options ) throws TenableIoException {
        int fileId = client.getWorkbenchesApi().exportRequest( options );
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
            } catch( InterruptedException e ) {
            }
        }
    }
}


