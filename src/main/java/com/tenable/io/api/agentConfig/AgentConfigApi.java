package com.tenable.io.api.agentConfig;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.agentConfig.models.AgentConfigResponse;
import com.tenable.io.api.agentConfig.models.AutoUnlink;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.net.URI;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentConfigApi extends ApiWrapperBase {
    /**
     * Instantiates a new Agent config api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AgentConfigApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Edit agent config response.
     *
     * @param scannerId the scanner id
     * @return the agent config response
     * @throws TenableIoException the tenable io exception
     */
    public AgentConfigResponse edit( int scannerId ) throws TenableIoException {
        return edit( scannerId, null, null );
    }

    /**
     * Edit agent config response.
     *
     * @param scannerId      the scanner id
     * @param softwareUpdate the software update
     * @return the agent config response
     * @throws TenableIoException the tenable io exception
     */
    public AgentConfigResponse edit( int scannerId, Boolean softwareUpdate ) throws TenableIoException {
        return edit( scannerId, softwareUpdate, null );
    }

    /**
     * Edit agent config response.
     *
     * @param scannerId      the scanner id
     * @param softwareUpdate the software update
     * @param autoUnlink     the auto unlink
     * @return the agent config response
     * @throws TenableIoException the tenable io exception
     */
    public AgentConfigResponse edit( int scannerId, Boolean softwareUpdate, AutoUnlink autoUnlink ) throws TenableIoException {
        AgentConfigRequest request = new AgentConfigRequest().withSoftwareUpdate( softwareUpdate ).withAutoUnlink( autoUnlink );
        HttpFuture httpFuture = asyncHttpService.doPut( getAgentsConfigURI( scannerId ), request );
        return httpFuture.getAsType( AgentConfigResponse.class );
    }

    /**
     * Details agent config response.
     *
     * @param scannerId the scanner id
     * @return the agent config response
     * @throws TenableIoException the tenable io exception
     */
    public AgentConfigResponse details( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( getAgentsConfigURI( scannerId ) );
        return httpFuture.getAsType( AgentConfigResponse.class );
    }

    private URI getAgentsConfigURI( int scannerId ) throws TenableIoException {
        return createBaseUriBuilder( String.format( "/scanners/%o/agents/config", scannerId ) ).build();
    }

    private class AgentConfigRequest {
        @JsonInclude( JsonInclude.Include.NON_NULL )
        private Boolean softwareUpdate = null;
        @JsonInclude( JsonInclude.Include.NON_NULL )
        private AutoUnlink autoUnlink = null;

        /**
         * Gets software update.
         *
         * @return the software update
         */
        public Boolean getSoftwareUpdate() {
            return softwareUpdate;
        }

        /**
         * Sets software update.
         *
         * @param softwareUpdate the software update
         */
        public void setSoftwareUpdate( Boolean softwareUpdate ) {
            this.softwareUpdate = softwareUpdate;
        }

        /**
         * Gets auto unlink.
         *
         * @return the auto unlink
         */
        public AutoUnlink getAutoUnlink() {
            return autoUnlink;
        }

        /**
         * Sets auto unlink.
         *
         * @param autoUnlink the auto unlink
         */
        public void setAutoUnlink( AutoUnlink autoUnlink ) {
            this.autoUnlink = autoUnlink;
        }

        /**
         * With software update agent config request.
         *
         * @param softwareUpdate the software update
         * @return the agent config request
         */
        public AgentConfigRequest withSoftwareUpdate( boolean softwareUpdate ) {
            this.softwareUpdate = softwareUpdate;
            return this;
        }

        /**
         * With auto unlink agent config request.
         *
         * @param autoUnlink the auto unlink
         * @return the agent config request
         */
        public AgentConfigRequest withAutoUnlink( AutoUnlink autoUnlink ) {
            this.autoUnlink = autoUnlink;
            return this;
        }
    }
}
