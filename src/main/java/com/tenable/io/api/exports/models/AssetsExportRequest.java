package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AssetsExportRequest {
    private static final int lowerRange = 100;
    private static final int higherRange = 10000;
    private int chunkSize;
    private AssetsExportFilters filters;


    /**
     * Initializes the assets export request with chunk size of 1000 and no filters
     */
    public AssetsExportRequest() {
        setChunkSize( 1000 );
        setFilters( null );
    }


    /**
     * Initializes the assets export request with provided chunk size and no filters
     *
     * @param chunkSize Number of assets per exported chunk
     */
    public AssetsExportRequest( int chunkSize ) {
        setChunkSize( chunkSize );
        setFilters( null );
    }


    /**
     * Initializes the assets export request with chunk size of 1000 and provided filters
     *
     * @param filters The assets export request filters
     */
    public AssetsExportRequest( AssetsExportFilters filters ) {
        setChunkSize( 1000 );
        setFilters( filters );
    }


    /**
     * Initializes the assets export request with provided chunk size and filters
     *
     * @param chunkSize Number of assets per exported chunk
     * @param filters The assets export request filters
     */
    public AssetsExportRequest( int chunkSize, AssetsExportFilters filters ) {
        setChunkSize( chunkSize );
        setFilters( filters );
    }


    /**
     * Sets the number of assets per exported chunk. Range is 100-10000. Required
     *
     * @param chunkSize The number of assets per exported chunk
     */
    @JsonProperty( "chunk_size" )
    public void setChunkSize( int chunkSize ) throws IllegalArgumentException {
        if ( chunkSize < lowerRange || chunkSize > higherRange ) {
            throw new IllegalArgumentException( String.format( "Chunk size %s is out of range. You must specify value between %s and %s", chunkSize, lowerRange, higherRange ) );
        }

        this.chunkSize = chunkSize;
    }


    /**
     * Gets the chunk size
     *
     * @return the number of assets per exported chunk
     */
    @JsonProperty( "chunk_size" )
    public int getChunkSize() { return this.chunkSize; }


    /**
     * Sets the filters for the assets export
     *
     * @param AssetsExportFilters the assets export filters
     */
    public void setFilters( AssetsExportFilters filters ) { this.filters = filters; }


    /**
     * Gets the assets export filters
     *
     * @return a Map of all filters included in AssetsExportFilters and formatted tag filters
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
