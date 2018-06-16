package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class ExportStatus {
    private Status status;
    private List<Integer> chunksAvailable;
    private List<Integer> chunksFailed;
    private List<Integer> chunksCancelled;


    /**
     * Sets the status of the export request.
     *
     * @param status the status for the export request
     */
    public void setStatus( Status status ) { this.status = status; }


    /**
     * Gets the status of the export request
     * @return the status of the export request
     */
    public Status getStatus() { return this.status; }


    /**
     * Sets the list of vulnerability chunk ids available for download
     *
     * @param chunksAvailable
     */
    @JsonProperty( "chunks_available" )
    public void setChunksAvailable( List<Integer> chunksAvailable )  { this.chunksAvailable = chunksAvailable; }


    /**
     * Gets the list of chunk ids available for download
     *
     * @return the list of chunk ids available for download
     */
    @JsonProperty( "chunks_available" )
    public List<Integer> getChunksAvailable() { return this.chunksAvailable; }


    /**
     * Sets the list of chunk ids for the vulnerabilities that failed to export
     *
     * @param chunksFailed
     */
    @JsonProperty( "chunks_failed" )
    public void setChunksFailed( List<Integer> chunksFailed ) { this.chunksFailed = chunksFailed; }


    /**
     * Gets the list of chunk ids for the vulnerabilities that failed to exports
     *
     * @return the chunk ids for the failed vulnerability export
     */
    @JsonProperty( "chunks_failed" )
    public List<Integer> getChunksFailed() { return this.chunksFailed; }


    /**
     * Sets the list of chunk ids for the cancelled vulnerability export
     *
     * @param chunksCancelled
     */
    @JsonProperty( "chunks_cancelled" )
    public void setChunksCancelled( List<Integer> chunksCancelled ) { this.chunksCancelled = chunksCancelled; }


    /**
     * Gets the list of chunk ids for the cancelled vulnerability export
     * @return
     */
    @JsonProperty( "chunks_cancelled" )
    public List<Integer> getChunksCancelled() { return this.chunksCancelled; }
}
