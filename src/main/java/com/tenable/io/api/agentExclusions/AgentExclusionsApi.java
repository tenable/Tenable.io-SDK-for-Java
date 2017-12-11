package com.tenable.io.api.agentExclusions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.agentExclusions.models.Exclusion;
import com.tenable.io.api.scans.models.Schedule;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.net.URI;
import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentExclusionsApi extends ApiWrapperBase {
    /**
     * Instantiates a new Agent exclusions api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public AgentExclusionsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }

    /**
     * Create exclusion.
     *
     * @param scannerId the scanner id
     * @param name      the name
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion create( int scannerId, String name ) throws TenableIoException {
        return create( scannerId, name, null, null);
    }

    /**
     * Create exclusion.
     *
     * @param scannerId   the scanner id
     * @param name        the name
     * @param description the description
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion create( int scannerId, String name, String description ) throws TenableIoException {
        return create( scannerId, name, description, null);
    }

    /**
     * Create exclusion.
     *
     * @param scannerId   the scanner id
     * @param name        the name
     * @param description the description
     * @param schedule    the schedule
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion create( int scannerId, String name, String description, Schedule schedule ) throws TenableIoException {
        AgentExclusionRequest request = new AgentExclusionRequest( name ).withDescription( description ).withSchedule( schedule );
        HttpFuture httpFuture = asyncHttpService.doPost( getUri( scannerId ), request );
        return httpFuture.getAsType( Exclusion.class );
    }

    /**
     * Delete.
     *
     * @param scannerId   the scanner id
     * @param exclusionId the exclusion id
     * @throws TenableIoException the tenable io exception
     */
    public void delete( int scannerId, int exclusionId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( getExclusionIdURI( scannerId, exclusionId ) );
        httpFuture.get();
    }

    /**
     * List list.
     *
     * @param scannerId the scanner id
     * @return the list
     * @throws TenableIoException the tenable io exception
     */
    public List<Exclusion> list( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( getUri( scannerId ) );
        return httpFuture.getAsType( new TypeReference<List<Exclusion>>() {}, "exclusions" );
    }

    /**
     * Details exclusion.
     *
     * @param scannerId   the scanner id
     * @param exclusionId the exclusion id
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion details( int scannerId, int exclusionId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( getExclusionIdURI( scannerId, exclusionId ) );
        return httpFuture.getAsType( Exclusion.class );
    }

    /**
     * Edit exclusion.
     *
     * @param scannerId   the scanner id
     * @param exclusionId the exclusion id
     * @param name        the name
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion edit( int scannerId, int exclusionId, String name ) throws TenableIoException {
        return edit( scannerId, exclusionId, name, null, null );
    }

    /**
     * Edit exclusion.
     *
     * @param scannerId   the scanner id
     * @param exclusionId the exclusion id
     * @param name        the name
     * @param description the description
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion edit( int scannerId, int exclusionId, String name, String description ) throws TenableIoException {
        return edit( scannerId, exclusionId, name, description, null );
    }

    /**
     * Edit exclusion.
     *
     * @param scannerId   the scanner id
     * @param exclusionId the exclusion id
     * @param name        the name
     * @param description the description
     * @param schedule    the schedule
     * @return the exclusion
     * @throws TenableIoException the tenable io exception
     */
    public Exclusion edit( int scannerId, int exclusionId, String name, String description, Schedule schedule ) throws TenableIoException {
        AgentExclusionRequest request = new AgentExclusionRequest( name ).withDescription( description ).withSchedule( schedule );
        HttpFuture httpFuture = asyncHttpService.doPut( getExclusionIdURI( scannerId, exclusionId ), request );
        return httpFuture.getAsType( Exclusion.class );
    }

    private URI getExclusionIdURI( int scannerId, int exclusionId ) throws TenableIoException {
        return getUri( scannerId, "/" + exclusionId );
    }

    private URI getUri( int scannerId ) throws TenableIoException {
        return getUri( scannerId, null );
    }

    private URI getUri( int scannerId, String extra ) throws TenableIoException {
        return createBaseUriBuilder( "/scanners/" + scannerId + "/agents/exclusions" + ( extra != null ? extra : "" ) ).build();
    }

    private class AgentExclusionRequest {
        private String name;
        @JsonInclude( JsonInclude.Include.NON_NULL )
        private String description = null;
        @JsonInclude( JsonInclude.Include.NON_NULL )
        private Schedule schedule = null;

        private AgentExclusionRequest( String name ) {
            this.name = name;
        }

        private AgentExclusionRequest withDescription( String description ) {
            this.description = description;
            return this;
        }

        private AgentExclusionRequest withSchedule( Schedule schedule ) {
            this.schedule = schedule;
            return this;
        }

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

        /**
         * Gets description.
         *
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets description.
         *
         * @param description the description
         */
        public void setDescription( String description ) {
            this.description = description;
        }

        /**
         * Gets schedule.
         *
         * @return the schedule
         */
        public Schedule getSchedule() {
            return schedule;
        }

        /**
         * Sets schedule.
         *
         * @param schedule the schedule
         */
        public void setSchedule( Schedule schedule ) {
            this.schedule = schedule;
        }
    }
}
