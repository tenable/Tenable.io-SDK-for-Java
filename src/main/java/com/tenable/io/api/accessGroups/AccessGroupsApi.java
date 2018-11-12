package com.tenable.io.api.accessGroups;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.accessGroups.models.AccessGroup;
import com.tenable.io.api.accessGroups.models.AccessGroupFilters;
import com.tenable.io.api.accessGroups.models.AccessGroupListResponse;
import com.tenable.io.api.accessGroups.models.AccessGroupRequest;
import com.tenable.io.api.editors.models.Filter;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AccessGroupsApi extends ApiWrapperBase{

    /**
     * Instantiates a new Access Groups api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AccessGroupsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Creates a new access group.
     *
     * @param request the AccessGroupRequest to create access group
     * @return the newly created access group
     * @throws TenableIoException the tenable IO exception
     */
    public AccessGroup createAccessGroup( AccessGroupRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/access-groups" ).build(), request );
        return httpFuture.getAsType( AccessGroup.class );
    }


    /**
     * Update an existing access group.
     *
     * @param uuid the uuid of the access group
     * @param request the AccessGroupRequest to edit access group
     * @throws TenableIoException the tenable IO exception
     */
    public AccessGroup editAccessGroup( String uuid, AccessGroupRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/access-groups/" + uuid ).build(), request );
        return httpFuture.getAsType( AccessGroup.class );
    }


    /**
     * Delete an existing access group
     *
     * @param uuid the uuid of the access group
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteAccessGroup( String uuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/access-groups/" + uuid ).build() );
        httpFuture.get();
    }


    /**
     * Returns details for the given access group
     *
     * @return the details for the given access group
     * @param uuid the uuid of the access group
     * @throws TenableIoException the tenable IO exception
     */
    public AccessGroup accessGroupDetails( String uuid ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/access-groups/" + uuid ).build() );
        return httpFuture.getAsType( AccessGroup.class );
    }


    /**
     * Returns the list of current access groups
     *
     * @return the list of access groups
     * @throws TenableIoException the tenable IO exception
     */
    public AccessGroupListResponse listAccessGroups() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/access-groups" ).build());
        return httpFuture.getAsType( AccessGroupListResponse.class );
    }


    /**
     * Returns the list of current access groups
     *
     * @return the list of access groups
     * @param params the list of path parameters as key and value pairs, possible pairs are:
     * param f: A list of class 'tenable.io-java.api.accessGroups.models.AssetGroupFilter' instances.
     * param ft: The action to apply if multiple 'f' parameters are provided. Supported values are "and" and "or".
     * param w: The search value to be applied across wildcard fields specified with the 'wf' parameter.
     * param wf: The list of fields where the search values specified in the 'w' parameter are applied.
     * param limit: the maximum number of records to be retrieved. Must be in int32 format.
     * param offset: The offset from request. Must be in int32 format.
     * param sort: A list of fields on which the results are sorted. Multiple fields must be separated by commas.
     * @throws TenableIoException the tenable IO exception
     */
    public AccessGroupListResponse listAccessGroups( List<NameValuePair> params ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/access-groups" ).addParameters( params ).build());
        return httpFuture.getAsType( AccessGroupListResponse.class );
    }


    /**
     * Returns the list of filters for access groups
     *
     * @return the list of filters
     * @throws TenableIoException the tenable IO exception
     */
    public AccessGroupFilters listFilters() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/access-groups/filters" ).build() );
        return httpFuture.getAsType( AccessGroupFilters.class );
    }


    /**
     * Returns the list of rule filters for access groups
     *
     * @return the list of rule filters
     * @throws TenableIoException the tenable IO exception
     */
    public List<Filter> listRuleFilters() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/access-groups/rules/filters" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Filter>>() {}, "rules" );
    }
}
