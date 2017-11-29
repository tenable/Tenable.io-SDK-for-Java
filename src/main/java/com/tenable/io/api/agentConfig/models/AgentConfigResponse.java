package com.tenable.io.api.agentConfig.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class AgentConfigResponse {
    private AutoUnlink autoUnlink;
    private Boolean softwareUpdate;

    /**
     * Gets auto unlink.
     *
     * @return the auto unlink
     */
    @JsonProperty ( "auto_unlink" )
    public AutoUnlink getAutoUnlink() {
        return autoUnlink;
    }

    /**
     * Sets auto unlink.
     *
     * @param autoUnlink the auto unlink
     */
    @JsonProperty( "auto_unlink" )
    public void setAutoUnlink( AutoUnlink autoUnlink ) {
        this.autoUnlink = autoUnlink;
    }

    /**
     * Gets software update.
     *
     * @return the software update
     */
    @JsonProperty( "software_update" )
    public Boolean getSoftwareUpdate() {
        return softwareUpdate;
    }

    /**
     * Sets software update.
     *
     * @param softwareUpdate the software update
     */
    @JsonProperty( "software_update" )
    public void setSoftwareUpdate( Boolean softwareUpdate ) {
        this.softwareUpdate = softwareUpdate;
    }
}
