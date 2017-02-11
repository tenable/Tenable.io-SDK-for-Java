package com.tenable.io.api.workbenches.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ExtendedFilteringOptions {
    private Integer age;
    private Boolean authenticated;
    private Integer dateRange;
    private Boolean exploitable;
    private List<Filter> filters;
    private String searchType;
    private Boolean resolvable;
    private SeverityLevel severity;


    /**
     * Lists only those vulnerabilities older than a certain number of days.
     *
     * @return the age
     */
    public Integer getAge() {
        return age;
    }


    /**
     * Lists only those vulnerabilities older than a certain number of days.
     *
     * @param age the age
     */
    public void setAge( int age ) {
        this.age = age;
    }


    /**
     * Lists only those vulnerabilities older than a certain number of days.
     *
     * @param age the age
     */
    public ExtendedFilteringOptions withAge( int age ) {
        setAge( age );
        return this;
    }


    /**
     * Lists only authenticated vulnerabilities.
     *
     * @return the boolean
     */
    public Boolean isAuthenticated() {
        return authenticated;
    }


    /**
     * Lists only authenticated vulnerabilities.
     *
     * @param authenticated the authenticated
     */
    public void setAuthenticated( boolean authenticated ) {
        this.authenticated = authenticated;
    }


    /**
     * Lists only authenticated vulnerabilities.
     *
     * @param authenticated the authenticated
     */
    public ExtendedFilteringOptions withAuthenticated( boolean authenticated ) {
        setAuthenticated( authenticated );
        return this;
    }


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
    public ExtendedFilteringOptions withDateRange( int dateRange ) {
        setDateRange( dateRange );
        return this;
    }


    /**
     * Lists only exploitable vulnerabilities.
     *
     * @return the boolean
     */
    public Boolean isExploitable() {
        return exploitable;
    }


    /**
     * Lists only exploitable vulnerabilities.
     *
     * @param exploitable the exploitable
     */
    public void setExploitable( boolean exploitable ) {
        this.exploitable = exploitable;
    }


    /**
     * Lists only exploitable vulnerabilities.
     *
     * @param exploitable the exploitable
     */
    public ExtendedFilteringOptions withExploitable( boolean exploitable ) {
        setExploitable( exploitable );
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
    public ExtendedFilteringOptions withFilters( List<Filter> filters ) {
        setFilters( filters );
        return this;
    }


    /**
     * The type of search to be used.
     *
     * @return the search type
     */
    @JsonProperty( "filter.search_type" )
    public String getSearchType() {
        return searchType;
    }


    /**
     * The type of search to be used.
     *
     * @param searchType the search type
     */
    @JsonProperty( "filter.search_type" )
    public void setSearchType( String searchType ) {
        this.searchType = searchType;
    }


    /**
     * The type of search to be used.
     *
     * @param searchType the search type
     */
    public ExtendedFilteringOptions withSearchType( String searchType ) {
        setSearchType( searchType );
        return this;
    }


    /**
     * Lists only those vulnerabilities with a remediation path.
     *
     * @return the boolean
     */
    public Boolean isResolvable() {
        return resolvable;
    }


    /**
     * Lists only those vulnerabilities with a remediation path.
     *
     * @param resolvable the resolvable
     */
    public void setResolvable( boolean resolvable ) {
        this.resolvable = resolvable;
    }


    /**
     * Lists only those vulnerabilities with a remediation path.
     *
     * @param resolvable the resolvable
     */
    public ExtendedFilteringOptions withResolvable( boolean resolvable ) {
        setResolvable( resolvable );
        return this;
    }


    /**
     * Lists only vulnerabilities of a specific severity (critical, high, medium or low)
     *
     * @return the severity
     */
    public SeverityLevel getSeverity() {
        return severity;
    }


    /**
     * Lists only vulnerabilities of a specific severity (critical, high, medium or low)
     *
     * @param severity the severity
     */
    public void setSeverity( SeverityLevel severity ) {
        this.severity = severity;
    }


    /**
     * Lists only vulnerabilities of a specific severity (critical, high, medium or low)
     *
     * @param severity the severity
     */
    public ExtendedFilteringOptions withSeverity( SeverityLevel severity ) {
        setSeverity( severity );
        return this;
    }
}
