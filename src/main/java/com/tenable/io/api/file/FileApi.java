package com.tenable.io.api.file;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.ApiWrapperBase;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.services.HttpFuture;
import com.tenable.io.core.utilities.models.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FileApi extends ApiWrapperBase {
    /**
     * Instantiates a new Api wrapper base.
     *
     * @param asyncHttpService the AsyncHttpService
     * @param apiScheme        the Tenable IO scheme
     * @param ApiHost          the Tenable IO host
     */
    public FileApi( AsyncHttpService asyncHttpService, String apiScheme, String ApiHost ) {
        super( asyncHttpService, apiScheme, ApiHost );
    }


    /**
     * Uploads a file.
     *
     * @param fileToUpload the file to upload
     * @return the upload filename (from the server)
     * @throws TenableIoException the tenable IO exception
     */
    public String upload( File fileToUpload ) throws TenableIoException {
        return upload( fileToUpload, false );
    }


    /**
     * Uploads a file.
     *
     * @param fileToUpload the file to upload
     * @param isEncrypted  true if the file is encrypted
     * @return the upload filename (from the server)
     * @throws TenableIoException the tenable IO exception
     */
    public String upload( File fileToUpload, boolean isEncrypted ) throws TenableIoException {
        // TODO: check to see if we need these optional parameters and ask about encryption password
        List<Pair<String, String>> params = new ArrayList<>();
        params.add( new Pair<>( "freq", "ONETIME" ) );
//        params.add( new Pair<>( "startDate", "12/13/2016" ) );
//        params.add( new Pair<>( "startTime", "11:30" ) );
//        params.add( new Pair<>( "timezone", "Zulu" ) );
//        params.add( new Pair<>( "interval", "1" ) );
//        params.add( new Pair<>( "repeatBy", "BYMONTHDAY" ) );

        HttpFuture httpFuture = asyncHttpService.doMultipartFormPostUpload( createBaseUriBuilder( "/file/upload" ).build(), fileToUpload, params );
        return httpFuture.getAsJson().get( "fileuploaded" ).textValue();
    }


    private class FileUploadRequest {
        private int noEnc;


        /**
         * Gets no_enc.
         * Send value of 1 when uploading an encrypted file.
         *
         * @return the no_enc, 1 for encrypted file, 0 otherwise
         */
        @JsonProperty( "no_enc" )
        public int getNoEnc() {
            return noEnc;
        }


        /**
         * Sets no_enc.
         * Send value of 1 when uploading an encrypted file.
         *
         * @param noEnc the no_enc value. Set to 1 when uploading an encrypted file.
         */
        @JsonProperty( "no_enc" )
        public void setNoEnc( int noEnc ) {
            this.noEnc = noEnc;
        }
    }
}
