package com.tenable.io.api.containerSecurity.models;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsPotentiallyUnwantedProgram {
    private String file;
    private String md5;
    private String sha256;

    /**
     * Gets file.
     *
     * @return the file
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets file.
     *
     * @param file the file
     */
    public void setFile( String file ) {
        this.file = file;
    }

    /**
     * Gets md 5.
     *
     * @return the md 5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * Sets md 5.
     *
     * @param md5 the md 5
     */
    public void setMd5( String md5 ) {
        this.md5 = md5;
    }

    /**
     * Gets sha 256.
     *
     * @return the sha 256
     */
    public String getSha256() {
        return sha256;
    }

    /**
     * Sets sha 256.
     *
     * @param sha256 the sha 256
     */
    public void setSha256( String sha256 ) {
        this.sha256 = sha256;
    }
}
