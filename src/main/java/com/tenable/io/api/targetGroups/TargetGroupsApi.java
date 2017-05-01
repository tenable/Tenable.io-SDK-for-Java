package com.tenable.io.api.targetGroups;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.targetGroups.models.TargetGroup;
import com.tenable.io.api.targetGroups.models.TargetGroupRequest;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TargetGroupsApi extends ApiWrapperBase {
    /**
     * Instantiates a new TargetGroup api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public TargetGroupsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the current TargetGroups.
     *
     * @return the current TargetGroups
     * @throws TenableIoException the tenable IO exception
     */
    public List<TargetGroup> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/target-groups" ).build() );
        return httpFuture.getAsType( new TypeReference<List<TargetGroup>>() {}, "target_groups" );
    }


    /**
     * Creates a new TargetGroup for the current user
     *
     * @param request create request object
     * @return the TargetGroup
     * @throws TenableIoException the tenable IO exception
     */
    public TargetGroup create( TargetGroupRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/target-groups" ).build(), request );
        return httpFuture.getAsType( TargetGroup.class );
    }


    /**
     * Returns details for the given TargetGroup.
     *
     * @param listId The id of the TargetGroup.
     * @return the TargetGroup
     * @throws TenableIoException the tenable IO exception
     */
    public TargetGroup details( int listId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/target-groups/" + listId ).build() );
        return httpFuture.getAsType( TargetGroup.class );
    }


    /**
     * Modify an TargetGroup.
     *
     * @param listId  The id of the TargetGroup to edit.
     * @param request the edit request object
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int listId, TargetGroupRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/target-groups/" +
                listId ).build(), request );
        httpFuture.get();
    }


    /**
     * Deletes an TargetGroup
     *
     * @param listId The id of the TargetGroup to delete.
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int listId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/target-groups/" + listId ).build() );
        httpFuture.get();
    }

}
