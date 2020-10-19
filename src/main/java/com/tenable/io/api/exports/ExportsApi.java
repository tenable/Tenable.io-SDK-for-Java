package com.tenable.io.api.exports;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.exports.models.*;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.io.File;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class ExportsApi extends ApiWrapperBase {

    /**
     * Instantiates a new exports api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public ExportsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Export all vulnerabilities in the user's container
     *
     * @return The export uuid needed to download vuln chunks
     * @throws TenableIoException
     */
    public String vulnsRequestExport() throws TenableIoException {
        return vulnsRequestExport( new VulnsExportRequest() );
    }


    /**
     * Export all vulnerabilities in the user's container that match the request criteria.
     *
     * @param exportRequest The export request filters
     * @return the export uuid needed to download vuln chunks
     * @throws TenableIoException the tenable IO exception
     */
    public String vulnsRequestExport( VulnsExportRequest exportRequest ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/vulns/export" ).build(), exportRequest );
        return httpFuture.getAsType( String.class, "export_uuid" );
    }


    /**
     * Returns the status of the export request.
     * Chunks are processed in parallel and may not complete in order.
     *
     * @param exportUuid The uuid from the export request
     * @return VulnsExportStatus
     * @throws TenableIoException the tenable IO exception
     */
    public ExportStatus vulnsExportStatus( String exportUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/vulns/export/" + exportUuid + "/status" ).build() );
        return httpFuture.getAsType( new TypeReference<ExportStatus>() {} );
    }


    /**
     * Download vulnerability chunk by id
     *
     * @param exportUuid the export request uuid
     * @param chunkId the id of the chunk to download
     * @param destinationFile The file to download chunk to
     * @throws TenableIoException the tenable IO exception
     */
    public void vulnsDownloadChunk( String exportUuid, int chunkId, File destinationFile ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGetDownload( createBaseUriBuilder( "/vulns/export/" + exportUuid +
                "/chunks/" + chunkId ).build(), destinationFile );
        httpFuture.get();
    }


    /**
     * Retrieves a list of vulnerability export jobs.
     * This list includes the 1,000 most recent export jobs regardless of status.
     * However, this list includes completed jobs only if the job completed in the previous three days.
     *
     * @return VulnExportJobs
     * @throws TenableIoException the tenable IO exception
     */
    public ExportJobs vulnExportJobs() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/vulns/export/status" ).build() );
        return httpFuture.getAsType( new TypeReference<ExportJobs>() {} );
    }

    /**
     * Cancels the specified export job. If you cancel an export job,
     * Tenable.io finishes any chunk that is currently processing,
     * terminates the processing of any unprocessed chunks,
     * and updates the job status to CANCELLED.
     * If a cancelled job includes completed chunks,
     * you can download those chunks for three days after cancellation.
     *
     * @return CancelExport
     * @throws TenableIoException the tenable IO exception
     */
    public CancelExport cancelVulnExport(String exportUuid) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/vulns/export/" + exportUuid + "/cancel" ).build() );
        return httpFuture.getAsType( new TypeReference<CancelExport>() {} );
    }


    /**
     * Export all assets in the user's container
     *
     * @return The export request uuid needed to download asset chunks
     * @throws TenableIoException
     */
    public String assetsRequestExport() throws TenableIoException {
        return assetsRequestExport( new AssetsExportRequest() );
    }


    /**
     * Export all assets in the user's container
     *
     * @param exportRequest The request filters
     * @return The export request uuid
     * @throws TenableIoException
     */
    public String assetsRequestExport( AssetsExportRequest exportRequest ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/assets/export" ).build(), exportRequest );
        return httpFuture.getAsType( String.class, "export_uuid" );
    }


    /**
     * Returns the status of your export request.
     * Chunks are processed in serial and will complete in order.
     *
     * @param exportUuid The uuid for the export request
     * @return AssetsExportStatus
     * @throws TenableIoException the tenable IO exception
     */
    public ExportStatus assetsExportStatus(String exportUuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/assets/export/" + exportUuid + "/status" ).build() );
        return httpFuture.getAsType( new TypeReference<ExportStatus>() {} );
    }


    /**
     * Download assets chunk by id.
     * Chunks are available for download for up to 24 hours after they have been created.
     * A 404 will be returned for expired chunk
     *
     * @param exportUuid the export request uuid returned by the export request
     * @param chunkId the id of the chunk to download
     * @throws TenableIoException the tenable IO exception
     */
    public void assetsDownloadChunk( String exportUuid, int chunkId, File destinationFile ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGetDownload( createBaseUriBuilder( "/assets/export/" + exportUuid +
                "/chunks/" + chunkId ).build(), destinationFile );
        httpFuture.get();
    }
}
