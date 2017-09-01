package com.tenable.io.core.utilities;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ApiParametersHelper {
    private static String accessKey;
    private static String secretKey;
    private static String tenableIoScheme;
    private static String tenableIoHost;

    private static String DEFAULT_TENABLE_IO_SCHEME = "https";
    private static String DEFAULT_TENABLE_IO_HOST = "cloud.tenable.com";

    static {
        accessKey = System.getProperty( "tenableIoAccessKey" );
        secretKey = System.getProperty( "tenableIoSecretKey" );
        tenableIoScheme = System.getProperty( "tenableIoScheme" );
        tenableIoHost = System.getProperty( "tenableIoHost" );

        if ( accessKey == null ) {
            accessKey = System.getenv( "TENABLEIO_ACCESS_KEY" );
        }

        if ( secretKey == null ) {
            secretKey = System.getenv( "TENABLEIO_SECRET_KEY" );
        }

        if ( tenableIoScheme == null ) {
            tenableIoScheme = System.getProperty( "TENABLE_IO_SCHEME" );

            if ( tenableIoScheme == null ) {
                tenableIoScheme = DEFAULT_TENABLE_IO_SCHEME;
            }
        }

        if ( tenableIoHost == null ) {
            tenableIoHost = System.getProperty( "TENABLE_IO_HOST" );

            if ( tenableIoHost == null ) {
                tenableIoHost = DEFAULT_TENABLE_IO_HOST;
            }
        }
    }

    /**
     * Gets access key.
     *
     * @return the access key
     */
    public static String getAccessKey() {
        return accessKey;
    }

    /**
     * Gets secret key.
     *
     * @return the secret key
     */
    public static String getSecretKey() {
        return secretKey;
    }

    /**
     * Gets tenable io scheme.
     *
     * @return the tenable io scheme
     */
    public static String getTenableIoScheme() {
        return tenableIoScheme;
    }

    /**
     * Gets tenable io host.
     *
     * @return the tenable io host
     */
    public static String getTenableIoHost() {
        return tenableIoHost;
    }
}
