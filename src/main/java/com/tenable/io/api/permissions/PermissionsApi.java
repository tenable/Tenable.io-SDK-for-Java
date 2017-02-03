package com.tenable.io.api.permissions;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.permissions.models.Permission;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PermissionsApi extends ApiWrapperBase {

    /**
     * Instantiates a new Permissions api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public PermissionsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the current object's permissions.
     *
     * @param objectType The type of object.
     * @param objectId   The unique id of the object.
     * @return the list of permissions for the object
     * @throws TenableIoException the tenable IO exception
     */
    public List<Permission> list( String objectType, int objectId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/permissions/" + objectType + "/" +
                objectId ).build() );
        return httpFuture.getAsType( new TypeReference<List<Permission>>() {
        }, "acls" );
    }


    /**
     * Changes the permissions for an object.
     *
     * @param objectType The type of object.
     * @param objectId   tThe unique id of the object.
     * @param acls       the new list of permissions to apply
     * @throws TenableIoException the tenable IO exception
     */
    public void change( String objectType, int objectId, List<Permission> acls ) throws TenableIoException {
        PermissionRequest request = new PermissionRequest();
        request.setAcls( acls );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/permissions/" + objectType + "/" +
                objectId ).build(), request );
        httpFuture.get();
    }


    private class PermissionRequest {
        private List<Permission> acls;


        /**
         * Gets the list of permissions.
         *
         * @return the list of permissions
         */
        public List<Permission> getAcls() {
            return acls;
        }


        /**
         * Sets the list of permissions
         *
         * @param acls the list of permissions
         */
        public void setAcls( List<Permission> acls ) {
            this.acls = acls;
        }
    }
}
