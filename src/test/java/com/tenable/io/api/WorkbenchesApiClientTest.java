package com.tenable.io.api;


import com.tenable.io.api.plugins.models.PluginDetail;
import com.tenable.io.api.plugins.models.PluginFamily;
import com.tenable.io.api.plugins.models.PluginFamilyDetail;
import com.tenable.io.api.scans.models.Vulnerability;

import com.tenable.io.api.workbenches.models.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchesApiClientTest extends TestBase {

    @Test
    public void testVulnerabilities() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        List<Vulnerability> result = apiClient.getWorkbenchesApi().vulnerabilities( GetOptions() );
        assertNotNull( result );
        //TODO: server return no results. need to test to results

        //TODO throws 404 not found since no vulnerability is found
        //VulnerabilityInfo info = apiClient.getWorkbenchesApi().vulnerabilityInfo(getPluginId(), options);
        //assertNotNull(info);

        //TODO returns empty
        List<VulnerabilityOutputResult> items = apiClient.getWorkbenchesApi().vulnerabilityOutput( getPluginId(), GetOptions() );
        assertNotNull( items );
    }


    @Test
    public void testAssets() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();

        //TODO: returns not allowed 405
        //List<VulnerabilityAsset> assets = apiClient.getWorkbenchesApi().assets(null);
        //assertNotNull(assets);

//        List<VulnerabilityAsset> result = apiClient.getWorkbenchesApi().assetsVulnerabilities( null );
//        assertNotNull( result );

    }


    private VulnerabilityOptions GetOptions() throws Exception {
        VulnerabilityOptions options = new VulnerabilityOptions();
        options.setAge( 10 );
        options.setAuthenticated( true );
        options.setDateRange( 3 );
        options.setExploitable( true );
        List<Filter> filters = new ArrayList<>();
        Filter filter1 = new Filter();
        filter1.setFilter( "host.hostname" );
        filter1.setQuality( "match" );
        filter1.setValue( getTestDomain() );
        filters.add( filter1 );
        Filter filter2 = new Filter();
        filter2.setFilter( "host.port" );
        filter2.setQuality( "match" );
        filter2.setValue( "80" );
        filters.add( filter2 );
        options.setFilters( filters );
        options.setSearchType( "type" );
        options.setResolvable( false );
        options.setSeverity( SeverityLevel.HIGH );
        return options;
    }


    private int getPluginId() throws Exception {
        TenableIoClient apiClient = new TenableIoClient();
        List<PluginFamily> pluginFamilies = apiClient.getPluginsApi().families();
        PluginFamilyDetail familyDetails = apiClient.getPluginsApi().familyDetails( pluginFamilies.get( 0 ).getId() );
        PluginDetail pluginDetails = apiClient.getPluginsApi().pluginDetails( familyDetails.getPlugins().get( 0 ).getId() );
        return pluginDetails.getId();
    }

}
