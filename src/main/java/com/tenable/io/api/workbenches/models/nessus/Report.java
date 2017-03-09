package com.tenable.io.api.workbenches.models.nessus;


import com.tenable.io.api.models.AssetVulnerabilities;

import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class Report {
    private String name;
    private List<AssetVulnerabilities> assetsWithVulnerabilities;


    /**
     * Instantiates a new Report.
     */
    public Report() {
        assetsWithVulnerabilities = new ArrayList<>();
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName( String name ) {
        this.name = name;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public Report withName( String name ) {
        setName( name );
        return this;
    }


    /**
     * Gets assetsWithVulnerabilities.
     *
     * @return the assetsWithVulnerabilities
     */
    public List<AssetVulnerabilities> getAssetsWithVulnerabilities() {
        return assetsWithVulnerabilities;
    }


    /**
     * Sets assetsWithVulnerabilities.
     *
     * @param assetsWithVulnerabilities the assetsWithVulnerabilities
     */
    public void setAssetsWithVulnerabilities( List<AssetVulnerabilities> assetsWithVulnerabilities ) {
        this.assetsWithVulnerabilities = assetsWithVulnerabilities;
    }


    /**
     * Adds a host to the collection.
     *
     * @param host the host to add
     */
    public void addAssetWithVulnerabilities( AssetVulnerabilities host ) {
        assetsWithVulnerabilities.add( host );
    }
}
