package com.tenable.io.api.workbenches.models;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class WbAssetInfoCounts {
    private WbAssetVulnerabilities vulnerabilities;


    /**
     * Gets vulnerabilities.
     *
     * @return the vulnerabilities
     */
    public WbAssetVulnerabilities getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets vulnerabilities.
     *
     * @param vulnerabilities the vulnerabilities
     */
    public void setVulnerabilities( WbAssetVulnerabilities vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }
}
