package com.tenable.io.api.containerSecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Confirm that the values returned for ContainerImage are correct ( It might be changed )

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsContainerImage {
    private int numberOfVulnerabilities;
    private String name;
    private String digest;
    private Float score;
    private String id;
    private String status;
    private String createdAt;
    private String platform;
    private String updatedAt;

    /**
     * The number of vulnerabilities of the image.
     *
     * @return The number of vulnerabilities of the image.
     */
    @JsonProperty( "number_of_vulnerabilities" )
    public int getNumberOfVulnerabilities() { return this.numberOfVulnerabilities; }

    /**
     * The number of vulnerabilities of the image.
     *
     * @param numberOfVulnerabilities The number of vulnerabilities of the image.
     */
    @JsonProperty( "number_of_vulnerabilities" )
    public void setNumberOfVulnerabilities( int numberOfVulnerabilities ) { this.numberOfVulnerabilities = numberOfVulnerabilities; }

    /**
     * The name of the image.
     *
     * @return The number of vulnerabilities of the image.
     */
    public String getName() { return this.name; }

    /**
     * The name of the image.
     *
     * @param name The name of the image.
     */
    public void setName( String name ) { this.name = name; }

    /**
     * The digest of the image.
     *
     * @return The digest of the image.
     */
    public String getDigest() { return this.digest; }

    /**
     * The digest of the image.
     *
     * @param digest The digest of the image.
     */
    public void setDigest( String digest ) { this.digest = digest; }

    /**
     * The score of the image.
     *
     * @return The score of the image.
     */
    public Float getScore() { return this.score; }

    /**
     * The score of the image.
     *
     * @param score The score of the image.
     */
    public void setScore( Float score ) { this.score = score; }

    /**
     * The unique id of the image.
     *
     * @return The unique id of the image.
     */
    public String getId() { return this.id; }

    /**
     * The unique id of the image.
     *
     * @param id The unique id of the image.
     */
    public void setId( String id ) { this.id = id; }

    /**
     * The status of the image.
     *
     * @return The status of the image.
     */
    public String getStatus() { return this.status; }

    /**
     * The status of the image.
     *
     * @param status The status of the image.
     */
    public void setStatus( String status ) { this.status = status; }

    /**
     * The date in which the image was created.
     *
     * @return The date in which the image was created.
     */
    @JsonProperty( "created_at" )
    public String getCreatedAt() { return this.createdAt; }

    /**
     * The date in which the image was created.
     *
     * @param createdAt The date in which the image was created.
     */
    @JsonProperty( "created_at" )
    public void setCreatedAt( String createdAt ) { this.createdAt = createdAt; }

    /**
     * The platform with which the image runs.
     *
     * @return The platform with which the image runs.
     */
    public String getPlatform() { return this.platform; }

    /**
     * The platform with which the image runs.
     *
     * @param platform The platform with which the image runs.
     */
    public void setPlatform( String platform ) { this.platform = platform; }

    /**
     * The date in which the image was last updated.
     *
     * @return The date in which the image was last updated.
     */
    @JsonProperty( "updated_at" )
    public String getUpdatedAt() { return this.updatedAt; }

    /**
     * The date in which the image was last updated.
     *
     * @param updatedAt The date in which the image was last updated.
     */
    @JsonProperty( "updated_at" )
    public void setUpdatedAt( String updatedAt ) { this.updatedAt = updatedAt; }
}
