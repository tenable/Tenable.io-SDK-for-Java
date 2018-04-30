package com.tenable.io.api;


import com.tenable.io.api.models.SeverityLevel;
import com.tenable.io.api.plugins.models.PluginDetail;
import com.tenable.io.api.plugins.models.PluginFamily;
import com.tenable.io.api.plugins.models.PluginFamilyDetail;
import com.tenable.io.api.scans.models.Scan;
import com.tenable.io.api.scans.models.ScanVulnerability;

import com.tenable.io.api.workbenches.WorkbenchNessusFileParser;
import com.tenable.io.api.workbenches.models.*;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchesApiClientTest extends TestBase {

    @Test
    public void testVulnerabilities() throws Exception {
        List<ScanVulnerability> result = apiClient.getWorkbenchesApi().vulnerabilities( new ExtendedFilteringOptions() );
        if(result != null && result.size() > 0) {
            assertNotNull(result.get(0));
            assertNotNull(result.get(0).getPluginId() );
            assertTrue(result.get(0).getSeverity() > 0);
        }

        result = apiClient.getWorkbenchesApi().vulnerabilities( new ExtendedFilteringOptions().withSeverity( SeverityLevel.CRITICAL ) );
        if(result != null && result.size() > 0) {
            assertTrue(result.size() > 0);
            assertNotNull(result.get(0));
            assertNotNull(result.get(0).getPluginId() );
            assertTrue(result.get(0).getSeverity() == 4);

            WbVulnerabilityInfo info = apiClient.getWorkbenchesApi().vulnerabilityInfo(result.get(0).getPluginId(), new FilteringOptions());
            assertNotNull(info);
            assertTrue(info.getSeverity() == 4);
            assertNotNull(info.getDescription());
            assertNotNull(info.getSolution());
            assertNotNull(info.getSynopsis());
            assertNotNull(info.getPluginDetails());
            assertNotNull(info.getDiscovery());

            List<WbVulnerabilityOutputResult> items = apiClient.getWorkbenchesApi().vulnerabilityOutput( result.get(0).getPluginId(), new FilteringOptions());
            assertNotNull( items );
            assertTrue( items.size() > 0 );
            assertNotNull( items.get(0) );
            assertNotNull( items.get(0).getPluginOutput() );
            assertNotNull( items.get(0).getStates() );

        }

    }

    @Test
    public void testAssets() throws Exception {
        // Assets need to be imported prior to running this otherwise asset count will be 0
        String filename = apiClient.getFileApi().upload( new File( "src/test/resources/sdk_import_test.nessus" ) );
        assertNotNull( filename );
        Scan imported = apiClient.getScansApi().importFile( filename, "test", "1");
        assertNotNull( imported );

        Filter ipFilter = new Filter()
                .withFilter("ipv4")
                .withQuality(FilterOperator.EQUAL)
                .withValue("10.10.10.1");
        FilteringOptions filterOptions = new FilteringOptions().withFilters(Arrays.asList(ipFilter));
        List<WbVulnerabilityAsset> assets = apiClient.getWorkbenchesApi().assets(filterOptions);
        
        // wait for assets in scan results to be processed
        while (assets.size() == 0) {
            Thread.sleep(15000);
            assets = apiClient.getWorkbenchesApi().assets(filterOptions);
        }

        if(assets != null && assets.size() > 0) {
            assertNotNull(assets.get(0));
            assertNotNull(assets.get(0).getId());
            assertNotNull(assets.get(0).getLastSeen());

            Thread.sleep(20000); // sleep another 20 seconds to be safe before requesting asset info
            WbAssetInfo assetInfo = apiClient.getWorkbenchesApi().assetInfo(assets.get(0).getId(), new FilteringOptions());
            assertNotNull(assetInfo);
            List<ScanVulnerability> vulnerabilities = apiClient.getWorkbenchesApi().assetVulnerabilities(
                    assets.get(0).getId(), new FilteringOptions());
            
            // wait for vulnerability details in scan results to be processed
            int tries = 0;
            int maxTries = 6;
            while (vulnerabilities.size() == 0) {
                Thread.sleep(10000);
                vulnerabilities = apiClient.getWorkbenchesApi().assetVulnerabilities(assets.get(0).getId(), new FilteringOptions());
                if (tries++ == maxTries) {
                    fail("Could not retrieve vulnerabilities using assetVulnerabilities");
                }
            }
            assertNotNull(vulnerabilities);
            assertTrue( vulnerabilities.size() > 0 );
            assertTrue(vulnerabilities.get(0).getCount() > 0);
            assertNotNull(vulnerabilities.get(0).getPluginId());
            assertTrue(vulnerabilities.get(0).getVulnerabilityState().equals("New"));

            WbVulnerabilityInfo info = apiClient.getWorkbenchesApi().vulnerabilityInfo(assets.get(0).getId(),
                    vulnerabilities.get(0).getPluginId(), new FilteringOptions());
            assertNotNull(info);
            assertNotNull(info.getDescription());
            assertNotNull(info.getSynopsis());

            List<WbVulnerabilityOutputResult> assetVulnerabilityOutput = apiClient.getWorkbenchesApi()
                    .assetVulnerabilityOutput(assets.get(0).getId(), vulnerabilities.get(0).getPluginId(),
                            new FilteringOptions());

            // wait for vulnerability output details to be ready
            tries = 0;
            while (assetVulnerabilityOutput.size() == 0) {
                Thread.sleep(10000);
                assetVulnerabilityOutput = apiClient.getWorkbenchesApi()
                    .assetVulnerabilityOutput(assets.get(0).getId(), vulnerabilities.get(0).getPluginId(),
                            new FilteringOptions());
                if (tries++ == maxTries) {
                    fail("Could not retrieve vulnerabilities using assetVulnerabilityOutput");
                }
            }
            assertNotNull(assetVulnerabilityOutput);
            assertTrue(assetVulnerabilityOutput.size() > 0);
            assertNotNull(assetVulnerabilityOutput.get(0).getPluginOutput());
            assertNotNull(assetVulnerabilityOutput.get(0).getStates());
        }

        List<WbVulnerabilityAsset> assetVuln = apiClient.getWorkbenchesApi().assetsVulnerabilities(new FilteringOptions());
        if(assetVuln != null && assetVuln.size() > 0) {
            assertNotNull(assetVuln.get(0));
            assertNotNull(assetVuln.get(0).getId());
            assertNotNull(assetVuln.get(0).getSeverities());
            assertTrue(assetVuln.get(0).getSeverities().size() > 0);
        }



    }

    @Test
    public void testWorkbenchExport() throws Exception {

        File destinationFile = new File("src/test/resources/workbenchTest.nessus");

        List<Filter> filters = new ArrayList<Filter>();
        Filter severity = new Filter();
        severity.setFilter("severity");
        severity.setQuality( FilterOperator.GREATER_THAN );
        severity.setValue("0");
        filters.add(severity);

        int fileId = apiClient.getWorkbenchesApi().exportRequest( new ExportOptions().withFormat( FileFormat.NESSUS )
                .withReport( ReportType.VULNERABILITIES )
                .withChapter( "vuln_by_plugin;vuln_by_asset;vuln_hosts_summary" )
                .withFilters(filters));


        int tries = 0;
        int maxTries = 10;
        while( !"ready".equals( apiClient.getWorkbenchesApi().exportStatus( fileId ) ) ) {
            try {
                Thread.sleep( 5000 );
                if (tries++ == maxTries) {
                    fail("Export did not reach a \"ready\" state");
                }
            } catch( InterruptedException e ) {}
        }

        apiClient.getWorkbenchesApi().exportDownload( fileId, destinationFile );

        assertTrue( destinationFile.exists() );

        destinationFile.delete();
    }


    private FilteringOptions GetFilteringOptions() throws Exception {
        FilteringOptions options = new FilteringOptions();
        options.setDateRange( 3 );
        List<Filter> filters = new ArrayList<>();
        Filter filter1 = new Filter();
        filter1.setFilter( "host.hostname" );
        filter1.setQuality( FilterOperator.CONTAINS );
        filter1.setValue( getTestDomain() );
        filters.add( filter1 );
        Filter filter2 = new Filter();
        filter2.setFilter( "host.port" );
        filter2.setQuality( FilterOperator.CONTAINS );
        filter2.setValue( "80" );
        filters.add( filter2 );
        options.setFilters( filters );
        options.setSearchType( FilterSearchType.AND );
        return options;
    }

    private ExtendedFilteringOptions GetExtendedFilteringOptions() throws Exception {
        ExtendedFilteringOptions options = new ExtendedFilteringOptions();
        options.setAge( 10 );
        options.setAuthenticated( true );
        options.setDateRange( 3 );
        options.setExploitable( true );
        List<Filter> filters = new ArrayList<>();
        Filter filter1 = new Filter();
        filter1.setFilter( "host.hostname" );
        filter1.setQuality( FilterOperator.CONTAINS );
        filter1.setValue( getTestDomain() );
        filters.add( filter1 );
        Filter filter2 = new Filter();
        filter2.setFilter( "host.port" );
        filter2.setQuality( FilterOperator.CONTAINS );
        filter2.setValue( "80" );
        filters.add( filter2 );
        options.setFilters( filters );
        options.setSearchType( FilterSearchType.AND );
        options.setResolvable( false );
        options.setSeverity( SeverityLevel.HIGH );
        return options;
    }

    private int getPluginId() throws Exception {
        List<PluginFamily> pluginFamilies = apiClient.getPluginsApi().families();
        PluginFamilyDetail familyDetails = apiClient.getPluginsApi().familyDetails( pluginFamilies.get( 0 ).getId() );
        PluginDetail pluginDetails = apiClient.getPluginsApi().pluginDetails( familyDetails.getPlugins().get( 0 ).getId() );
        return pluginDetails.getId();
    }

}
