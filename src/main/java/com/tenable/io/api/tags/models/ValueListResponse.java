package com.tenable.io.api.tags.models;

import com.tenable.io.api.agents.models.AgentPagination;


/**
 * Copyright (c) 2018 Tenable Network Security, Inc.
 */
public class ValueListResponse {
    private TagValue[] values;
    private AgentPagination pagination;


    /**
     * Gets the array of values
     *
     * @return the array of values.
     */
    public TagValue[] getValues() {
        return values;
    }


    /**
     * Sets the array of values.
     *
     * @param values the array of values.
     */
    public void setValues( TagValue[] values ) {
        this.values = values;
    }


    /**
     * Gets the pagination info
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
