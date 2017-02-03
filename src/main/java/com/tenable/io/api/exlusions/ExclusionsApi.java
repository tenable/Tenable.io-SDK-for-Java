package com.tenable.io.api.exlusions;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.exlusions.models.Exclusion;
import com.tenable.io.api.exlusions.models.ExclusionRequest;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ExclusionsApi extends ApiWrapperBase {

    /**
     * Instantiates a new Exclusions api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public ExclusionsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the current exclusions.
     *
     * @return the current exclusions.
     * @throws TenableIoException the tenable IO exception
     */
    public List<Exclusion> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/exclusions" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Exclusion>>() {
        }, "exclusions" );
    }


    /**
     * Creates a new exclusion.
     *
     * @param request the create request object
     * @return the exclusion
     * @throws TenableIoException the tenable IO exception
     */
    public Exclusion create( ExclusionRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/exclusions" ).build(), request );
        return httpFuture.getAsType( Exclusion.class );
    }


    /**
     * Returns details for the given exclusion.
     *
     * @param listId the id of the exclusion.
     * @return the exclusion
     * @throws TenableIoException the tenable IO exception
     */
    public Exclusion details( int listId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/exclusions/" + listId ).build() );
        return httpFuture.getAsType( Exclusion.class );
    }


    /**
     * Deletes an exclusion.
     *
     * @param listId the id of the exclusion to delete.
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int listId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/exclusions/" + listId ).build() );
        httpFuture.get();
    }


    /**
     * Modify an exclusion.
     *
     * @param listId  The id of the exclusion to delete.
     * @param request the edit request object
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int listId, ExclusionRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/exclusions/" +
                listId ).build(), request );
        httpFuture.get();
    }

}
