package com.tenable.io.api.agents;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.agents.models.Agent;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentsApi extends ApiWrapperBase {
    private static int DEFAULT_SCANNER_ID = 1;


    /**
     * Instantiates a new Agents api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AgentsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Returns the agent list for the default scanner with no filtering or sorting.
     *
     * @return the list
     * @throws TenableIoException the tenable io exception
     */
    public List<Agent> list() throws TenableIoException {
        return list( DEFAULT_SCANNER_ID, new ArrayList<NameValuePair>() );
    }

    /**
     * Returns the agent list for the default scanner and accepting filtering, sorting, or limiting parameters.
     *
     * @param filtering A List of named values used for filtering, sorting, or limiting results. See https://developer.tenable.com/reference#agents
     * @return the agent list for the default scanner
     * @throws TenableIoException the tenable IO exception
     */
    public List<Agent> list( List<NameValuePair> filtering ) throws TenableIoException {
        return list( DEFAULT_SCANNER_ID, filtering );
    }


    /**
     * Returns the agent list for the given scanner and accepting filtering, sorting, or limiting parameters.
     *
     * @param scannerId The id of the scanner to query for agents
     * @param filtering A List of named values used for filtering, sorting, or limiting results. See https://developer.tenable.com/reference#agents
     * @return the agent list for the given scanner
     * @throws TenableIoException the tenable IO exception
     */
    protected List<Agent> list( int scannerId, List<org.apache.http.NameValuePair> filtering ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId + "/agents" ).addParameters( filtering ).build() );
        return httpFuture.getAsType( new TypeReference<List<Agent>>() {}, "agents" );
    }


    /**
     * Deletes an agent
     *
     * @param agentId The id of the agent to delete
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int agentId ) throws TenableIoException {
        delete( DEFAULT_SCANNER_ID, agentId );
    }


    /**
     * Deletes an agent
     *
     * @param scannerId The id of the scanner
     * @param agentId   The id of the agent to delete
     * @throws TenableIoException the tenable IO exception
     */
    protected void delete( int scannerId, int agentId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanners/" + scannerId + "/agents/" + agentId ).build() );
        httpFuture.get();
    }


    /**
     * Get agent.
     *
     * @param agentId the agent id
     * @return the agent
     * @throws TenableIoException the tenable io exception
     */
    public Agent get( int agentId ) throws TenableIoException {
        return get( DEFAULT_SCANNER_ID, agentId );
    }


    /**
     * Get agent.
     *
     * @param scannerId the scanner id
     * @param agentId   the agent id
     * @return the agent
     * @throws TenableIoException the tenable io exception
     */
    protected Agent get( int scannerId, int agentId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId + "/agents/" + agentId ).build() );
        return httpFuture.getAsType( Agent.class );
    }
}
