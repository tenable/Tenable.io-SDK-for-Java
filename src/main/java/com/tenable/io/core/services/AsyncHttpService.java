package com.tenable.io.core.services;


import com.fasterxml.jackson.databind.JsonNode;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.utilities.JsonHelper;
import javafx.util.Pair;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.client.methods.ZeroCopyConsumer;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AsyncHttpService implements AutoCloseable {
    private static int CONNECTION_REQUEST_TIMEOUT = 30000;
    private static int CONNECTION_TIMEOUT = 30000;
    private static int SOCKET_TIMEOUT = 60000; // 1 min

    private CloseableHttpAsyncClient asyncClient = null;
    private JsonHelper jsonHelper;
    private List<Header> defaultHeaders;


    /**
     * Instantiates a new Async http service.
     * Note: if JVM variables "proxyHost" and "proxyPort" are set, it will use it.
     * This feature is meant to be used for development/debug only and will TURN OFF SSL VALIDATION
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     */
    public AsyncHttpService( String accessKey, String secretKey ) {
        this( accessKey, secretKey, null );
    }


    /**
     * Instantiates a new Async http service.
     * Note: if JVM variables "proxyHost" and "proxyPort" are set, it will use it.
     * This feature is meant to be used for development/debug only and will TURN OFF SSL VALIDATION
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     * @param impersonateUsername the username of the user to impersonate
     */
    public AsyncHttpService( String accessKey, String secretKey, String impersonateUsername ) {
        String proxyHost = System.getProperty( "proxyHost" );
        String proxyPort = System.getProperty( "proxyPort" );
        // if a proxy is set, uses it
        if( proxyHost != null && proxyPort != null )
            initClient( accessKey, secretKey, CONNECTION_REQUEST_TIMEOUT, CONNECTION_TIMEOUT, SOCKET_TIMEOUT, new HttpHost( proxyHost, Integer.parseInt( proxyPort ) ), true, impersonateUsername );
        else
            initClient( accessKey, secretKey, CONNECTION_REQUEST_TIMEOUT, CONNECTION_TIMEOUT, SOCKET_TIMEOUT, null, impersonateUsername );

        jsonHelper = new JsonHelper();
    }


    /**
     * Makes an HTTP GET request using the given URI.
     *
     * @param uri the URI to use for the GET call
     * @return the resulting HttpFuture instance
     */
    public HttpFuture doGet( URI uri ) {
        HttpGet httpGet = new HttpGet( uri );
        return new HttpFuture( this, httpGet, asyncClient.execute( httpGet, null ), null );
    }


    /**
     * Makes an HTTP DELETE request using the given URI.
     *
     * @param uri the URI to use for the DELETE call
     * @return the resulting HttpFuture instance
     */
    public HttpFuture doDelete( URI uri ) {
        HttpDelete httpDelete = new HttpDelete( uri );
        return new HttpFuture( this, httpDelete, asyncClient.execute( httpDelete, null ), null );
    }


    /**
     * Makes an HTTP POST request using the given URI and optional body.
     *
     * @param uri  the URI to use for the POST call
     * @param json Optional, can be null. the JSON to POST
     * @return the resulting HttpFuture instance
     */
    public HttpFuture doPost( URI uri, JsonNode json ) {
        HttpPost httpPost = new HttpPost( uri );

        String body = null;
        if( json != null ) {
            body = jsonHelper.serialize( json );
            httpPost.setEntity( new NStringEntity( body, ContentType.create( "application/json", "UTF-8" ) ) );
        }

        return new HttpFuture( this, httpPost, asyncClient.execute( httpPost, null ), body );
    }


    /**
     * Makes an HTTP POST request using the given URI and optional body.
     *
     * @param <A>          the type parameter
     * @param uri          the URI to use for the POST call
     * @param objectToSend Optional, can be null. An Object that will be serialized to JSON and POSTed
     * @return the resulting HttpFuture instance
     */
    public <A> HttpFuture doPost( URI uri, A objectToSend ) {
        return doPost( uri, objectToSend != null ? jsonHelper.toJson( objectToSend ) : null );
    }


    /**
     * Makes an HTTP PUT request using the given URI and optional body.
     *
     * @param uri  the URI to use for the PUT call
     * @param json Optional, can be null. the JSON to PUT
     * @return the resulting HttpFuture instance
     */
    public HttpFuture doPut( URI uri, JsonNode json ) {
        HttpPut httpPut = new HttpPut( uri );

        String body = null;
        if( json != null ) {
            body = jsonHelper.serialize( json );
            httpPut.setEntity( new NStringEntity( body, ContentType.create( "application/json", "UTF-8" ) ) );
        }

        return new HttpFuture( this, httpPut, asyncClient.execute( httpPut, null ), body );
    }


    /**
     * Makes an HTTP PUT request using the given URI and optional body.
     *
     * @param <A>          the type parameter
     * @param uri          the URI to use for the PUT call
     * @param objectToSend Optional, can be null. An Object that will be serialized to JSON and PUTed
     * @return the resulting HttpFuture instance
     */
    public <A> HttpFuture doPut( URI uri, A objectToSend ) {
        return doPut( uri, objectToSend != null ? jsonHelper.toJson( objectToSend ) : null );
    }


    /**
     * Makes an HTTP GET request using the given URI and stream the result into the given File.
     *
     * @param uri             the URI to use for the GET call
     * @param destinationFile the destination file
     * @return the resulting HttpFuture instance
     * @throws TenableIoException the tenable IO exception
     */
    public HttpFuture doGetDownload( URI uri, File destinationFile ) throws TenableIoException {
        HttpGet httpGet = new HttpGet( uri );

        ZeroCopyConsumer<HttpResponse> consumer;
        try {
            consumer = new ZeroCopyConsumer<HttpResponse>( destinationFile ) {

                @Override
                protected HttpResponse process( final HttpResponse response, final File file, final ContentType contentType ) throws Exception {
                    return response;
                }

            };
        } catch( FileNotFoundException e ) {
            throw new TenableIoException( TenableIoErrorCode.FileError, String.format( "Couldn't open file: %s.", destinationFile.getAbsolutePath() ), e );
        }

        return new HttpFuture( this, httpGet, consumer, asyncClient.execute( HttpAsyncMethods.create( httpGet ), consumer, null, null ), null );
    }


    /**
     * Makes a multipart form HTTP POST request using the given URI to upload/stream the given file, with optional form parameters.
     *
     * @param uri                         the URI to use for the POST call
     * @param fileToUpload                the file to upload
     * @param additionalRequestParameters Optional, can be null. Additional request parameters as key/value pair that will be added to the multipart form request.
     * @return the resulting HttpFuture instance
     * @throws TenableIoException the tenable IO exception
     */
    public HttpFuture doMultipartFormPostUpload( URI uri, File fileToUpload, List<Pair<String, String>> additionalRequestParameters ) throws TenableIoException {

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode( HttpMultipartMode.BROWSER_COMPATIBLE );
        try {
            builder.addBinaryBody( "Filedata", new FileInputStream( fileToUpload ), ContentType.DEFAULT_BINARY, fileToUpload.getName() );
        } catch( FileNotFoundException e ) {
            throw new TenableIoException( TenableIoErrorCode.FileError, String.format( "Couldn't open file: %s.", fileToUpload.getAbsolutePath() ), e );
        }

        for( Pair<String, String> parameter : additionalRequestParameters ) {
            builder.addTextBody( parameter.getKey(), parameter.getValue() );
        }

        HttpPost httpPost = new HttpPost( uri );
        try {
            httpPost.setEntity( new BufferedHttpEntity( builder.build() ) );
        } catch( IOException e ) {
            throw new TenableIoException( TenableIoErrorCode.FileError, String.format( "Couldn't upload file: %s.", fileToUpload.getAbsolutePath() ), e );
        }

        return new HttpFuture( this, httpPost, asyncClient.execute( httpPost, null ), null );
    }


    /**
     * This method should be called when disposing of the AsyncHttpService instance
     *
     * @throws Exception if an I/O error occurs
     */
    public void close() throws Exception {
        if( asyncClient != null ) {
            asyncClient.close();
            asyncClient = null;
        }
    }


    /**
     * Retries given HTTP request. Called internally only, from the HttpFuture
     *
     * @param httpUriRequest   the HttpUriRequest to retry
     * @param responseConsumer the response consumer
     * @return the resulting Future<HttpResponse> instance
     */
    Future<HttpResponse> retryOperation( HttpUriRequest httpUriRequest, HttpAsyncResponseConsumer<HttpResponse> responseConsumer ) {
        return responseConsumer == null ? asyncClient.execute( httpUriRequest, null ) : asyncClient.execute( HttpAsyncMethods.create( httpUriRequest ), responseConsumer, null, null );
    }


    private void initClient( String accessKey, String secretKey, int connectionRequestTimeout, int connectionTimeout, int socketTimeout, HttpHost proxy, String impersonateUsername ) {
        initClient( accessKey, secretKey, connectionRequestTimeout, connectionTimeout, socketTimeout, proxy, false, impersonateUsername );
    }


    private void initClient( String accessKey, String secretKey, int connectionRequestTimeout, int connectionTimeout, int socketTimeout, HttpHost proxy, boolean noSslValidation, String impersonateUsername ) {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();

        requestConfigBuilder.setConnectionRequestTimeout( connectionRequestTimeout ).setConnectTimeout( connectionTimeout ).setSocketTimeout( socketTimeout );
        if( proxy != null )
            requestConfigBuilder.setProxy( proxy );

        SSLContext sslContext = null;
        // Note: this block of code disables SSL validation. It is only used during development/testing when testing through a proxy
        if( noSslValidation ) {
            try {
                sslContext = SSLContexts.custom().loadTrustMaterial( new TrustStrategy() {
                    @Override
                    public boolean isTrusted( X509Certificate[] chain, String authType ) throws CertificateException {
                        return true;
                    }
                } )
                        .build();
            } catch( Exception e ) {
            }
        }

        //system properties
        Map<String, String> systemProperties = ManagementFactory.getRuntimeMXBean().getSystemProperties();

        defaultHeaders = new ArrayList<>( 3 );
        defaultHeaders.add( new BasicHeader( "X-ApiKeys", String.format( "accessKey=%s; secretKey=%s", accessKey, secretKey ) ) );
        defaultHeaders.add( new BasicHeader( "User-Agent", String.format( "TenableIOSDK Java/%s %s/%s/%s", systemProperties.get( "java.runtime.version" ), systemProperties.get( "os.name" ), systemProperties.get( "os.version" ), systemProperties.get( "os.arch" ) ) ) );

        if( impersonateUsername != null ) {
            defaultHeaders.add( new BasicHeader( "X-Impersonate", "username=" + impersonateUsername ) );
        }

        asyncClient = HttpAsyncClients.custom()
                .setDefaultRequestConfig( requestConfigBuilder.build() )
                .setDefaultHeaders( defaultHeaders )
                .setSSLContext( sslContext )
                .build();

        asyncClient.start();
    }


    /**
     * Gets json helper.
     *
     * @return the json helper
     */
    JsonHelper getJsonHelper() {
        return jsonHelper;
    }


    /**
     * Gets the default headers.
     * This is only exposed to (package) HttpFuture for logging purpose.
     *
     * @return the default headers
     */
    List<Header> getDefaultHeaders() {
        return defaultHeaders;
    }
}
