package com.tenable.io.api;


import com.tenable.io.api.exports.models.ExportStatus;
import com.tenable.io.api.exports.models.Status;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class ExportsApiClientTest extends TestBase {

    @Test
    public void testVulnsDownload() throws Exception {
        String exportUuid = apiClient.getExportsApi().vulnsRequestExport();
        assertNotNull( exportUuid );

        ExportStatus status = apiClient.getExportsApi().vulnsExportStatus( exportUuid );
        assertNotNull( status );

        while( !status.getStatus().equals( Status.FINISHED ) ) {
            Thread.sleep( 5000 );
            status = apiClient.getExportsApi().vulnsExportStatus( exportUuid );
        }

        for ( int id : status.getChunksAvailable() ) {
            File downloadFile = new File("src/test/resources/vulns_export_chunk" + "_" + id );
            apiClient.getExportsApi().vulnsDownloadChunk(exportUuid, id, downloadFile );
            assert( downloadFile.exists() );
        }
    }


    @Test
    public void testAssetsDownload() throws Exception {
        String exportUuid = apiClient.getExportsApi().assetsRequestExport();
        assertNotNull( exportUuid );

        ExportStatus status = apiClient.getExportsApi().assetsExportStatus( exportUuid );
        assertNotNull( status );

        while( !status.getStatus().equals( Status.FINISHED ) ) {
            Thread.sleep( 5000 );
            status = apiClient.getExportsApi().assetsExportStatus( exportUuid );
        }

        for ( int id : status.getChunksAvailable() ) {
            File downloadFile = new File("src/test/resources/assets_export_chunk" + "_" + id );
            apiClient.getExportsApi().assetsDownloadChunk( exportUuid, id, downloadFile );
            assert( downloadFile.exists() );
        }
    }
}
