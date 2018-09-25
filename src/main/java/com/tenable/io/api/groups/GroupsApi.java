package com.tenable.io.api.groups;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.groups.models.Group;
import com.tenable.io.api.users.models.User;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class GroupsApi extends ApiWrapperBase {

    /**
     * Instantiates a new Groups api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public GroupsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the group list
     *
     * @return the group list
     * @throws TenableIoException the tenable IO exception
     */
    public List<Group> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/groups" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Group>>() {}, "groups" );
    }


    /**
     * Create a group.
     *
     * @param name the name of the group
     * @throws TenableIoException the tenable IO exception
     */
    public Group create( String name ) throws TenableIoException {
        GroupRequest request = new GroupRequest();
        request.setName( name );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/groups" ).build(), request );
        return httpFuture.getAsType( Group.class );
    }


    /**
     * Delete a group.
     *
     * @param groupId the unique id of the group
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/groups/" + groupId ).build() );
        httpFuture.get();
    }


    /**
     * Add a user to the group.
     *
     * @param groupId the group id
     * @param userId  the user id
     * @throws TenableIoException the tenable IO exception
     */
    public void addUserToGroup( int groupId, int userId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/groups/" + groupId + "/users/" + userId ).build(), new GroupRequest() );
        httpFuture.get();
    }


    /**
     * Return the group user list.
     *
     * @param groupId the group id
     * @return the group user list
     * @throws TenableIoException the tenable IO exception
     */
    public List<User> listUsers( int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/groups/" + groupId + "/users" ).build() );
        return httpFuture.getAsType( new TypeReference<List<User>>() {}, "users" );
    }


    /**
     * Deletes a user from the group
     *
     * @param groupId the group id
     * @param userId  the user id
     * @throws TenableIoException the tenable IO exception
     */
    public void removeUserFromGroup( int groupId, int userId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/groups/" + groupId + "/users/" + userId ).build() );
        httpFuture.get();
    }


    /**
     * Edit a group.
     *
     * @param groupId the group id
     * @param name    the name of the group
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int groupId, String name ) throws TenableIoException {
        GroupRequest request = new GroupRequest().withName( name );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/groups/" + groupId ).build(), request );
        httpFuture.get();
    }


    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class GroupRequest {
        private String name;


        /**
         * Gets the name of the group.
         *
         * @return the name of the group.
         */
        public String getName() {
            return name;
        }


        /**
         * Sets the name of the group.
         *
         * @param name the name of the group.
         */
        public void setName( String name ) {
            this.name = name;
        }


        /**
         * Sets the name of the group.
         *
         * @param name the name of the group.
         */
        public GroupRequest withName( String name ) {
            this.name = name;
            return this;
        }
    }

}
