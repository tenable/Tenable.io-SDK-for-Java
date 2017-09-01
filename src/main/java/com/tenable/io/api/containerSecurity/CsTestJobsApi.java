package com.tenable.io.api.containerSecurity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.containerSecurity.models.CsTestJob;
import com.tenable.io.api.containerSecurity.models.CsTestJobImage;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsTestJobsApi extends ApiWrapperBase {

    /**
     * The Test jobs url.
     */
    protected final String testJobsUrl = "/jobs";

    /**
     * Instantiates a new Container security test jobs api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public CsTestJobsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Gets status by test job id.
     *
     * @param jobId the test job id
     * @return the test job status
     * @throws TenableIoException the tenable io exception
     */
    public CsTestJob getStatusByJobId( String jobId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + testJobsUrl + "/status" )
                .addParameter( "job_id", jobId ).build() );
        return httpFuture.getAsType( new TypeReference<CsTestJob>() {} );
    }

    /**
     * Gets status by docker image id.
     *
     * @param imageId the image id
     * @return the test job status including image digest
     * @throws TenableIoException the tenable io exception
     */
    public CsTestJobImage getStatusByDockerImageId( String imageId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + testJobsUrl + "/image_status" )
                .addParameter( "image_id", imageId ).build() );
        return httpFuture.getAsType( new TypeReference<CsTestJobImage>() {} );
    }

    /**
     * Gets status by docker image digest.
     *
     * @param digest the image digest
     * @return the test job status including image digest
     * @throws TenableIoException the tenable io exception
     */
    public CsTestJobImage getStatusByDockerImageDigest( String digest ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + testJobsUrl + "/image_status_digest" )
                .addParameter( "image_digest", digest ).build() );
        return httpFuture.getAsType( new TypeReference<CsTestJobImage>() {} );
    }

    /**
     * Gets list of all test jobs.
     *
     * @return the list of test jobs
     * @throws TenableIoException the tenable io exception
     */
    public List<CsTestJob> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + testJobsUrl + "/list" ).build() );
        return httpFuture.getAsType( new TypeReference<List<CsTestJob>>() {} );
    }
}
