package com.tenable.io.core.utilities;


import com.tenable.io.core.exceptions.TenableIoException;
import com.tenable.io.core.exceptions.TenableIoErrorCode;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class UriBuilderHelper {
    private URIBuilder uriBuilder;


    /**
     * Instantiates a new Uri builder helper.
     *
     * @param apiScheme the api scheme
     * @param apiHost   the api host
     */
    public UriBuilderHelper( String apiScheme, String apiHost ) {
        uriBuilder = new URIBuilder().setScheme( apiScheme ).setHost( apiHost );
    }


    /**
     * Instantiates a new Uri builder helper.
     *
     * @param apiScheme the api scheme
     * @param apiHost   the api host
     * @param path      the path
     */
    public UriBuilderHelper( String apiScheme, String apiHost, String path ) {
        this( apiScheme, apiHost );
        setPath( path );
    }


    /**
     * Build the URI, wrapping potential exception into TenableIoException.
     *
     * @return the freshly built uri
     * @throws TenableIoException the tenable IO exception
     */
    public URI build() throws TenableIoException {
        try {
            return uriBuilder.build();
        } catch( URISyntaxException e ) {
            throw new TenableIoException( TenableIoErrorCode.WrongUrlParameters, "Error while building the service URL. Scheme or host may be wrong or possibly some of the query string parameters", e );
        }
    }


    /**
     * Sets URI path. The value is expected to be unescaped and may contain non ASCII characters.
     *
     * @param path the path
     * @return the path
     */
    public UriBuilderHelper setPath( final String path ) {
        uriBuilder.setPath( path );
        return this;
    }


    /**
     * Adds URI query parameters. The parameter name / values are expected to be unescaped
     * and may contain non ASCII characters.
     * <p>
     * Please note query parameters and custom query component are mutually exclusive. This method
     * will remove custom query if present.
     * </p>
     *
     * @param nvps the Name-Value pairs
     * @return the uri builder helper
     */
    public UriBuilderHelper addParameters( final List<NameValuePair> nvps ) {
        uriBuilder.addParameters( nvps );
        return this;
    }


    /**
     * Adds parameter to URI query. The parameter name and value are expected to be unescaped
     * and may contain non ASCII characters.
     * <p>
     * Please note query parameters and custom query component are mutually exclusive. This method
     * will remove custom query if present.
     * </p>
     *
     * @param param the param
     * @param value the value
     * @return the uri builder helper
     */
    public UriBuilderHelper addParameter( final String param, final String value ) {
        uriBuilder.addParameter( param, value );
        return this;
    }
}
