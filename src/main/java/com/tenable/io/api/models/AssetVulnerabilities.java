package com.tenable.io.api.models;


import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetVulnerabilities {
    private String name;
    private Asset asset;
    private List<Vulnerability> vulnerabilities;


    /**
     * Instantiates a new Report host.
     */
    public AssetVulnerabilities() {
        vulnerabilities = new ArrayList<>();
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
     * @return the report host
     */
    public AssetVulnerabilities withName( String name ) {
        setName( name );
        return this;
    }


    /**
     * Gets vulnerabilities.
     *
     * @return the vulnerabilities
     */
    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }


    /**
     * Sets vulnerabilities.
     *
     * @param vulnerabilities the vulnerabilities
     */
    public void setVulnerabilities( List<Vulnerability> vulnerabilities ) {
        this.vulnerabilities = vulnerabilities;
    }


    /**
     * Adds a Vulnerability to the collection.
     *
     * @param vulnerability the Vulnerability to add
     */
    public void addVulnerability( Vulnerability vulnerability ) {
        vulnerabilities.add( vulnerability );
    }


    /**
     * Gets the asset.
     *
     * @return the asset
     */
    public Asset getAsset() {
        return asset;
    }


    /**
     * Sets the asset.
     *
     * @param asset the asset
     */
    public void setAsset( Asset asset ) {
        this.asset = asset;
    }
}
