package com.tenable.io.examples;


import com.tenable.io.api.TenableIoClient;
import com.tenable.io.api.TestBase;
import com.tenable.io.api.models.AssetVulnerabilities;
import com.tenable.io.api.models.Vulnerability;
import com.tenable.io.api.workbenches.ParseWorkbenchByAsset;
import com.tenable.io.api.workbenches.ParseWorkbenchByVulnerability;
import org.junit.Test;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WorkbenchWorkflowsExamples extends TestBase {

    @Test
    public void testWorkbenchWorkflows() throws Exception {
        TenableIoClient client = new TenableIoClient();

        AssetVulnerabilities assetVulnerabilities = null;

        // Can get all assets bound by date up to today
        List<AssetVulnerabilities> assetPage;
        try( ParseWorkbenchByAsset assetParser = client.getWorkbenchHelper().getAllRecentAssetsWithVulns( 100,10 ) ) {
            do {
                assetPage = assetParser.getNextAssetPage();

                // save first asset for next calls **** only used for testing ****
                if( assetVulnerabilities == null && assetPage != null && assetPage.size() > 0 )
                    assetVulnerabilities = assetPage.get( 0 );

            } while( assetPage != null && assetPage.size() > 0 );
        }

        // Can get all assets with the given vuln bound by date up to today.
        try( ParseWorkbenchByAsset assetParser = client.getWorkbenchHelper().getAllRecentAssetsByVuln( assetVulnerabilities.getVulnerabilities().get( 0 ).getPluginID(),100,10 ) ) {
            do {
                assetPage = assetParser.getNextAssetPage();
            } while( assetPage != null && assetPage.size() > 0 );
        }

        // Can get all vulns bound by date up to today
        List<Vulnerability> vulnPage;
        try( ParseWorkbenchByVulnerability vulnParser = client.getWorkbenchHelper().getAllRecentVulnerabilities(  100, 10 ) ) {
            do {
                vulnPage = vulnParser.getNextVulnerabilitiesPage();
            } while( vulnPage != null && vulnPage.size() > 0 );
        }

        // Can get all vulns associated with the given asset bound by date up to today.
        try( ParseWorkbenchByVulnerability vulnParser = client.getWorkbenchHelper().getAllRecentVulnerabilitiesByAsset( assetVulnerabilities.getAsset().getHostName(), 100, 10 ) ) {
            do {
                vulnPage = vulnParser.getNextVulnerabilitiesPage();
            } while( vulnPage != null && vulnPage.size() > 0 );
        }
    }
}
