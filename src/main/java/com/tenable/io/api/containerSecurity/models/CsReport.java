package com.tenable.io.api.containerSecurity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class CsReport {
    private String id;
    private String imageName;
    private String dockerImageId;
    private String tag;
    private String os;
    private String osVersion;
    private String osArchitecture;
    private String sha256;
    private String sha1;
    private String md5;
    private String platform;
    private String createdAt;
    private String updatedAt;
    private List<CsMalware> malware;
    private List<CsPotentiallyUnwantedProgram> potentiallyUnwantedPrograms;
    private List<CsFinding> findings;
    private List<CsInstalledPackage> installedPackages;
    private int riskScore;
    private String digest;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( String id ) {
        this.id = id;
    }

    /**
     * Gets image name.
     *
     * @return the image name
     */
    @JsonProperty( "image_name" )
    public String getImageName() {
        return imageName;
    }

    /**
     * Sets image name.
     *
     * @param imageName the image name
     */
    @JsonProperty( "image_name" )
    public void setImageName( String imageName ) {
        this.imageName = imageName;
    }

    /**
     * Gets docker image id.
     *
     * @return the docker image id
     */
    @JsonProperty( "docker_image_id" )
    public String getDockerImageId() {
        return dockerImageId;
    }

    /**
     * Sets docker image id.
     *
     * @param dockerImageId the docker image id
     */
    @JsonProperty( "docker_image_id" )
    public void setDockerImageId( String dockerImageId ) {
        this.dockerImageId = dockerImageId;
    }

    /**
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag( String tag ) {
        this.tag = tag;
    }

    /**
     * Gets os.
     *
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets os.
     *
     * @param os the os
     */
    public void setOs( String os ) {
        this.os = os;
    }

    /**
     * Gets os version.
     *
     * @return the os version
     */
    @JsonProperty( "os_version" )
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Sets os version.
     *
     * @param osVersion the os version
     */
    @JsonProperty( "os_version" )
    public void setOsVersion( String osVersion ) {
        this.osVersion = osVersion;
    }

    /**
     * Gets os architecture.
     *
     * @return the os architecture
     */
    @JsonProperty( "os_architecture" )
    public String getOsArchitecture() {
        return osArchitecture;
    }

    /**
     * Sets os architecture.
     *
     * @param osArchitecture the os architecture
     */
    @JsonProperty( "os_architecture" )
    public void setOsArchitecture( String osArchitecture ) {
        this.osArchitecture = osArchitecture;
    }

    /**
     * Gets sha 256.
     *
     * @return the sha 256
     */
    public String getSha256() {
        return sha256;
    }

    /**
     * Sets sha 256.
     *
     * @param sha256 the sha 256
     */
    public void setSha256( String sha256 ) {
        this.sha256 = sha256;
    }

    /**
     * Gets sha 1.
     *
     * @return the sha 1
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * Sets sha 1.
     *
     * @param sha1 the sha 1
     */
    public void setSha1( String sha1 ) {
        this.sha1 = sha1;
    }

    /**
     * Gets md 5.
     *
     * @return the md 5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * Sets md 5.
     *
     * @param md5 the md 5
     */
    public void setMd5( String md5 ) {
        this.md5 = md5;
    }

    /**
     * Gets platform.
     *
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets platform.
     *
     * @param platform the platform
     */
    public void setPlatform( String platform ) {
        this.platform = platform;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    @JsonProperty( "created_at" )
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    @JsonProperty( "created_at" )
    public void setCreatedAt( String createdAt ) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     *
     * @return the updated at
     */
    @JsonProperty( "updated_at" )
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    @JsonProperty( "updated_at" )
    public void setUpdatedAt( String updatedAt ) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets malware.
     *
     * @return the malware
     */
    public List<CsMalware> getMalware() {
        return malware;
    }

    /**
     * Sets malware.
     *
     * @param malware the malware
     */
    public void setMalware( List<CsMalware> malware ) { this.malware = malware; }

    /**
     * Gets potentially unwanted programs.
     *
     * @return the potentially unwanted programs
     */
    @JsonProperty( "potentially_unwanted_programs" )
    public List<CsPotentiallyUnwantedProgram> getPotentiallyUnwantedPrograms() {
        return potentiallyUnwantedPrograms;
    }

    /**
     * Sets potentially unwanted programs.
     *
     * @param potentiallyUnwantedPrograms the potentially unwanted programs
     */
    @JsonProperty( "potentially_unwanted_programs" )
    public void setPotentiallyUnwantedPrograms( List<CsPotentiallyUnwantedProgram> potentiallyUnwantedPrograms ) {
        this.potentiallyUnwantedPrograms = potentiallyUnwantedPrograms;
    }

    /**
     * Gets findings.
     *
     * @return the findings
     */
    public List<CsFinding> getFindings() {
        return findings;
    }

    /**
     * Sets findings.
     *
     * @param findings the findings
     */
    public void setFindings( List<CsFinding> findings ) {
        this.findings = findings;
    }

    /**
     * Gets installed packages.
     *
     * @return the installed packages
     */
    @JsonProperty( "installed_packages" )
    public List<CsInstalledPackage> getInstalledPackages() {
        return installedPackages;
    }

    /**
     * Sets installed packages.
     *
     * @param installedPackages the installed packages
     */
    @JsonProperty( "installed_packages" )
    public void setInstalledPackages( List<CsInstalledPackage> installedPackages ) {
        this.installedPackages = installedPackages;
    }

    /**
     * Gets risk score.
     *
     * @return the risk score
     */
    @JsonProperty( "risk_score" )
    public int getRiskScore() {
        return riskScore;
    }

    /**
     * Sets risk score.
     *
     * @param riskScore the risk score
     */
    @JsonProperty( "risk_score" )
    public void setRiskScore( int riskScore ) {
        this.riskScore = riskScore;
    }

    /**
     * Gets digest.
     *
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Sets digest.
     *
     * @param digest the digest
     */
    public void setDigest( String digest ) {
        this.digest = digest;
    }

}
