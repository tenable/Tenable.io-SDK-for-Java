package com.tenable.io.api.folders;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.folders.models.Folder;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FoldersApi extends ApiWrapperBase {

    /**
     * Instantiates a new Folders api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public FoldersApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the current user's scan folders.
     *
     * @return the current user's scan folders.
     * @throws TenableIoException the tenable IO exception
     */
    public List<Folder> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/folders" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Folder>>() {}, "folders" );
    }


    /**
     * Creates a new folder for the current user.
     *
     * @param name The name of the folder.
     * @return the new folder id
     * @throws TenableIoException the tenable IO exception
     */
    public int create( String name ) throws TenableIoException {
        FolderRequest request = new FolderRequest();
        request.setName( name );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/folders" ).build(), request );
        return httpFuture.getAsType( int.class, "id" );
    }


    /**
     * Deletes a folder.
     *
     * @param folderId the folder id
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int folderId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/folders/" + folderId ).build() );
        httpFuture.get();
    }


    /**
     * Rename a folder for the current user.
     *
     * @param folderId the folder id
     * @param name     the name of the folder
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int folderId, String name ) throws TenableIoException {
        FolderRequest request = new FolderRequest();
        request.setName( name );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/folders/" + folderId ).build(), request );
        httpFuture.get();
    }


    private class FolderRequest {
        private String name;


        /**
         * Gets the folder name.
         *
         * @return the name of the folder
         */
        public String getName() {
            return name;
        }


        /**
         * Sets the folder name.
         *
         * @param name the folder name
         */
        public void setName( String name ) {
            this.name = name;
        }
    }

}
