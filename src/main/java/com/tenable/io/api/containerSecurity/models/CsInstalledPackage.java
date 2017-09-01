package com.tenable.io.api.containerSecurity.models;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsInstalledPackage {
    private String name;
    private String version;

    /**
     * The version of the installed package.
     *
     * @return the version of the installed package.
     */
    public String getVersion() { return version; }

    /**
     * The version of the installed package.
     *
     * @param version the version of the installed package.
     */
    public void setVersion( String version ) {
        this.version = version;
    }

    /**
     * The name of the installed package.
     *
     * @return the name of the installed package.
     */
    public String getName() {
        return name;
    }

    /**
     * The name of the installed package.
     *
     * @param name the name of the installed package.
     */
    public void setName( String name ) {
        this.name = name;
    }
}
