package com.tenable.io.api.server;


import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.server.models.ServerProperties;
import com.tenable.io.api.server.models.ServerStatus;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerApi extends ApiWrapperBase {
    /**
     * Instantiates a new Server api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public ServerApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the server status.
     *
     * @return Returns the server status (loading, ready, corrupt-db, feed-expired, eval-expired, locked, register,
     * register-locked, download-failed, feed-error).
     * @throws TenableIoException the tenable IO exception
     */
    public ServerStatus status() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/server/status" ).build() );
        return httpFuture.getAsType( ServerStatus.class );
    }


    /**
     * Returns the server version and other properties.
     *
     * @return the server properties
     * @throws TenableIoException the tenable IO exception
     */
    public ServerProperties properties() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/server/properties" ).build() );
        return httpFuture.getAsType( ServerProperties.class );
    }

}
