package com.tenable.io.api.server.models;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
public class ServerCapabilities {
    private boolean multiScanner;
    private String multiUser;
    private boolean reportEmailConfig;
    private ServerTwoFactor twoFactor;


    /**
     * Gets two factor.
     *
     * @return the two factor
     */
    @JsonProperty( "two_factor" )
    public ServerTwoFactor getTwoFactor() {
        return twoFactor;
    }


    /**
     * Sets two factor.
     *
     * @param twoFactor the two factor
     */
    @JsonProperty( "two_factor" )
    public void setTwoFactor( ServerTwoFactor twoFactor ) {
        this.twoFactor = twoFactor;
    }


    /**
     * Is multi scanner boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "multi_scanner" )
    public boolean isMultiScanner() {
        return multiScanner;
    }


    /**
     * Sets multi scanner.
     *
     * @param multiScanner the multi scanner
     */
    @JsonProperty( "multi_scanner" )
    public void setMultiScanner( boolean multiScanner ) {
        this.multiScanner = multiScanner;
    }


    /**
     * Gets multi user.
     *
     * @return the multi user
     */
    @JsonProperty( "multi_user" )
    public String getMultiUser() {
        return multiUser;
    }


    /**
     * Sets multi user.
     *
     * @param multiUser the multi user
     */
    @JsonProperty( "multi_user" )
    public void setMultiUser( String multiUser ) {
        this.multiUser = multiUser;
    }


    /**
     * Is report email config boolean.
     *
     * @return the boolean
     */
    @JsonProperty( "report_email_config" )
    public boolean isReportEmailConfig() {
        return reportEmailConfig;
    }


    /**
     * Sets report email config.
     *
     * @param reportEmailConfig the report email config
     */
    @JsonProperty( "report_email_config" )
    public void setReportEmailConfig( boolean reportEmailConfig ) {
        this.reportEmailConfig = reportEmailConfig;
    }
}
