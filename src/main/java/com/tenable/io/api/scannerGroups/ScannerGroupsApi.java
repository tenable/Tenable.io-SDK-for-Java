package com.tenable.io.api.scannerGroups;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.scannerGroups.models.ScannerGroup;
import com.tenable.io.api.scannerGroups.models.ScannerGroupType;
import com.tenable.io.api.scanners.models.Scanner;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScannerGroupsApi extends ApiWrapperBase {

    /**
     * Instantiates a new Scanner groups api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public ScannerGroupsApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns a list of scanner groups within the current container.
     *
     * @return the list of scanner groups within the current container.
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScannerGroup> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanner-groups" ).build() );
        return httpFuture.getAsType( new TypeReference<List<ScannerGroup>>() {}, "scanner_pools" );
    }


    /**
     * Creates a new scanner group.
     *
     * @param name The name for the new scanner group.
     * @param type The type of scanner group.
     * @return the newly created scanner group
     * @throws TenableIoException the tenable IO exception
     */
    public ScannerGroup create( String name, ScannerGroupType type ) throws TenableIoException {
        ScannerCreateRequest request = new ScannerCreateRequest().withName( name ).withType( type );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scanner-groups" ).build(), request );
        return httpFuture.getAsType( ScannerGroup.class );
    }


    /**
     * Deletes a scanner group
     *
     * @param groupId The id of the scanner group.
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanner-groups/" + groupId ).build() );
        httpFuture.get();
    }


    /**
     * Returns details for the given scanner group.
     *
     * @param groupId The id of the scanner group
     * @return the scanner group
     * @throws TenableIoException the tenable IO exception
     */
    public ScannerGroup details( int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanner-groups/" + groupId ).build() );
        return httpFuture.getAsType( ScannerGroup.class );
    }


    /**
     * Updates a scanner group.
     *
     * @param groupId The id of the scanner group.
     * @param name    The new name for the scanner group.
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int groupId, String name ) throws TenableIoException {
        ScannerEditRequest request = new ScannerEditRequest().withName( name );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scanner-groups/" + groupId ).build(), request );
        httpFuture.get();
    }


    /**
     * Adds a scanner to the scanner group.
     *
     * @param groupId   The id of the scanner group.
     * @param scannerId The id of the scanner to add to the scanner group.
     * @throws TenableIoException the tenable IO exception
     */
    public void addScanner( int groupId, int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scanner-groups/" + groupId + "/scanners/" + scannerId ).build(), new ScannerGroupRequest() );
        httpFuture.get();
    }


    /**
     * Remove a scanner from the scanner group.
     *
     * @param groupId   The id of the scanner group.
     * @param scannerId The id of the scanner to remove from the scanner group.
     * @throws TenableIoException the tenable IO exception
     */
    public void deleteScanner( int groupId, int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanner-groups/" + groupId + "/scanners/" + scannerId ).build() );
        httpFuture.get();
    }


    /**
     * Returns a list of scanners associated with the scanner group.
     *
     * @param groupId The id of the scanner group.
     * @return the list of scanners associated with the scanner group.
     * @throws TenableIoException the tenable IO exception
     */
    public List<Scanner> listScanners( int groupId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanner-groups/" + groupId + "/scanners" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Scanner>>() {}, "scanners" );
    }


    private class ScannerCreateRequest {
        private String name;
        private ScannerGroupType type;


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
         * Sets name.
         *
         * @param name the name
         */
        public ScannerCreateRequest withName( String name ) {
            this.name = name;
            return this;
        }


        /**
         * Gets type.
         *
         * @return the type
         */
        public ScannerGroupType getType() {
            return type;
        }


        /**
         * Sets type.
         *
         * @param type the type
         */
        public void setType( ScannerGroupType type ) {
            this.type = type;
        }


        /**
         * Sets type.
         *
         * @param type the type
         */
        public ScannerCreateRequest withType( ScannerGroupType type ) {
            this.type = type;
            return this;
        }
    }

    private class ScannerEditRequest {
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


        /**
         * Sets name.
         *
         * @param name the name
         */
        public ScannerEditRequest withName( String name ) {
            this.name = name;
            return this;
        }

    }

    @JsonInclude( JsonInclude.Include.NON_DEFAULT )
    private class ScannerGroupRequest {
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
        public ScannerGroupRequest withValue( String value ) {
            this.value = value;
            return this;
        }
    }
}
