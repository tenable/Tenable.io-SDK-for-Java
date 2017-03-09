package com.tenable.io.api.scans.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tenable.io.api.workbenches.models.Filter;

import java.util.List;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class ExportScanSettings {
    private FileFormat format;
    private String password;
    private String chapters;
    private List<Filter> filters;
    private String searchType;


    /**
     * The file format to use (Nessus, HTML, PDF, CSV, or DB).
     *
     * @return the format
     */
    public FileFormat getFormat() {
        return format;
    }


    /**
     * The file format to use (Nessus, HTML, PDF, CSV, or DB).
     *
     * @param format the format
     */
    public void setFormat( FileFormat format ) {
        this.format = format;
    }


    /**
     * The password used to encrypt database exports (*Required when exporting as DB).
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    /**
     * The password used to encrypt database exports (*Required when exporting as DB).
     *
     * @param password the password
     */
    public void setPassword( String password ) {
        this.password = password;
    }


    /**
     * The chapters to include in the export (expecting a semi-colon delimited string comprised of some combination of
     * the following options: vuln_hosts_summary, vuln_by_host, compliance_exec, remediations, vuln_by_plugin,
     * compliance)
     *
     * @return the chapters
     */
    public String getChapters() {
        return chapters;
    }


    /**
     * The chapters to include in the export (expecting a semi-colon delimited string comprised of some combination of
     * the following options: vuln_hosts_summary, vuln_by_host, compliance_exec, remediations, vuln_by_plugin,
     * compliance)
     *
     * @param chapters the chapters
     */
    public void setChapters( String chapters ) {
        this.chapters = chapters;
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
     * The type of search to be used. "and", "or"
     *
     * @return the search type
     */
    @JsonProperty( "filter.search_type" )
    public String getSearchType() {
        return searchType;
    }


    /**
     * The type of search to be used. "and", "or"
     *
     * @param searchType the search type
     */
    @JsonProperty( "filter.search_type" )
    public void setSearchType( String searchType ) {
        this.searchType = searchType;
    }



    /**
     * The file format to use (Nessus, HTML, PDF, CSV, or DB).
     *
     * @param format the format
     */
    public ExportScanSettings withFormat(FileFormat format) {
        this.format = format;
        return this;
    }


    /**
     * The password used to encrypt database exports (*Required when exporting as DB).
     *
     * @param password the password
     */
    public ExportScanSettings withPassword(String password) {
        this.password = password;
        return this;
    }


    /**
     * The chapters to include in the export (expecting a semi-colon delimited string comprised of some combination of
     * the following options: vuln_hosts_summary, vuln_by_host, compliance_exec, remediations, vuln_by_plugin,
     * compliance)
     *
     * @param chapters the chapters
     */
    public ExportScanSettings withChapters(String chapters) {
        this.chapters = chapters;
        return this;
    }


    /**
     * An array containing filters to apply to the exported scan report.
     *
     * @param filters the filters
     */
    public ExportScanSettings withFilters(List<Filter> filters) {
        this.filters = filters;
        return this;
    }


    /**
     * The type of search to be used. "and", "or"
     *
     * @param searchType the search type
     */
    public ExportScanSettings withSearchType(String searchType) {
        this.searchType = searchType;
        return this;
    }
}
