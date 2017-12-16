package com.tenable.io.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenable.io.api.assetImport.models.Asset;
import com.tenable.io.api.assetImport.models.AssetImportJob;
import com.tenable.io.api.assetImport.models.AssetImportRequest;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetImportApiClientTest extends TestBase {
    private TenableIoClient apiClient = new TenableIoClient();
    private String path = "src/test/resources/mock_assets.json";

     @Test
    public void importAssetsTest() throws Exception {
        // import json from file
        ObjectMapper mapper = new ObjectMapper();
        AssetImportRequest assetImportRequest = mapper.readValue( new File( path ), AssetImportRequest.class );
        String importJob = apiClient.getAssetImportApi().importAssets( assetImportRequest );

        assertNotNull(importJob);
    }

    @Test
    public void importJobsTest() throws Exception {
        List<AssetImportJob> importJobs = apiClient.getAssetImportApi().getAssetImportJobs();

        assertNotNull(importJobs);
        for (AssetImportJob job : importJobs) {
            assertImportJobFields( job );
        }

        // Retreive asset import job by job id
        if ( importJobs.size() > 0 ) {
            AssetImportJob importJob = apiClient.getAssetImportApi().getAssetImportJob( importJobs.get( 0 ).getJobId() );

            assertNotNull( importJob );
            assertImportJobFields( importJob );
        }
    }

    @Test
    public void assetsTest() throws Exception {
        List<Asset> assets = apiClient.getAssetImportApi().getAssets();

        assertNotNull( assets );
        for ( Asset asset : assets ) {
            assertAssetFields( asset );
        }

        // Retrieve single asset by id
        if ( assets.size() > 0 ) {
            Asset asset = apiClient.getAssetImportApi().getAsset( assets.get(0).getId() );

            assertNotNull( asset );
            assertAssetFields( asset );
        }
    }

    private void assertAssetFields( Asset asset ) {
        assertNotNull( asset.getId() );
        assertNotNull( asset.getHasAgent() );
        assertNotNull( asset.getLastSeen() );
        assertNotNull( asset.getIpv4() );
        assertNotNull( asset.getFqdn() );
        assertNotNull( asset.getOperatingSystem() );
        assertNotNull( asset.getSources() );
    }

    private void assertImportJobFields( AssetImportJob job ) {
        assertNotNull( job.getJobId() );
        assertNotNull( job.getContainerId() );
        assertNotNull( job.getSource() );
        assertNotNull( job.getBatches() );
        assertNotNull( job.getUploadedAssets() );
        assertNotNull( job.getFailedAssets() );
        assertNotNull( job.getLastUpdateTime() );
        assertNotNull( job.getStatus() );
        assertNotNull( job.getStartTime() );
        assertNotNull( job.getEndTime() );
    }
}
