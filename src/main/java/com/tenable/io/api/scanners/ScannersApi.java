package com.tenable.io.api.scanners;


import com.fasterxml.jackson.core.type.TypeReference;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.api.scanners.models.AWSTarget;
import com.tenable.io.api.scanners.models.ScanDetail;
import com.tenable.io.api.scanners.models.Scanner;
import com.tenable.io.api.scanners.models.ScannerEditSettings;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ScannersApi extends ApiWrapperBase {

    /**
     * Instantiates a new Scanners api.
     *
     * @param asyncHttpService the async http service
     * @param apiScheme        the api scheme
     * @param ApiHost          the api host
     */
    public ScannersApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Returns the scanner list.
     *
     * @return the list
     * @throws TenableIoException the tenable IO exception
     */
    public List<Scanner> list() throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners" ).build() );
        return httpFuture.getAsType( new TypeReference<List<Scanner>>() {
        }, "scanners" );
    }


    /**
     * Returns details for the given scanner.
     *
     * @param scannerId the scanner id
     * @return the scanner
     * @throws TenableIoException the tenable IO exception
     */
    public Scanner details( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId ).build() );
        return httpFuture.getAsType( Scanner.class );
    }


    /**
     * Edit the scanner identified by scannerId'
     *
     * @param scannerId the scanner id
     * @param settings  the settings to edit on the scanner
     * @throws TenableIoException the tenable IO exception
     */
    public void edit( int scannerId, ScannerEditSettings settings ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/scanners/" +
                scannerId ).build(), settings );
        httpFuture.get();
    }


    /**
     * Deletes a scanner from the manager or container. This unlinks a remote scanner.
     *
     * @param scannerId the scanner id
     * @throws TenableIoException the tenable IO exception
     */
    public void delete( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doDelete( createBaseUriBuilder( "/scanners/" + scannerId ).build() );
        httpFuture.get();
    }


    /**
     * Returns a list of AWS scan targets if the requested scanner is an Amazon Web Services scanner.
     *
     * @param scannerId the scanner id
     * @return the aws target
     * @throws TenableIoException the tenable IO exception
     */
    public AWSTarget getAWSTarget( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId +
                "/aws-targets" ).build() );
        return httpFuture.getAsType( AWSTarget.class );
    }


    /**
     * Returns the key of the requested scanner.
     *
     * @param scannerId the scanner id
     * @return the scanner key
     * @throws TenableIoException the tenable IO exception
     */
    public String getScannerKey( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId +
                "/key" ).build() );
        return httpFuture.getAsType( String.class, "key" );
    }


    /**
     * Returns a list of scans running on the requested scanner.
     *
     * @param scannerId the scanner id
     * @return the scans
     * @throws TenableIoException the tenable IO exception
     */
    public List<ScanDetail> getScans( int scannerId ) throws TenableIoException {
        HttpFuture httpFuture = asyncHttpService.doGet( createBaseUriBuilder( "/scanners/" + scannerId +
                "/scans" ).build() );
        return httpFuture.getAsType( new TypeReference<List<ScanDetail>>() {
        }, "scans" );
    }


    /**
     * Allows control of scans that are currently running on a scanner.
     *
     * @param scannerId the scanner id
     * @param scanUuid  the scan uuid
     * @param action    An action to perform on a scan. Valid values are stop, pause, and resume.
     * @throws TenableIoException the tenable IO exception
     */
    public void controlScans( int scannerId, String scanUuid, String action ) throws TenableIoException {
        ScannerControlRequest request = new ScannerControlRequest().withAction( action );
        HttpFuture httpFuture = asyncHttpService.doPost( createBaseUriBuilder( "/scanners/" + scannerId +
                "/scans/" + scanUuid + "/control" ).build(), request );
        httpFuture.get();
    }


    /**
     * Enables or disables the link state of the scanner identified by scannerId.
     *
     * @param scannerId the scanner id
     * @param link      the link
     * @throws TenableIoException the tenable IO exception
     */
    public void toggleLinkState( int scannerId, int link ) throws TenableIoException {
        ScannerToggleLinkRequest request = new ScannerToggleLinkRequest().withLink( link );
        HttpFuture httpFuture = asyncHttpService.doPut( createBaseUriBuilder( "/settings/" + scannerId +
                "/link" ).build(), request );
        httpFuture.get();
    }


    private class ScannerToggleLinkRequest {
        private int link;


        /**
         * Gets link.
         *
         * @return the link
         */
        public int getLink() {
            return link;
        }


        /**
         * Sets link.
         *
         * @param link the link
         */
        public void setLink( int link ) {
            this.link = link;
        }


        /**
         * Sets link.
         *
         * @param link the link
         */
        public ScannerToggleLinkRequest withLink( int link ) {
            this.link = link;
            return this;
        }
    }

    private class ScannerControlRequest {
        private String action;


        /**
         * Gets action.
         *
         * @return the action
         */
        public String getAction() {
            return action;
        }


        /**
         * Sets action.
         *
         * @param action the action
         */
        public void setAction( String action ) {
            this.action = action;
        }


        /**
         * Sets action.
         *
         * @param action the action
         */
        public ScannerControlRequest withAction( String action ) {
            this.action = action;
            return this;
        }
    }

}
