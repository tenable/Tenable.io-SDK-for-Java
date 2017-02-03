package com.tenable.io.api.agents;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.agents.models.Agent;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentsApi extends ApiWrapperBase {
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
     * Returns the agent list for the given scanner
     *
     * @param scannerId The id of the scanner to query for agents
     * @return the agent list for the given scanner
     * @throws TenableIoException the tenable IO exception
     */
    public List<Agent> list( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId + "/agents" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Agent>>() {
        }, "agents" );
    }


    /**
     * Deletes an agent
     *
     * @param scannerId The id of the scanner
     * @param agentId   The id of the agent to delete
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int scannerId, int agentId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanners/" + scannerId + "/agents/" + agentId ).build() );
        httpFuture.get();
    }
}
