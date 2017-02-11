package com.tenable.io.examples;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.TestBase;
import com.tenable.io.api.scans.models.Vulnerability;
import com.tenable.io.api.workbenches.models.VulnerabilityAsset;
import com.tenable.io.api.workbenches.models.VulnerabilityOutput;
import org.junit.Test;

import java.io.File;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchWorkflowsExamples extends TestBase {

    @Test
    public void testWorkbenchWorkflows() throws Exception {
        TenableIoClient client = new TenableIoClient();

        // Can get all assets with 0 or more vuln(s) bound by date up to today
        List<VulnerabilityAsset> assets =  client.getWorkbenchHelper().getAllRecentAssetsWithVulns( 100 );

        // Can get all vulns associated with 0 or more asset(s) bound by date up to today
        List<Vulnerability> vulns =  client.getWorkbenchHelper().getAllRecentVulnerabilities( 100 );

        // Can get all assets with the given vuln bound by date up to today.
        List<VulnerabilityOutput> assetsForVuln = client.getWorkbenchHelper().getAllRecentAssetsByVuln( vulns.get( 0 ).getPluginId(), 100 );

        // Can get all vulns associated with the given asset bound by date up to today.
        List<Vulnerability> vulnsByAsset = client.getWorkbenchHelper().getAllRecentVulnerabilitiesByAsset( assetsForVuln.get( 0 ).getAssets().get( 0 ).getId(), 100  );

        // export workbench to file
        File file = new File( "src/test/resources/workbench.xml" );
        client.getWorkbenchHelper().exportToFile( file, 100 );


    }
}
