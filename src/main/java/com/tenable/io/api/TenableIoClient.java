package com.tenable.io.api;

import com.tenable.io.api.exclusions.ExclusionsApi;
import com.tenable.io.api.exports.ExportsApi;
import com.tenable.io.api.plugins.PluginsApi;
import com.tenable.io.api.scans.ScanHelper;
import com.tenable.io.api.scans.ScansApi;
import com.tenable.io.core.services.AsyncHttpService;
import com.tenable.io.core.utilities.ApiParametersHelper;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class TenableIoClient implements AutoCloseable {
    private String impersonateUsername = null;

    private String accessKey;
    private String secretKey;
    private String tenableIoHost;
    private String tenableIoScheme;

    private AsyncHttpService asyncHttpService;
    private ScansApi scansApi = null;
    private PluginsApi pluginsApi = null;
    private ExclusionsApi exclusionsApi = null;
    private ScanHelper scanHelper = null;
    private ExportsApi exportsApi = null;

    /**
     * Instantiates a new Tenable IO client from environment variables.
     * Needs JVM params tenableIoAccessKey and tenableIoSecretKey or environment variables TENABLEIO_ACCESS_KEY and TENABLEIO_SECRET_KEY
     */
    public TenableIoClient() {
        accessKey = ApiParametersHelper.getAccessKey();
        secretKey = ApiParametersHelper.getSecretKey();
        tenableIoScheme = ApiParametersHelper.getTenableIoScheme();
        tenableIoHost = ApiParametersHelper.getTenableIoHost();

        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }


    /**
     * Instantiates a new Tenable IO client.
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     */
    public TenableIoClient( String accessKey, String secretKey ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        tenableIoScheme = ApiParametersHelper.getTenableIoScheme();
        tenableIoHost = ApiParametersHelper.getTenableIoHost();

        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }

    /**
     * Instantiates a new Tenable IO client.
     *
     * @param host       io host url
     * @param hostScheme io host scheme
     * @param accessKey  the access key
     * @param secretKey  the secret key
     */
    public TenableIoClient( String host, String hostScheme, String accessKey, String secretKey ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        tenableIoScheme = hostScheme;
        tenableIoHost = host;

        asyncHttpService = new AsyncHttpService( accessKey, secretKey );
    }


    /**
     * Instantiates a new Tenable IO client which impersonates the given user.
     * Only used via the {@link #impersonate( String ) impersonate} method
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     * @param impersonateUsername the username to impersonate
     */
    private TenableIoClient( String accessKey, String secretKey, String impersonateUsername ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.impersonateUsername = impersonateUsername;

        asyncHttpService = new AsyncHttpService( accessKey, secretKey, impersonateUsername );
    }


    /**
     * Instantiates a new Tenable IO client, using the given proxy
     * Note: this constructor is only used for development/debug and TURNS OFF SSL VALIDATION
     *
     * @param asyncHttpService the asyncHttpService to use
     */
    TenableIoClient( AsyncHttpService asyncHttpService ) {
        this.asyncHttpService = asyncHttpService;
    }


    /**
     * Returns a new client which impersonates the given user
     *
     * @param username The username to impersonate
     * @return The new client, which impersonates the given user
     */
    public TenableIoClient impersonate( String username ) {
        return new TenableIoClient( accessKey, secretKey, username );
    }


    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() {
      if( asyncHttpService != null )
        try {
          asyncHttpService.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }


    /**
     * Gets plugins api.
     *
     * @return the plugins api
     */
    synchronized public PluginsApi getPluginsApi() {
        if( pluginsApi == null )
            pluginsApi = new PluginsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return pluginsApi;
    }

    /**
     * Gets scans api.
     *
     * @return the scans api
     */
    synchronized public ScansApi getScansApi() {
        if( scansApi == null )
            scansApi = new ScansApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return scansApi;
    }

    /**
     * Gets scan helper.
     *
     * @return the scan helper
     */
    synchronized public ScanHelper getScanHelper() {
        if( scanHelper == null )
            scanHelper = new ScanHelper( this );

        return scanHelper;
    }

    /**
     * Gets exports api.
     *
     * @return the exports api
     */
    synchronized public ExportsApi getExportsApi() {
        if( exportsApi == null )
            exportsApi = new ExportsApi( asyncHttpService, getTenableIoScheme(), getTenableIoHost() );

        return exportsApi;
    }


    private String getTenableIoHost() {
        return tenableIoHost;
    }

    private String getTenableIoScheme() {
        return tenableIoScheme;
    }
}
