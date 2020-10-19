package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class Export {
    private String uuid;
    private Status status;
    private long totalChunks;
    private long finishedChunks;
    private VulnsExportFilters filters;
    private long numAssetsPerChunk;
    private long created;


    /**
     * Sets the export jobs request UUID.
     *
     * @param uuid the export jobs request UUID
     */
    public void setUuid( String uuid ) { this.uuid = uuid; }


    /**
     * Gets the export jobs request UUID.
     *
     * @return the export jobs request UUID
     */
    public String getUuid() { return this.uuid; }


    /**
     * Sets the status of the export jobs request.
     *
     * @param status the status for the export jobs request
     */
    public void setStatus( Status status ) { this.status = status; }


    /**
     * Gets the status of the export jobs request
     *
     * @return the status of the export jobs request
     */
    public Status getStatus() { return this.status; }


    /**
     * Sets the number of all vulnerability chunks
     *
     * @param totalChunks
     */
    @JsonProperty( "total_chunks" )
    public void setTotalChunks(long totalChunks) {
        this.totalChunks = totalChunks;
    }


    /**
     * Gets the total number of chunks associated with the export job as a whole.
     *
     * @return the total number of chunks associated with the export job as a whole
     */
    @JsonProperty( "total_chunks" )
    public long getTotalChunks() {
        return this.totalChunks;
    }


    /**
     * Sets the number of chunks that have been processed and are available for download.
     *
     * @param finishedChunks
     */
    @JsonProperty( "finished_chunks" )
    public void setFinishedChunks(long finishedChunks) {
        this.finishedChunks = finishedChunks;
    }


    /**
     * Gets the number of chunks that have been processed and are available for download.
     *
     * @return the number of chunks that have been processed and are available for download
     */
    @JsonProperty( "finished_chunks" )
    public long getFinishedChunks() {
        return this.finishedChunks;
    }


    /**
     * Sets the filters to apply to the vulnerability export job
     *
     * @param VulnsExportFilters
     */
    public void setFilters( VulnsExportFilters filters ) { this.filters = filters; }

    /**
     * Gets the vulnerability export job filters
     *
     * @return a Map of all filters included in VulnsExportFilters and formatted tag filters
     */
    public Map getFilters() {

        if (this.filters == null) {
            return null;
        }
        final ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> filterMap = mapper.convertValue(this.filters, Map.class);
        if (this.filters.getTags() != null && this.filters.getTags().size() > 0) {
            filterMap.remove("tags");
            for (Map.Entry<String, String[]> tags : this.filters.getTags().entrySet()) {
                filterMap.put("tag."+tags.getKey(), tags.getValue());
            }

        }
        return filterMap;
    }


    /**
     * Sets the number of assets contained in each export chunk.
     *
     * @param numAssetsPerChunk the number of assets contained in each export chunk
     */
    @JsonProperty( "num_assets_per_chunk" )
    public void setNumAssetsPerChunk(long numAssetsPerChunk) {
        this.numAssetsPerChunk = numAssetsPerChunk;
    }


    /**
     * Gets the number of assets contained in each export chunk.
     *
     * @return the number of assets contained in each export chunk
     */
    @JsonProperty( "num_assets_per_chunk" )
    public long getNumAssetsPerChunk() {
        return this.numAssetsPerChunk;
    }


    /**
     * Sets the Unix timestamp when the export job was created.
     *
     * @param created the Unix timestamp when the export job was created
     */
    public void setCreated(long created) {
        this.created = created;
    }


    /**
     * Gets the Unix timestamp when the export job was created.
     *
     * @return the Unix timestamp when the export job was created
     */
    public long getCreated() {
        return this.created;
    }
}
