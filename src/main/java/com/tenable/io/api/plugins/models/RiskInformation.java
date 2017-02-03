package com.tenable.io.api.plugins.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class RiskInformation {
    private String riskFactor;
    private String cvssBaseScore;
    private String cvssVectore;
    private String cvssTemporalVector;
    private String cvssTemporalScore;
    private String stigSeverity;


    /**
     * Gets risk factor.
     *
     * @return the risk factor
     */
    @JsonProperty( "risk_factor" )
    public String getRiskFactor() {
        return riskFactor;
    }


    /**
     * Sets risk factor.
     *
     * @param riskFactor the risk factor
     */
    @JsonProperty( "risk_factor" )
    public void setRiskFactor( String riskFactor ) {
        this.riskFactor = riskFactor;
    }


    /**
     * Gets cvss base score.
     *
     * @return the cvss base score
     */
    @JsonProperty( "cvss_base_score" )
    public String getCvssBaseScore() {
        return cvssBaseScore;
    }


    /**
     * Sets cvss base score.
     *
     * @param cvssBaseScore the cvss base score
     */
    @JsonProperty( "cvss_base_score" )
    public void setCvssBaseScore( String cvssBaseScore ) {
        this.cvssBaseScore = cvssBaseScore;
    }


    /**
     * Gets cvss vectore.
     *
     * @return the cvss vectore
     */
    @JsonProperty( "cvss_vector" )
    public String getCvssVectore() {
        return cvssVectore;
    }


    /**
     * Sets cvss vectore.
     *
     * @param cvssVectore the cvss vectore
     */
    @JsonProperty( "cvss_vector" )
    public void setCvssVectore( String cvssVectore ) {
        this.cvssVectore = cvssVectore;
    }


    /**
     * Gets cvss temporal vector.
     *
     * @return the cvss temporal vector
     */
    @JsonProperty( "cvss_temporal_vector" )
    public String getCvssTemporalVector() {
        return cvssTemporalVector;
    }


    /**
     * Sets cvss temporal vector.
     *
     * @param cvssTemporalVector the cvss temporal vector
     */
    @JsonProperty( "cvss_temporal_vector" )
    public void setCvssTemporalVector( String cvssTemporalVector ) {
        this.cvssTemporalVector = cvssTemporalVector;
    }


    /**
     * Gets cvss temporal score.
     *
     * @return the cvss temporal score
     */
    @JsonProperty( "cvss_temporal_score" )
    public String getCvssTemporalScore() {
        return cvssTemporalScore;
    }


    /**
     * Sets cvss temporal score.
     *
     * @param cvssTemporalScore the cvss temporal score
     */
    @JsonProperty( "cvss_temporal_score" )
    public void setCvssTemporalScore( String cvssTemporalScore ) {
        this.cvssTemporalScore = cvssTemporalScore;
    }


    /**
     * Gets stig severity.
     *
     * @return the stig severity
     */
    @JsonProperty( "stig_severity" )
    public String getStigSeverity() {
        return stigSeverity;
    }


    /**
     * Sets stig severity.
     *
     * @param stigSeverity the stig severity
     */
    @JsonProperty( "stig_severity" )
    public void setStigSeverity( String stigSeverity ) {
        this.stigSeverity = stigSeverity;
    }

}
