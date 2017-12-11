package com.tenable.io.api.filters;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.agents.models.AgentFilterOptions;
import com.tenable.io.api.editors.models.Filter;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FiltersApi extends ApiWrapperBase {

    /**
     * Instantiates a new Filters api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public FiltersApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the filters available for the Vulnerabilities Workbench
     *
     * @return the filters available for the Vulnerabilities Workbench
     * @throws TenableIoException the tenable IO exception
     */
    public List<Filter> workbenchesVulnerabilities() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/filters/workbenches/vulnerabilities" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Filter>>() {}, "filters" );
    }

    /**
     * Agent filter options agent filter options.
     *
     * @return the agent filter options
     * @throws TenableIoException the tenable io exception
     */
    public AgentFilterOptions agentFilterOptions() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/filters/scans/agents" ).build() );
        return httpFuture.getAsType( AgentFilterOptions.class );
    }
}
