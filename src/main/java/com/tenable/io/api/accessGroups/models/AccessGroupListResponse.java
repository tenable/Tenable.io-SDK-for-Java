package com.tenable.io.api.accessGroups.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.agents.models.AgentPagination;

/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class AccessGroupListResponse {
    private AccessGroup[] accessGroups;
    private AgentPagination pagination;


    /**
     * Gets the list of access groups.
     *
     * @return the list of access group.
     */
    @JsonProperty( "access_groups" )
    public AccessGroup[] getAccessGroups() {
        return accessGroups;
    }


    /**
     * Sets the list of access groups.
     *
     * @param accessGroups the list of access group.
     */
    @JsonProperty( "access_groups" )
    public void setAccessGroups( AccessGroup[] accessGroups ) {
        this.accessGroups = accessGroups;
    }


    /**
     * Gets the pagination info.
     *
     * @return the pagination info.
     */
    public AgentPagination getPagination() {
        return pagination;
    }


    /**
     * Sets the pagination info.
     *
     * @param pagination the pagination info.
     */
    public void setPagination( AgentPagination pagination ) {
        this.pagination = pagination;
    }
}
