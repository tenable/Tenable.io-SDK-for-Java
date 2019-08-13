package com.tenable.io.api.assetImport.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AssetImportJob {
    private String jobId;
    private String containerId;
    private String source;
    private int batches;
    private int uploadedAssets;
    private int failedAssets;
    private long lastUpdateTime;
    private String status;
    private String statusMessage;
    private long startTime;
    private long endTime;


    /**
     * Gets last update time.
     *
     * @return the last update time
     */
    @JsonProperty( "last_update_time" )
    public long getLastUpdateTime() { return lastUpdateTime; }


    /**
     * Sets last update time.
     *
     * @param lastUpdateTime the last update time
     */
    @JsonProperty( "last_update_time" )
    public void setLastUpdateTime( String lastUpdateTime ) {
        this.lastUpdateTime = Long.parseLong(lastUpdateTime);
    }


    /**
     * Gets uploaded assets.
     *
     * @return the uploaded assets
     */
    @JsonProperty( "uploaded_assets" )
    public int getUploadedAssets() { return uploadedAssets; }


    /**
     * Sets uploaded assets.
     *
     * @param uploadedAssets the uploaded assets
     */
    @JsonProperty( "uploaded_assets" )
    public void setUploadedAssets( int uploadedAssets ) { this.uploadedAssets = uploadedAssets; }


    /**
     * Gets batches.
     *
     * @return the batches
     */
    public int getBatches() { return batches; }


    /**
     * Sets batches.
     *
     * @param batches the batches
     */
    public void setBatches( int batches ) { this.batches = batches; }


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


    /**
     * Gets container id.
     *
     * @return the container id
     */
    @JsonProperty( "container_id" )
    public String getContainerId() { return containerId; }


    /**
     * Sets container id.
     *
     * @param containerId the container id
     */
    @JsonProperty( "container_id" )
    public void setContainerId( String containerId ) { this.containerId = containerId; }


    /**
     * Gets job id.
     *
     * @return the job id
     */
    @JsonProperty( "job_id" )
    public String getJobId() { return jobId; }


    /**
     * Sets job id.
     *
     * @param jobId the job id
     */
    @JsonProperty( "job_id" )
    public void setJobId( String jobId ) { this.jobId = jobId; }


    /**
     * Gets start time.
     *
     * @return the start time
     */
    @JsonProperty( "start_time" )
    public long getStartTime() { return startTime; }


    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    @JsonProperty( "start_time" )
    public void setStartTime( String startTime ) {
        this.startTime = Long.parseLong(startTime);
    }


    /**
     * Gets end time.
     *
     * @return the end time
     */
    @JsonProperty( "end_time" )
    public long getEndTime() { return endTime; }


    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    @JsonProperty( "end_time" )
    public void setEndTime( String endTime ) {
        this.endTime = Long.parseLong(endTime);
    }


    /**
     * Gets failed assets.
     *
     * @return the failed assets
     */
    @JsonProperty( "failed_assets" )
    public int getFailedAssets() { return failedAssets; }


    /**
     * Sets failed assets.
     *
     * @param failedAssets the failed assets
     */
    @JsonProperty( "failed_assets" )
    public void setFailedAssets( int failedAssets ) { this.failedAssets = failedAssets; }


    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() { return status; }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus( String status ) { this.status = status; }


    /**
     * Gets status message.
     *
     * @return the status message
     */
    @JsonProperty( "status_message" )
    public String getStatusMessage() { return statusMessage; }


    /**
     * Sets status message.
     *
     * @param StatusMessage the status message
     */
    @JsonProperty( "status_message" )
    public void setStatusMessage( String StatusMessage ) { this.statusMessage = statusMessage; }
}
