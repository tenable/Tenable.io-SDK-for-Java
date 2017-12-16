package com.tenable.io.api.assetImport;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.assetImport.models.Asset;
import com.tenable.io.api.assetImport.models.AssetImportJob;
import com.tenable.io.api.assetImport.models.AssetImportRequest;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;
import com.tenable.io.core.utilities.UriBuilderHelper;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetImportApi extends ApiWrapperBase {

    /**
     * Instantiates a new Asset import api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AssetImportApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Import assets string.
     *
     * @param assetImportRequest the asset import request
     * @return the string
     * @throws TenableIoException the tenable io exception
     */
    public String importAssets( AssetImportRequest assetImportRequest ) throws TenableIoException {
        UriBuilderHelper uri = createBaseUriBuilder( "/import/assets" );
        HttpFuture httpFuture = asyncHttpService.doPost( uri.build(), assetImportRequest );
        return httpFuture.getAsType( String.class, "asset_import_job_uuid" );
    }


    /**
     * Import asset jobs list.
     *
     * @return the list
     * @throws TenableIoException the tenable io exception
     */
    public List<AssetImportJob> getAssetImportJobs() throws TenableIoException {
        UriBuilderHelper uri = createBaseUriBuilder( "/import/asset-jobs" );
        HttpFuture httpFuture = asyncHttpService.doGet( uri.build() );
        return httpFuture.getAsType( new TypeReference<List<AssetImportJob>>() {}, "asset_import_jobs" );
    }


    /**
     * Gets asset import job.
     *
     * @param jobId the job id
     * @return the asset import job
     * @throws TenableIoException the tenable io exception
     */
    public AssetImportJob getAssetImportJob( String jobId ) throws TenableIoException {
        UriBuilderHelper uri = createBaseUriBuilder("/import/asset-jobs/" + jobId);
        HttpFuture httpFuture = asyncHttpService.doGet( uri.build() );
        return httpFuture.getAsType( AssetImportJob.class );
    }


    /**
     * Gets assets.
     *
     * @return the assets
     * @throws TenableIoException the tenable io exception
     */
    public List<Asset> getAssets() throws TenableIoException {
        UriBuilderHelper uri = createBaseUriBuilder( "/assets" );
        HttpFuture httpFuture = asyncHttpService.doGet( uri.build() );
        return httpFuture.getAsType( new TypeReference<List<Asset>>() {}, "assets" );
    }


    /**
     * Gets asset.
     *
     * @param id the id
     * @return the asset
     * @throws TenableIoException the tenable io exception
     */
    public Asset getAsset( String id ) throws TenableIoException {
        UriBuilderHelper uri = createBaseUriBuilder( "/assets/" + id );
        HttpFuture httpFuture = asyncHttpService.doGet( uri.build() );
        return httpFuture.getAsType( Asset.class );
    }
}
