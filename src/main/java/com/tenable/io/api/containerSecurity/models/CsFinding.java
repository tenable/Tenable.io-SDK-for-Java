package com.tenable.io.api.containerSecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsFinding {
    private CsNvdFinding nvdFinding;
    private List<CsInstalledPackage> packages;

    /**
     * Gets nvd finding.
     *
     * @return the nvd finding
     */
    @JsonProperty( "nvd_finding" )
    public CsNvdFinding getNvdFinding() {
        return nvdFinding;
    }

    /**
     * Sets nvd finding.
     *
     * @param nvdFinding the nvd finding
     */
    @JsonProperty( "nvd_finding" )
    public void setNvdFinding( CsNvdFinding nvdFinding ) {
        this.nvdFinding = nvdFinding;
    }

    /**
     * Gets packages.
     *
     * @return the packages
     */
    public List<CsInstalledPackage> getPackages() {
        return packages;
    }

    /**
     * Sets packages.
     *
     * @param packages the packages
     */
    public void setPackages( List<CsInstalledPackage> packages ) {
        this.packages = packages;
    }
}
