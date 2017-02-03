package com.tenable.io.api.workbenches.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetInfoCounts {
    private AssetVulnerabilities vulnerabilities;


    /**
     * Gets vulnerabilities.
     *
     * @return the vulnerabilities
     */
    public AssetVulnerabilities getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets vulnerabilities.
     *
     * @param vulnerabilities the vulnerabilities
     */
    public void setVulnerabilities( AssetVulnerabilities vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }
}
