package com.tenable.io.api.users.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ApiKey {
    private String accessKey;
    private String secretKey;


    /**
     * Gets access key.
     *
     * @return the access key
     */
    public String getAccessKey() {
        return accessKey;
    }


    /**
     * Sets access key.
     *
     * @param accessKey the access key
     */
    public void setAccessKey( String accessKey ) {
        this.accessKey = accessKey;
    }


    /**
     * Gets secret key.
     *
     * @return the secret key
     */
    public String getSecretKey() {
        return secretKey;
    }


    /**
     * Sets secret key.
     *
     * @param secretKey the secret key
     */
    public void setSecretKey( String secretKey ) {
        this.secretKey = secretKey;
    }
}
