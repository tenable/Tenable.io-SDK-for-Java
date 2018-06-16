package com.tenable.io.api.exports.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.assetImport.models.Source;

import java.util.List;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AssetsExportFilters {
    private long createdAt;
    private long updatedAt;
    private long terminatedAt;
    private long deletedAt;
    private long firstScanTime;
    private long lastAuthenticatedScanTime;
    private long lastAssessed;
    private boolean servicenowSysid;
    private List<Source> sources;
    private boolean hasPluginResults;


    /**
     * Setting this filter will return all assets created later than this date.
     * Should be in Unix timestamp format
     *
     * @param createdAt the asset creation date
     */
    @JsonProperty( "created_at" )
    public void setCreatedAt( long createdAt ) { this.createdAt = createdAt; }


    /**
     * Gets the asset creation date
     *
     * @return the asset's creation date
     */
    @JsonProperty( "created_at" )
    public long getCreatedAt() { return createdAt; }


    /**
     * Setting this filter will return all assets updated later than this date.
     * Should be in Unix timestamp format
     *
     * @param updatedAt update date
     */
    @JsonProperty( "updated_at" )
    public void setUpdatedAt( long updatedAt ) { this.updatedAt = updatedAt; }


    /**
     * Gets the updated at filter
     *
     * @return the updated at date
     */
    @JsonProperty( "updated_at" )
    public long getUpdatedAt() { return updatedAt; }


    /**
     * Setting this filter will return all assets terminated later than this date.
     * Should be in Unix timestamp format
     *
     * @param terminatedAt the terminated at filter
     */
    @JsonProperty( "terminated_at" )
    public void setTerminatedAt( long terminatedAt ) { this.terminatedAt = terminatedAt; }


    /**
     * Gets the terminated at filter
     *
     * @return the terminated at filter
     */
    @JsonProperty( "terminated_at" )
    public long getTerminatedAt()  { return terminatedAt; }


    /**
     * Setting this filter will return all assets deleted later than this date
     * Should be in Unix timestamp format
     *
     * @param deletedAt the deleted at filter
     */
    @JsonProperty( "deleted_at" )
    public void setDeletedAt( long deletedAt ) { this.deletedAt = deletedAt; }


    /**
     * Gets the deleted at filter
     *
     * @return the deleted at filter
     */
    @JsonProperty( "deleted_at" )
    public long getDeletedAt() { return deletedAt; }


    /**
     * Setting this filter will return all assets with a first scan time later than this date
     * Should be in Unix timestamp format
     *
     * @param firstScanTime the first scan time filter
     */
    @JsonProperty( "first_scan_time" )
    public void setFirstScanTime( long firstScanTime ) { this.firstScanTime = firstScanTime; }


    /**
     * Gets the first scan time filter
     *
     * @return the first scan time filter
     */
    @JsonProperty( "first_scan_time" )
    public long getFirstScanTime() { return firstScanTime; }


    /**
     * Setting this filter will return all assets with a last authenticated scan time later than this date
     * Should be in Unix timestamp format
     *
     * @param lastAuthenticatedScanTime the last authenticated scan time filter
     */
    @JsonProperty( "last_authenticated_scan_time" )
    public void setLastAuthenticatedScanTime( long lastAuthenticatedScanTime ) { this.lastAuthenticatedScanTime = lastAuthenticatedScanTime; }


    /**
     * Gets the last authenticated scan time filter
     *
     * @return the last authenticated scan time filter
     */
    @JsonProperty( "last_authenticated_scan_time" )
    public long getLastAuthenticatedScanTime() { return lastAuthenticatedScanTime; }


    /**
     * Setting this filter will return all assets with a last assessed time later than this date
     * An assessed asset indicates that it has been scanned by an Authenticated or Unauthenticated scan.
     * Should be in Unix timestamp format
     *
     * @param lastAssessed the last assessed filter
     */
    @JsonProperty( "last_assessed" )
    public void setLastAssessed( long lastAssessed ) { this.lastAssessed = lastAssessed; }


    /**
     * gets the last assessed filter
     *
     * @return the last assessed filter
     */
    @JsonProperty( "last_assessed" )
    public long getLastAssessed() { return lastAssessed; }


    /**
     * If true, this will return all assets that have a servicenow_sysid, regardless of value.
     * If false, this will return all assets that do not have a servicenow_sysid.
     *
     * @param servicenowSysid
     */
    @JsonProperty( "servicenow_sysid" )
    public void setServicenowSysid( boolean servicenowSysid ) { this.servicenowSysid = servicenowSysid; }


    /**
     * Gets the service now sysid filter
     *
     * @return the service now sysid filter
     */
    @JsonProperty( "servicenow_sysid" )
    public boolean getServicenowSysid() { return servicenowSysid; }


    /**
     * If multiple values are used here it will return all assets that have been seen by either source.
     *
     * @param sources
     */
    public void setSources( List<Source> sources ) { this.sources = sources; }


    /**
     * Gets the sources filter
     *
     * @return the sources filter
     */
    public List<Source> getSources() { return sources; }


    /**
     * Expects a string representation of a boolean. "true" will return all assets that have plugin results
     * "false" will return all assets that do not have plugin results
     *
     * @param hasPluginResults
     */
    @JsonProperty( "has_plugin_results" )
    public void setHasPluginResults( boolean hasPluginResults ) { this.hasPluginResults = hasPluginResults; }


    /**
     * Gets the has plugin results filter
     *
     * @return the has plugin results filter
     */
    public boolean getHasPluginResults() { return hasPluginResults; }
}
