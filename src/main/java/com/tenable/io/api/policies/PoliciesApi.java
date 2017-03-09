package com.tenable.io.api.policies;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.policies.models.Policy;
import com.tenable.io.api.policies.models.PolicyCreateResponse;
import com.tenable.io.api.policies.models.PolicyDetail;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.io.File;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class PoliciesApi extends ApiWrapperBase {

    /**
     * Instantiates a new Policies api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public PoliciesApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * List list.
     *
     * @return the list
     * @throws TenableIoException the tenable IO exception
     */
    public List<Policy> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/policies" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Policy>>() {}, "policies" );
    }


    /**
     * Copy a policy.
     *
     * @param policyId The id of the policy to copy.
     * @return the policy
     * @throws TenableIoException the tenable IO exception
     */
    public Policy copy( int policyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/policies/" + policyId +
                "/copy" ).build(), new CopyRequest() );
        return httpFuture.getAsType( Policy.class );
    }


    /**
     * Delete a policy
     *
     * @param policyId the policy id
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int policyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/policies/" + policyId ).build() );
        httpFuture.get();
    }


    /**
     * Creates a policy
     *
     * @param createRequest the create request
     * @return the policy create response
     * @throws TenableIoException the tenable IO exception
     */
    public PolicyCreateResponse create( PolicyDetail createRequest ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/policies" ).build(), createRequest );
        return httpFuture.getAsType( PolicyCreateResponse.class );
    }


    /**
     * Return details for the given policy
     *
     * @param policyId the policy id
     * @return the policy detail
     * @throws TenableIoException the tenable IO exception
     */
    public PolicyDetail details( int policyId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/policies/" + policyId ).build() );
        return httpFuture.getAsType( PolicyDetail.class );
    }


    /**
     * Changes the parameters of a policy.
     *
     * @param policyId the policy id to change
     * @param detail   the change parameters object
     * @throws TenableIoException the tenable IO exception
     */
    public void configure( int policyId, PolicyDetail detail ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/policies/" +
                policyId ).build(), detail );
        httpFuture.get();
    }


    /**
     * Import an existing policy uploaded using file: upload
     *
     * @param file The name of the file to import as provided by the response from file: upload.
     * @return the imported policy
     * @throws TenableIoException the tenable IO exception
     */
    public Policy importPolicy( String file ) throws TenableIoException {
        ImportRequest request = new ImportRequest().withFile( file );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/policies/import" ).build(), request );
        return httpFuture.getAsType( Policy.class );
    }


    /**
     * Export the given policy.
     *
     * @param policyId        the id of the policy to export
     * @param destinationFile the destination file
     * @throws TenableIoException the tenable IO exception
     */
    public void export( int policyId, File destinationFile ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGetDownload( createBaseUriBuilder( "/policies/" + policyId +
                "/export" ).build(), destinationFile );
        httpFuture.get();
    }


    private class ImportRequest {
        private String file;


        /**
         * Gets file.
         *
         * @return the file
         */
        public String getFile() {
            return file;
        }


        /**
         * Sets file.
         *
         * @param file the file
         */
        public void setFile( String file ) {
            this.file = file;
        }


        /**
         * Sets file.
         *
         * @param file the file
         */
        public ImportRequest withFile( String file ) {
            this.file = file;
            return this;
        }
    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class CopyRequest {
        private String value;


        /**
         * Gets value.
         *
         * @return the value
         */
        public String getValue() {
            return value;
        }


        /**
         * Sets value.
         *
         * @param value the value
         */
        public void setValue( String value ) {
            this.value = value;
        }


        /**
         * Sets value.
         *
         * @param value the value
         */
        public CopyRequest withValue( String value ) {
            this.value = value;
            return this;
        }
    }

}
