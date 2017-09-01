package com.tenable.io.api.containerSecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsNvdFinding {
    private String referenceId;
    private String cve;
    private String publishedDate;
    private String modifiedDate;
    private String description;
    private String cvssScore;
    private String accessVector;
    private String accessComplexity;
    private String auth;
    private String availabilityImpact;
    private String confidentialityImpact;
    private String integrityImpact;
    private String cwe;
    private List<String> cpe;
    private String remediation;
    private List<String> references;

    /**
     * Gets reference id.
     *
     * @return the reference id
     */
    @JsonProperty( "reference_id" )
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Sets reference id.
     *
     * @param referenceId the reference id
     */
    @JsonProperty( "reference_id" )
    public void setReferenceId( String referenceId ) {
        this.referenceId = referenceId;
    }

    /**
     * Gets cve.
     *
     * @return the cve
     */
    public String getCve() {
        return cve;
    }

    /**
     * Sets cve.
     *
     * @param cve the cve
     */
    public void setCve( String cve ) {
        this.cve = cve;
    }

    /**
     * Gets published date.
     *
     * @return the published date
     */
    @JsonProperty( "published_date" )
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets published date.
     *
     * @param publishedDate the published date
     */
    @JsonProperty( "published_date" )
    public void setPublishedDate( String publishedDate ) {
        this.publishedDate = publishedDate;
    }

    /**
     * Gets modified date.
     *
     * @return the modified date
     */
    @JsonProperty( "modified_date" )
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets modified date.
     *
     * @param modifiedDate the modified date
     */
    @JsonProperty( "modified_date" )
    public void setModifiedDate( String modifiedDate ) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription( String description ) {
        this.description = description;
    }

    /**
     * Gets cvss score.
     *
     * @return the cvss score
     */
    @JsonProperty( "cvss_score" )
    public String getCvssScore() {
        return cvssScore;
    }

    /**
     * Sets cvss score.
     *
     * @param cvssScore the cvss score
     */
    @JsonProperty( "cvss_score" )
    public void setCvssScore( String cvssScore ) {
        this.cvssScore = cvssScore;
    }

    /**
     * Gets access vector.
     *
     * @return the access vector
     */
    @JsonProperty( "access_vector" )
    public String getAccessVector() {
        return accessVector;
    }

    /**
     * Sets access vector.
     *
     * @param accessVector the access vector
     */
    @JsonProperty( "access_vector" )
    public void setAccessVector( String accessVector ) {
        this.accessVector = accessVector;
    }

    /**
     * Gets access complexity.
     *
     * @return the access complexity
     */
    @JsonProperty( "access_complexity" )
    public String getAccessComplexity() {
        return accessComplexity;
    }

    /**
     * Sets access complexity.
     *
     * @param accessComplexity the access complexity
     */
    @JsonProperty( "access_complexity" )
    public void setAccessComplexity( String accessComplexity ) {
        this.accessComplexity = accessComplexity;
    }

    /**
     * Gets auth.
     *
     * @return the auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * Sets auth.
     *
     * @param auth the auth
     */
    public void setAuth( String auth ) {
        this.auth = auth;
    }

    /**
     * Gets availability impact.
     *
     * @return the availability impact
     */
    @JsonProperty( "availability_impact" )
    public String getAvailabilityImpact() {
        return availabilityImpact;
    }

    /**
     * Sets availability impact.
     *
     * @param availabilityImpact the availability impact
     */
    @JsonProperty( "availability_impact" )
    public void setAvailabilityImpact( String availabilityImpact ) {
        this.availabilityImpact = availabilityImpact;
    }

    /**
     * Gets confidentiality impact.
     *
     * @return the confidentiality impact
     */
    @JsonProperty( "confidentiality_impact" )
    public String getConfidentialityImpact() {
        return confidentialityImpact;
    }

    /**
     * Sets confidentiality impact.
     *
     * @param confidentialityImpact the confidentiality impact
     */
    @JsonProperty( "confidentiality_impact" )
    public void setConfidentialityImpact( String confidentialityImpact ) {
        this.confidentialityImpact = confidentialityImpact;
    }

    /**
     * Gets integrity impact.
     *
     * @return the integrity impact
     */
    @JsonProperty( "integrity_impact" )
    public String getIntegrityImpact() {
        return integrityImpact;
    }

    /**
     * Sets integrity impact.
     *
     * @param integrityImpact the integrity impact
     */
    @JsonProperty( "integrity_impact" )
    public void setIntegrityImpact( String integrityImpact ) {
        this.integrityImpact = integrityImpact;
    }

    /**
     * Gets cwe.
     *
     * @return the cwe
     */
    public String getCwe() {
        return cwe;
    }

    /**
     * Sets cwe.
     *
     * @param cwe the cwe
     */
    public void setCwe( String cwe ) {
        this.cwe = cwe;
    }

    /**
     * Gets cpe.
     *
     * @return the cpe
     */
    public List<String> getCpe() {
        return cpe;
    }

    /**
     * Sets cpe.
     *
     * @param cpe the cpe
     */
    public void setCpe( List<String> cpe ) {
        this.cpe = cpe;
    }

    /**
     * Gets remediation.
     *
     * @return the remediation
     */
    public String getRemediation() {
        return remediation;
    }

    /**
     * Sets remediation.
     *
     * @param remediation the remediation
     */
    public void setRemediation( String remediation ) {
        this.remediation = remediation;
    }

    /**
     * Gets references.
     *
     * @return the references
     */
    public List<String> getReferences() {
        return references;
    }

    /**
     * Sets references.
     *
     * @param references the references
     */
    public void setReferences( List<String> references ) {
        this.references = references;
    }

}
