package com.tenable.io.api.containerSecurity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.containerSecurity.models.CsReport;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsReportsApi extends ApiWrapperBase {

    /**
     * The Reports url.
     */
    private final String reportsUrl = "/reports";

    /**
     * Instantiates a new Container security reports api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme the api scheme
     * @param ApiHost the api host
     */
    public CsReportsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Gets report by container id.
     *
     * @param containerId the container id
     * @return the image scan's report
     * @throws TenableIoException the tenable io exception
     */
    public CsReport getReportByContainerId( String containerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + reportsUrl + "/show" )
                .addParameter( "container_id", containerId ).build() );
        return httpFuture.getAsType( new TypeReference<CsReport>() {} );
    }

    /**
     * Gets report by image id.
     *
     * @param imageId the image id
     * @return the image scan's report
     * @throws TenableIoException the tenable io exception
     */
    public CsReport getReportByImageId( String imageId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + reportsUrl + "/by_image" )
                .addParameter( "image_id", imageId ).build() );
        return httpFuture.getAsType( new TypeReference<CsReport>() {} );
    }

    /**
     * Gets report by image digest.
     *
     * @param imageDigest the image digest
     * @return the image scan's report
     * @throws TenableIoException the tenable io exception
     */
    public CsReport getReportByImageDigest( String imageDigest ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + reportsUrl + "/by_image_digest" )
                .addParameter( "image_digest", imageDigest ).build() );
        return httpFuture.getAsType( new TypeReference<CsReport>() {} );
    }

    /**
     * Gets report nessus.
     *
     * @param containerId the container id
     * @return the image scan's report nessus
     * @throws TenableIoException the tenable io exception
     */
    public String getReportNessus( String containerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + reportsUrl + "/nessus/show" )
                .addParameter( "id", containerId ).build() );
        return httpFuture.getAsString();
    }

}
