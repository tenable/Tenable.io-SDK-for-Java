package com.tenable.io.core.utilities.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class LogInstance {
    private String httpMethod;
    private String url;
    private Map<String, String> reqHeaders;
    private String reqBody;
    private Map<String, String> respHeaders;
    private String respBody;
    private Integer respHttpStatus;
    private String error;


    /**
     * Gets http method.
     *
     * @return the http method
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public String getHttpMethod() {
        return httpMethod;
    }


    /**
     * Sets http method.
     *
     * @param httpMethod the http method
     */
    public void setHttpMethod( String httpMethod ) {
        this.httpMethod = httpMethod;
    }


    /**
     * With http method log instance.
     *
     * @param httpMethod the http method
     * @return the log instance
     */
    public LogInstance withHttpMethod( String httpMethod ) {
        this.httpMethod = httpMethod;
        return this;
    }


    /**
     * Gets url.
     *
     * @return the url
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public String getUrl() {
        return url;
    }


    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl( String url ) {
        this.url = url;
    }


    /**
     * With url log instance.
     *
     * @param url the url
     * @return the log instance
     */
    public LogInstance withUrl( String url ) {
        this.url = url;
        return this;
    }


    /**
     * Gets req headers.
     *
     * @return the req headers
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public Map<String, String> getReqHeaders() {
        return reqHeaders;
    }


    /**
     * Sets req headers.
     *
     * @param reqHeaders the req headers
     */
    public void setReqHeaders( Map<String, String> reqHeaders ) {
        this.reqHeaders = reqHeaders;
    }


    /**
     * Adds a request headers.
     *
     * @param name  the header name
     * @param value the header value
     */
    public void addReqHeader( String name, String value ) {
        if( this.reqHeaders == null )
            this.reqHeaders = new HashMap<>();

        this.reqHeaders.put( name, value );
    }


    /**
     * Gets req body.
     *
     * @return the req body
     */
    @JsonIgnore
    public String getReqBody() {
        return reqBody;
    }


    /**
     * Sets req body.
     *
     * @param reqBody the req body
     */
    public void setReqBody( String reqBody ) {
        this.reqBody = reqBody;
    }


    /**
     * With req body log instance.
     *
     * @param reqBody the req body
     * @return the log instance
     */
    public LogInstance withReqBody( String reqBody ) {
        this.reqBody = reqBody;
        return this;
    }


    /**
     * Gets resp header.
     *
     * @return the resp headers
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public Map<String, String> getRespHeaders() {
        return respHeaders;
    }


    /**
     * Sets resp header.
     *
     * @param respHeaders the resp headers
     */
    public void setRespHeader( Map<String, String> respHeaders ) {
        this.respHeaders = respHeaders;
    }


    /**
     * With resp header log instance.
     *
     * @param respHeaders the resp headers
     * @return the log instance
     */
    public LogInstance withRespHeader( Map<String, String> respHeaders ) {
        this.respHeaders = respHeaders;
        return this;
    }


    /**
     * With req headers log instance.
     *
     * @param reqHeaders the req headers
     * @return the log instance
     */
    public LogInstance withReqHeaders( Map<String, String> reqHeaders ) {
        this.reqHeaders = reqHeaders;
        return this;
    }


    /**
     * Adds a response headers.
     *
     * @param name  the header name
     * @param value the header value
     */
    public void addRespHeader( String name, String value ) {
        if( this.respHeaders == null )
            this.respHeaders = new HashMap<>();

        this.respHeaders.put( name, value );
    }


    /**
     * Gets resp body.
     *
     * @return the resp body
     */
    @JsonIgnore
    public String getRespBody() {
        return respBody;
    }


    /**
     * Sets resp body.
     *
     * @param respBody the resp body
     */
    public void setRespBody( String respBody ) {
        this.respBody = respBody;
    }


    /**
     * With resp body log instance.
     *
     * @param respBody the resp body
     * @return the log instance
     */
    public LogInstance withRespBody( String respBody ) {
        this.respBody = respBody;
        return this;
    }


    /**
     * Gets resp http status.
     *
     * @return the resp http status
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public Integer getRespHttpStatus() {
        return respHttpStatus;
    }


    /**
     * Sets resp http status.
     *
     * @param respHttpStatus the resp http status
     */
    public void setRespHttpStatus( Integer respHttpStatus ) {
        this.respHttpStatus = respHttpStatus;
    }


    /**
     * With resp http status log instance.
     *
     * @param respHttpStatus the resp http status
     * @return the log instance
     */
    public LogInstance withRespHttpStatus( Integer respHttpStatus ) {
        this.respHttpStatus = respHttpStatus;
        return this;
    }


    /**
     * Gets error.
     *
     * @return the error
     */
    @JsonInclude( JsonInclude.Include.NON_NULL )
    public String getError() {
        return error;
    }


    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError( String error ) {
        this.error = error;
    }


    /**
     * With error log instance.
     *
     * @param error the error
     * @return the log instance
     */
    public LogInstance withError( String error ) {
        this.error = error;
        return this;
    }
}
