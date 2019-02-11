package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class VulnsExportRequest {
    private int numAssets;
    private VulnsExportFilters filters;


    /**
     * Initializes the vulns export request with 50 number of assets and no filters
     */
    public VulnsExportRequest() {
        setNumAssets( 50 );
        setFilters( null );
    }


    /**
     * Initializes the vulns export request with provided number of assets and no filters
     *
     * @param numAssets The number of assets per exported chunk
     */
    public VulnsExportRequest( int numAssets ) {
        setNumAssets( numAssets );
        setFilters( null );
    }


    /**
     * Initializes the vulns export request with provided filters and 50 assets per exported chunk
     *
     * @param numAssets The number of assets per exported chunk
     * @param filters An instance of VulnsExportFilters
     */
    public VulnsExportRequest( VulnsExportFilters filters ) {
        setNumAssets( 50 );
        setFilters( filters );
    }


    /**
     * Initializes the vulns export request with provided number of assets and filters
     *
     * @param numAssets The number of assets per exported chunk
     * @param filters An instance of VulnsExportFilters
     */
    public VulnsExportRequest( int numAssets, VulnsExportFilters filters ) {
        setNumAssets( numAssets );
        setFilters( filters );
    }


    /**
     * Sets the number of assets per exported chunk. Default is 50. Range is 50-5000
     * Specifying a value outside of the range will result in the lower or upper bound value
     *
     * @param numAssets The number of assets per exported chunk
     */
    @JsonProperty( "num_assets" )
    public void setNumAssets( int numAssets ) { this.numAssets = numAssets; }

    /**
     * Gets the number of assets
     *
     * @return the number of assets per exported chunk
     */
    @JsonProperty( "num_assets" )
    public int getNumAssets() { return this.numAssets; }

    /**
     * Sets the filters to apply to the vulnerability export
     *
     * @param VulnsExportFilters
     */
    public void setFilters( VulnsExportFilters filters ) { this.filters = filters; }

    /**
     * Gets the vulnerability export filters
     *
     * @return a Map of all filters included in VulnsExportFilters and formatted tag filters
     */
    public Map getFilters() {

        if (this.filters == null) {
            return null;
        }
        final ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> filterMap = mapper.convertValue(this.filters, Map.class);
        if (this.filters.getTags().size() > 0) {
            filterMap.remove("tags");
            for (Map.Entry<String, String[]> tags : this.filters.getTags().entrySet()) {
                filterMap.put("tag."+tags.getKey(), tags.getValue());
            }

        }
        return filterMap;
    }

}
