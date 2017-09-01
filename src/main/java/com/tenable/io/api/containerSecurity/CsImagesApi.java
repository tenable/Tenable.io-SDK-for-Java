package com.tenable.io.api.containerSecurity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.containerSecurity.models.CsContainerImage;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsImagesApi extends ApiWrapperBase {
    /**
     * The Images url.
     */
    private final String imagesUrl = "/container";

    /**
     * Instantiates a new Container security images api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme the api scheme
     * @param ApiHost the api host
     */
    public CsImagesApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Gets the list of container images.
     *
     * @return the list of container images
     * @throws TenableIoException the tenable io exception
     */
    public List<CsContainerImage> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( containerSecurityBaseUrl + imagesUrl + "/list" ).build() );
        return httpFuture.getAsType( new TypeReference<List<CsContainerImage>>() {} );
    }

    /**
     * Delete a container image.
     *
     * @param repositoryName the repository name
     * @param hash the hash of the image
     * @throws TenableIoException the tenable io exception
     */
    public void delete( String repositoryName, String hash ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( containerSecurityBaseUrl + imagesUrl + "/" + repositoryName + "/manifests/" + hash ).build() );
        httpFuture.get();
    }
    
}

