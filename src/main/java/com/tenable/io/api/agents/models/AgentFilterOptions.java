package com.tenable.io.api.agents.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentFilterOptions {
    private List<AgentFilter> filters;
    private SortByOptions sort;
    private List<String> wildcardFields;


    /**
     * Gets filters.
     *
     * @return the filters
     */
    public List<AgentFilter> getFilters() { return filters; }

    /**
     * Sets filters.
     *
     * @param filters the filters
     */
    public void setFilters( List<AgentFilter> filters ) { this.filters = filters; }

    /**
     * Gets sort.
     *
     * @return the sort
     */
    public SortByOptions getSort() { return sort; }

    /**
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort( SortByOptions sort ) { this.sort = sort; }

    /**
     * Gets wildcard fields.
     *
     * @return the wildcard fields
     */
    @JsonProperty( "wildcard_fields" )
    public List<String> getWildcardFields() { return wildcardFields; }

    /**
     * Sets wildcard fields.
     *
     * @param wildcardFields the wildcard fields
     */
    @JsonProperty( "wildcard_fields" )
    public void setWildcardFields( List<String> wildcardFields ) { this.wildcardFields = wildcardFields; }

    /**
     * Fields that can be sorted.
     */
    private static class SortByOptions {
        private List<String> sortableFields;

        /**
         * Gets sortable fields.
         *
         * @return the sortable fields
         */
        @JsonProperty( "sortable_fields" )
        public List<String> getSortableFields() { return sortableFields; }

        /**
         * Sets sortable fields.
         *
         * @param sortableFields the sortable fields
         */
        @JsonProperty( "sortable_fields" )
        public void setSortableFields( List<String> sortableFields ) { this.sortableFields = sortableFields; }
    }
}
