package com.tenable.io.api.assetLists;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.assetLists.models.AssetList;
import com.tenable.io.api.assetLists.models.AssetListRequest;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetListsApi extends ApiWrapperBase {
    /**
     * Instantiates a new Asset lists api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AssetListsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the current asset lists.
     *
     * @return the current asset lists
     * @throws TenableIoException the tenable IO exception
     */
    public List<AssetList> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/asset-lists" ).build() );
        return httpFuture.getAsType( new TypeReference<List<AssetList>>() {}, "asset_lists" );
    }


    /**
     * Creates a new asset list for the current user
     *
     * @param request create request object
     * @return the asset list
     * @throws TenableIoException the tenable IO exception
     */
    public AssetList create( AssetListRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/asset-lists" ).build(), request );
        return httpFuture.getAsType( AssetList.class );
    }


    /**
     * Returns details for the given asset list.
     *
     * @param listId The id of the list.
     * @return the asset list
     * @throws TenableIoException the tenable IO exception
     */
    public AssetList details( int listId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/asset-lists/" + listId ).build() );
        return httpFuture.getAsType( AssetList.class );
    }


    /**
     * Modify an asset list.
     *
     * @param listId  The id of the list to edit.
     * @param request the edit request object
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int listId, AssetListRequest request ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/asset-lists/" +
                listId ).build(), request );
        httpFuture.get();
    }


    /**
     * Deletes an asset list
     *
     * @param listId The id of the list to delete.
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int listId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/asset-lists/" + listId ).build() );
        httpFuture.get();
    }

}
