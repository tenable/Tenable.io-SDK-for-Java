package com.tenable.io.api.containerSecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsTestJob {
    public static String STATUS_COMPLETED = "completed";

    private String containerId;
    private String jobId;
    private String error;
    private String jobStatus;
    private String createdAt;
    private String updatedAt;

    /**
     * Gets container id.
     *
     * @return the container id
     */
    @JsonProperty ( "container_id" )
    public String getContainerId() {
        return containerId;
    }

    /**
     * Sets container id.
     *
     * @param containerId the container id
     */
    @JsonProperty ( "container_id" )
    public void setContainerId( String containerId ) {
        this.containerId = containerId;
    }

    /**
     * Gets job id.
     *
     * @return the job id
     */
    @JsonProperty ( "job_id" )
    public String getJobId() {
        return jobId;
    }

    /**
     * Sets job id.
     *
     * @param jobId the job id
     */
    @JsonProperty ( "job_id" )
    public void setJobId( String jobId ) {
        this.jobId = jobId;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError( String error ) {
        this.error = error;
    }

    /**
     * Gets job status.
     *
     * @return the job status
     */
    @JsonProperty ( "job_status" )
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * Sets job status.
     *
     * @param jobStatus the job status
     */
    @JsonProperty ( "job_status" )
    public void setJobStatus( String jobStatus ) {
        this.jobStatus = jobStatus;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    @JsonProperty ( "created_at" )
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    @JsonProperty ( "created_at" )
    public void setCreatedAt( String createdAt ) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    @JsonProperty ( "updated_at" )
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    @JsonProperty ( "updated_at" )
    public void setUpdatedAt( String updatedAt ) {
        this.updatedAt = updatedAt;
    }

}
