package com.tenable.io.api.agentGroups;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.agentGroups.models.AgentGroup;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentGroupsApi extends ApiWrapperBase {
    private static int DEFAULT_SCANNER_ID = 1;


    /**
     * Instantiates a new Agent groups api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AgentGroupsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the agent groups for the default scanner.
     *
     * @return the agent groups for the default scanner
     * @throws TenableIoException the tenable IO exception
     */
    public List<AgentGroup> list() throws TenableIoException {
        return list( DEFAULT_SCANNER_ID );
    }


    /**
     * Returns the agent groups for the given scanner.
     *
     * @param scannerId The id of the scanner to query for agent groups.
     * @return the agent groups for the given scanner
     * @throws TenableIoException the tenable IO exception
     */
    protected List<AgentGroup> list( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups" ).build() );
        return httpFuture.getAsType( new TypeReference<List<AgentGroup>>() {}, "groups" );
    }


    /**
     * Returns details for the given agent group.
     *
     * @param groupId   The id of the agent group to query
     * @return details for the given agent group
     * @throws TenableIoException the tenable IO exception
     */
    public AgentGroup details( int groupId ) throws TenableIoException {
        return details( DEFAULT_SCANNER_ID, groupId );
    }


    /**
     * Returns details for the given agent group.
     *
     * @param scannerId The id of the scanner
     * @param groupId   The id of the agent group to query
     * @return details for the given agent group
     * @throws TenableIoException the tenable IO exception
     */
    protected AgentGroup details( int scannerId, int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups/" + groupId ).build() );
        return httpFuture.getAsType( AgentGroup.class );
    }


    /**
     * Deletes an agent from the given agent group.
     *
     * @param groupId   The id of the agent group.
     * @param agentId   The id of the agent to remove.
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteAgent( int groupId, int agentId ) throws TenableIoException {
        deleteAgent( DEFAULT_SCANNER_ID, groupId, agentId );
    }


    /**
     * Deletes an agent from the given agent group.
     *
     * @param scannerId The id of the scanner.
     * @param groupId   The id of the agent group.
     * @param agentId   The id of the agent to remove.
     * @throws TenableIoException the tenable IO exception
     */
    protected void deleteAgent( int scannerId, int groupId, int agentId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups/" + groupId + "/agents/" + agentId ).build() );
        httpFuture.get();
    }


    /**
     * Deletes an agent group from the default scanner.
     *
     * @param groupId   The id of the agent group to delete.
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int groupId ) throws TenableIoException {
        delete( DEFAULT_SCANNER_ID, groupId );
    }


    /**
     * Deletes an agent group from the given scanner.
     *
     * @param scannerId The id of the scanner.
     * @param groupId   The id of the agent group to delete.
     * @throws TenableIoException the tenable IO exception
     */
    protected void delete( int scannerId, int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups/" + groupId ).build() );
        httpFuture.get();
    }


    /**
     * Creates an agent group on the default scanner.
     *
     * @param name      The name of the agent group.
     * @return the agent group
     * @throws TenableIoException the tenable IO exception
     */
    public AgentGroup create( String name ) throws TenableIoException {
        return create( DEFAULT_SCANNER_ID, name );
    }


    /**
     * Creates an agent group on the given scanner.
     *
     * @param scannerId The id of the scanner to add the agent group to.
     * @param name      The name of the agent group.
     * @return the agent group
     * @throws TenableIoException the tenable IO exception
     */
    protected AgentGroup create( int scannerId, String name ) throws TenableIoException {
        CreateAgentGroupRequest request = new CreateAgentGroupRequest();
        request.setName( name );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups" ).build(), request );
        return httpFuture.getAsType( AgentGroup.class );
    }


    /**
     * Changes the name of the given agent group.
     *
     * @param groupId   The id of the agent group to change
     * @param name      The name for the agent group
     * @throws TenableIoException the tenable IO exception
     */
    public void configure( int groupId, String name ) throws TenableIoException {
        configure( DEFAULT_SCANNER_ID, groupId, name );
    }


    /**
     * Changes the name of the given agent group.
     *
     * @param scannerId The id of the scanner.
     * @param groupId   The id of the agent group to change
     * @param name      The name for the agent group
     * @throws TenableIoException the tenable IO exception
     */
    protected void configure( int scannerId, int groupId, String name ) throws TenableIoException {
        ConfigureAgentGroupRequest request = new ConfigureAgentGroupRequest();
        request.setName( name );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups/" + groupId ).build(), request );
        httpFuture.get();
    }


    /**
     * Adds an agent to the given agent group
     *
     * @param groupId   The id of the agent group
     * @param agentId   The id of the agent to add
     * @throws TenableIoException the tenable IO exception
     */
    public void addAgent( int groupId, int agentId ) throws TenableIoException {
        addAgent( DEFAULT_SCANNER_ID, groupId, agentId );
    }


    /**
     * Adds an agent to the given agent group
     *
     * @param scannerId The id of the scanner
     * @param groupId   The id of the agent group
     * @param agentId   The id of the agent to add
     * @throws TenableIoException the tenable IO exception
     */
    protected void addAgent( int scannerId, int groupId, int agentId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scanners/" + scannerId +
                "/agent-groups/" + groupId + "/agents/" + agentId ).build(), null );
        httpFuture.get();
    }


    private class CreateAgentGroupRequest {
        private String name;


        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }


        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName( String name ) {
            this.name = name;
        }
    }

    private class ConfigureAgentGroupRequest {
        private String name;


        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }


        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName( String name ) {
            this.name = name;
        }
    }

}
