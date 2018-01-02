package com.tenable.io.api.assetImport.models;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetImportRequest {
    private List<AssetImport> assets;
    private String source;


    /**
     * With assets asset import request.
     *
     * @param assets the assets
     * @return the asset import request
     */
    public AssetImportRequest withAssets( List<AssetImport> assets ) {
        setAssets( assets );
        return this;
    }


    /**
     * With source asset import request.
     *
     * @param source the source
     * @return the asset import request
     */
    public AssetImportRequest withSource( String source ) {
        setSource( source );
        return this;
    }


    /**
     * Gets assets.
     *
     * @return the assets
     */
    public List<AssetImport> getAssets() { return assets; }


    /**
     * Sets assets.
     *
     * @param assets the assets
     */
    public void setAssets( List<AssetImport> assets ) { this.assets = assets; }


    /**
     * Gets source.
     *
     * @return the source
     */
    public String getSource() { return source; }


    /**
     * Sets source.
     *
     * @param source the source
     */
    public void setSource( String source ) { this.source = source; }
}
