package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class FilteringOptions {
    private Integer dateRange;
    private List<Filter> filters;
    private FilterSearchType searchType;


    /**
     * The number of days of data prior to and including today that should be returned.
     *
     * @return the date range
     */
    @JsonProperty( "date_range" )
    public Integer getDateRange() {
        return dateRange;
    }


    /**
     * The number of days of data prior to and including today that should be returned.
     *
     * @param dateRange the date range
     */
    @JsonProperty( "date_range" )
    public void setDateRange( int dateRange ) {
        this.dateRange = dateRange;
    }


    /**
     * The number of days of data prior to and including today that should be returned.
     *
     * @param dateRange the date range
     */
    public FilteringOptions withDateRange( int dateRange ) {
        setDateRange( dateRange );
        return this;
    }


    /**
     * An array containing filters to apply to the exported scan report.
     *
     * @return the filters
     */
    public List<Filter> getFilters() {
        return filters;
    }


    /**
     * An array containing filters to apply to the exported scan report.
     *
     * @param filters the filters
     */
    public void setFilters( List<Filter> filters ) {
        this.filters = filters;
    }


    /**
     * An array containing filters to apply to the exported scan report.
     *
     * @param filters the filters
     */
    public FilteringOptions withFilters( List<Filter> filters ) {
        setFilters( filters );
        return this;
    }


    /**
     * The type of search to be used.
     *
     * @return the search type
     */
    @JsonProperty( "filter.search_type" )
    public FilterSearchType getSearchType() {
        return searchType;
    }


    /**
     * The type of search to be used.
     *
     * @param searchType the search type
     */
    @JsonProperty( "filter.search_type" )
    public void setSearchType( FilterSearchType searchType ) {
        this.searchType = searchType;
    }


    /**
     * The type of search to be used.
     *
     * @param searchType the search type
     */
    public FilteringOptions withSearchType( FilterSearchType searchType ) {
        setSearchType( searchType );
        return this;
    }
}
