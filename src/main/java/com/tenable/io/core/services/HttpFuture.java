package com.tenable.io.core.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.tenable.io.api.ApiError;
import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import com.tenable.io.core.utilities.LoggerHelper;
import com.tenable.io.core.utilities.models.LogInstance;
import com.tenable.io.core.utilities.models.LogLevel;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class HttpFuture {
    private static Logger logger = LoggerFactory.getLogger( HttpFuture.class );
    private static final Map<TenableIoErrorCode, int[]> retrySteps;
    private static final int REQUEST_AND_RESPONSE_BODY_LOG_MAX_LENGTH = 100 * 1024;
    private static final int MAX_RETRY = 4;

    static {
        retrySteps = new HashMap<>();
        retrySteps.put( TenableIoErrorCode.TooManyApiCalls, new int[]{ 1000, 2000, 6000, 6000, 6000 } );
        retrySteps.put( TenableIoErrorCode.ApiServerError, new int[]{ 1000, 2000, 10000, 10000, 10000 } );
        retrySteps.put( TenableIoErrorCode.DnsError, new int[]{ 1000, 2000, 10000, 10000, 10000 } );
        retrySteps.put( TenableIoErrorCode.ConnectionTimeout, new int[]{ 1000, 2000, 10000, 10000, 10000 } );
    }

    private final AsyncHttpService asyncHttpService;
    private final LogLevel logLevel;
    private HttpAsyncResponseConsumer<HttpResponse> responseConsumer;
    private Future<HttpResponse> httpResponseFuture;
    private int numRetry;
    private final HttpUriRequest httpUriRequest;
    private final String body;


    /**
     * Instantiates a new Http future.
     *
     * @param asyncHttpService   async http service instance
     * @param httpUriRequest     the http uri request
     * @param httpResponseFuture the http response future
     * @param body               the body of the request (optional, can be set to null. Only retained and used for TRACE logging)
     */
    public HttpFuture( AsyncHttpService asyncHttpService, HttpUriRequest httpUriRequest, Future<HttpResponse> httpResponseFuture, String body ) {
        this.asyncHttpService = asyncHttpService;
        this.httpResponseFuture = httpResponseFuture;
        this.httpUriRequest = httpUriRequest;
        this.responseConsumer = null;
        this.numRetry = 0;
        this.logLevel = LoggerHelper.getLogLevel( logger );
        this.body = logLevel == LogLevel.TRACE ? body : null;
    }


    /**
     * Instantiates a new Http future.
     *
     * @param asyncHttpService   async http service instance
     * @param httpUriRequest     the http uri request
     * @param responseConsumer   the response consumer
     * @param httpResponseFuture the http response future
     * @param body               the body
     */
    public HttpFuture( AsyncHttpService asyncHttpService, HttpUriRequest httpUriRequest, HttpAsyncResponseConsumer<HttpResponse> responseConsumer, Future<HttpResponse> httpResponseFuture, String body ) {
        this( asyncHttpService, httpUriRequest, httpResponseFuture, body );
        this.responseConsumer = responseConsumer;
    }


    /**
     * Attempts to cancel execution of this task.  This attempt will
     * fail if the task has already completed, has already been cancelled,
     * or could not be cancelled for some other reason. If successful,
     * and this task has not started when {@code cancel} is called,
     * this task should never run.  If the task has already started,
     * then the {@code mayInterruptIfRunning} parameter determines
     * whether the thread executing this task should be interrupted in
     * an attempt to stop the task.
     * <p>
     * <p>After this method returns, subsequent calls to {@link #isDone} will
     * always return {@code true}.  Subsequent calls to {@link #isCancelled}
     * will always return {@code true} if this method returned {@code true}.
     *
     * @param mayInterruptIfRunning {@code true} if the thread executing this                              task should be interrupted; otherwise, in-progress tasks are allowed                              to complete
     * @return {@code false} if the task could not be cancelled, typically because it has already completed normally; {@code true} otherwise
     */
    public boolean cancel( boolean mayInterruptIfRunning ) {
        return httpResponseFuture.cancel( mayInterruptIfRunning );
    }


    /**
     * Returns {@code true} if this task was cancelled before it completed
     * normally.
     *
     * @return {@code true} if this task was cancelled before it completed
     */
    public boolean isCancelled() {
        return httpResponseFuture.isCancelled();
    }


    /**
     * Returns {@code true} if this task completed.
     * <p>
     * Completion may be due to normal termination, an exception, or
     * cancellation -- in all of these cases, this method will return
     * {@code true}.
     *
     * @return {@code true} if this task completed
     */
    public boolean isDone() {
        return httpResponseFuture.isDone();
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * Use this method if you do not expect a result from the call.
     * If no exception if thrown, the call was successful
     *
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public void get() throws TenableIoException {
        logEvent( getResponse(), "" );
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * This method expects the HTTP call to return a JSON result and tries to deserialize the result into an object corresponding to the given class
     * If no exception if thrown, the call was successful
     *
     * @param <A>   the type parameter
     * @param clazz the class of the object to deserialize the result into
     * @return an object of type A
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public <A> A getAsType( Class<A> clazz ) throws TenableIoException {
        return asyncHttpService.getJsonHelper().fromJson( getAsString(), clazz );
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * This method expects the HTTP call to return a JSON result and tries to deserialize the "result.root" into an object corresponding to the given class
     * Use this method to deserialize into a type contained in "root", for instance object collections returned under a root name
     * If no exception if thrown, the call was successful
     *
     * @param <A>   the type parameter
     * @param clazz the class of the object to deserialize the result into
     * @param root  the root
     * @return an object of type A
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public <A> A getAsType( Class<A> clazz, String root ) throws TenableIoException {
        return asyncHttpService.getJsonHelper().fromJson( getAsJson().get( root ), clazz );
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * This method expects the HTTP call to return a JSON result and tries to deserialize the result into an object corresponding to the given TypeReference
     * Use this method to deserialize into a generic type, example: getAsType( ' )
     * If no exception if thrown, the call was successful
     *
     * @param <A>          the type parameter
     * @param valueTypeRef the TypeReference of the object to deserialize the result into
     * @return an object of type A
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public <A> A getAsType( TypeReference valueTypeRef ) throws TenableIoException {
        return asyncHttpService.getJsonHelper().fromJson( getAsString(), valueTypeRef );
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * This method expects the HTTP call to return a JSON result and tries to deserialize the "result.root" into an object corresponding to the given TypeReference
     * Use this method to deserialize into a generic type contained in "root", for instance object collections returned under a root name
     * Example: getAsType( new TypeReference&lt;ListModel&lt;MyModel&gt;&gt;() {} )
     * If no exception if thrown, the call was successful
     *
     * @param <A>          the type parameter
     * @param valueTypeRef the TypeReference of the object to deserialize the result into
     * @param root         the root
     * @return an object of type A
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public <A> A getAsType( TypeReference valueTypeRef, String root ) throws TenableIoException {
        return asyncHttpService.getJsonHelper().fromJson( getAsJson().get( root ), valueTypeRef );
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * This method expects the HTTP call to return a JSON result and returns it as a parsed JSON tree
     * If no exception if thrown, the call was successful
     *
     * @return the result of the HTTP call as a parsed JSON tree
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public JsonNode getAsJson() throws TenableIoException {
        return asyncHttpService.getJsonHelper().parse( getAsString() );
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * Returns the HTTP call result as text
     * If no exception if thrown, the call was successful
     *
     * @return the result of the HTTP call as text
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    public String getAsString() throws TenableIoException {
        final HttpResponse response;

        response = getResponse();

        try {
            String body = EntityUtils.toString( response.getEntity() );
            logEvent( response, body );
            return body;
        } catch( Exception e ) {
            throw new TenableIoException( TenableIoErrorCode.Generic, "Error while executing HTTP request.", e );
        }
    }


    /**
     * Waits if necessary for the HTTP call to complete
     * Returns the HTTP call HttpResponse. Automatically handles retries if needed and normalize errors.
     *
     * @return the HTTP call HttpResponse
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    private HttpResponse getResponse() throws TenableIoException {
        final HttpResponse response;

        try {
            response = httpResponseFuture.get();
        } catch( Exception e ) {
            TenableIoException exceptionToThrow = new TenableIoException( TenableIoErrorCode.Generic, "Error during request", e );

            if( e.getCause() != null ) {
                if( e.getCause() instanceof UnknownHostException ) { // Could be temporary DNS issue
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.DnsError, "Couldn't resolve host", e );
                } else if( e.getCause() instanceof SocketTimeoutException ) {
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.ConnectionTimeout, "Request timeout", e );
                }
            }

            return checkAndHandleRetries( exceptionToThrow, null );
        }

        boolean retry = false;
        final TenableIoException exceptionToThrow;
        if( response.getStatusLine().getStatusCode() < 200 || response.getStatusLine().getStatusCode() >= 300 ) {
            // get error description, if any
            ApiError error;
            try {
                error = asyncHttpService.getJsonHelper().fromJson( EntityUtils.toString( response.getEntity() ), ApiError.class );
            } catch( Exception e ) {
                error = null;
            }

            switch( response.getStatusLine().getStatusCode() ) {
                case 400: // invalid request
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.InvalidRequestParameter, error != null ? error.getError() : "At least one request parameter is not valid." );
                    break;

                case 401: // non authorized
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.NotAuthorized, error != null ? error.getError() : "You are not authorized to perform this request." );
                    break;

                case 404: // server error
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.NotFound, error != null ? error.getError() : "Requested content not found." );
                    break;

                case 409: // state conflict error
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.StateConflict, error != null ? error.getError() : "The request could not be completed due to a conflict with the current state of the target resource." );
                    break;

                case 429: // rate limit hit
                    retry = true;
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.TooManyApiCalls, error != null ? error.getError() : "API call rate limit reached." );
                    break;

                case 500: // server error
                case 501:
                case 502:
                case 503:
                case 504:
                    retry = true;
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.ApiServerError, error != null ? error.getError() : "API server error." );
                    break;

                default:
                    exceptionToThrow = new TenableIoException( TenableIoErrorCode.Generic, error != null ? error.getError() : "The API returned HTTP status " + response.getStatusLine().getStatusCode() + "." );
                    break;
            }

            if( retry ) {
                return checkAndHandleRetries( exceptionToThrow, response );
            } else {
                logEvent( response, "", exceptionToThrow.getMessage(), exceptionToThrow, 1, true );
                throw exceptionToThrow;
            }
        }

        return response;
    }


    /**
     * Encapsulates and handles retries logic if needed
     *
     * @param e this exception will be thrown as is if no retries or no more retries need to be performed
     * @param response current failed attempt response, used for logging
     * @return the HTTP call HttpResponse of possible retry(ies)
     * @throws TenableIoException Thrown if the HTTP call errors out
     */
    private HttpResponse checkAndHandleRetries( TenableIoException e, HttpResponse response ) throws TenableIoException {
        if( retrySteps.containsKey( e.getErrorCode() ) ) {
            if( numRetry < MAX_RETRY ) {
                numRetry++;

                logEvent( response, "", e.getMessage(), e, numRetry, false );

                try {
                    int[] sleepTimes = retrySteps.get( e.getErrorCode() );
                    Thread.sleep( sleepTimes != null ? sleepTimes[numRetry - 1] : 1500 );
                } catch( InterruptedException e1 ) {}

                httpResponseFuture = asyncHttpService.retryOperation( httpUriRequest, responseConsumer );
                return getResponse();
            }
            else logEvent( response, "", e.getMessage(), e, numRetry + 1, true );
        }

        throw e;
    }


    private void logEvent( HttpResponse response, String respBody ) {
        logEvent( response, respBody, null, null, 0, false );
    }


    private void logEvent( HttpResponse response, String respBody, String error, Exception exception, int attempt, boolean isFinal ) {
        if( logLevel == LogLevel.TRACE || logLevel == LogLevel.DEBUG || ( error != null && ( isFinal || ( logLevel == LogLevel.WARN || logLevel == LogLevel.INFO ) ) ) ) {
            LogInstance logInstance = new LogInstance();

            logRequest( logInstance );
            logResponse( logInstance, response, respBody );

            if( error != null ) {
                logInstance.setError( String.format( "%s. Attempt #: %d. IsLastAttempt: %b.", error, attempt, isFinal ) );
            }

            StringBuilder sb = new StringBuilder( asyncHttpService.getJsonHelper().serialize( asyncHttpService.getJsonHelper().toJson( logInstance ) ) );
            if( logInstance.getReqBody() != null ) {
                sb.append( "\nREQUEST_BODY:\n" ).append( logInstance.getReqBody() );
            }
            if( logInstance.getRespBody() != null ) {
                sb.append( "\nRESPONSE_BODY:\n" ).append( logInstance.getRespBody() );
            }
            String message = sb.toString();

            LogLevel actualLevel = ( error != null ) ? ( isFinal ? LogLevel.ERROR : LogLevel.WARN ) : logLevel;
            switch( actualLevel ) {
                case ERROR:
                    logger.error( message, exception != null ? exception : null );
                    break;
                case WARN:
                    logger.warn( message, exception != null ? exception : null );
                    break;
                case DEBUG:
                    logger.debug( message, exception != null ? exception : null );
                    break;
                case TRACE:
                    logger.trace( message, exception != null ? exception : null );
                    break;
            }
        }
    }


    private LogInstance logResponse( LogInstance logInstance, HttpResponse response, String respBody ) {
        if( response != null ) {
            logInstance.setRespHttpStatus( response.getStatusLine().getStatusCode() );

            // log request headers and body?
            for( Header header : response.getAllHeaders() ) {
                if( logLevel == LogLevel.TRACE || header.getName().toLowerCase().equals( "x-gateway-site-id" ) || header.getName().toLowerCase().equals( "x-request-uuid" ) ) {
                    logInstance.addRespHeader( header.getName(), header.getValue() );
                }
            }

            if( logLevel == LogLevel.TRACE ) {
                if( respBody != null ) {
                    String logRespBody;
                    if( respBody.length() > REQUEST_AND_RESPONSE_BODY_LOG_MAX_LENGTH ) {
                        logRespBody = respBody.substring( 0, REQUEST_AND_RESPONSE_BODY_LOG_MAX_LENGTH ) + "...response body truncated...";
                    }
                    else logRespBody = respBody;

                    logInstance.setRespBody( logRespBody );
                }
           }
        }
        return logInstance;
    }


    private LogInstance logRequest( LogInstance logInstance ) {
        logInstance.withHttpMethod( httpUriRequest.getMethod() ).withUrl( httpUriRequest.getURI().toString() );

        // log request headers and body?
        if( logLevel == LogLevel.TRACE ) {
            for( Header header : httpUriRequest.getAllHeaders() ) {
                logInstance.addReqHeader( header.getName(), header.getValue() );
            }

            for( Header header : asyncHttpService.getDefaultHeaders() ) {
                logInstance.addReqHeader( header.getName(), "X-ApiKeys".equals( header.getName() ) ? "******REDACTED******" : header.getValue() );
            }

            if( body != null ) {
                String logBody;
                if( body.length() > REQUEST_AND_RESPONSE_BODY_LOG_MAX_LENGTH ) {
                    logBody = body.substring( 0, REQUEST_AND_RESPONSE_BODY_LOG_MAX_LENGTH ) + "...request body truncated...";
                }
                else logBody = body;

                logInstance.setReqBody( logBody );
            }
        }

        return logInstance;
    }
}
