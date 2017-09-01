package com.tenable.io.api.containerSecurity.models;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsTestJobImage extends CsTestJob {
    private String digest;

    /**
     * Gets digest.
     *
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Sets digest.
     *
     * @param digest the digest
     */
    public void setDigest( String digest ) {
        this.digest = digest;
    }
}
