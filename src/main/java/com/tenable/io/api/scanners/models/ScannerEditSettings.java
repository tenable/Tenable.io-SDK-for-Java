package com.tenable.io.api.scanners.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Copyright (c) 2017 Tenable Network Security, Inc.
 */
@JsonInclude( JsonInclude.Include.NON_DEFAULT )
public class ScannerEditSettings {
    private int forcePluginUpdate;
    private int forceUiUpdate;
    private int finishUpdate;
    private String registrationCode;
    private int awsUpdateInterval;


    /**
     * Gets force plugin update. Pass 1 to force a plugin update.
     *
     * @return the force plugin update
     */
    @JsonProperty( "force_plugin_update" )
    public int getForcePluginUpdate() {
        return forcePluginUpdate;
    }


    /**
     * Sets force plugin update. Pass 1 to force a plugin update.
     *
     * @param forcePluginUpdate the force plugin update
     */
    @JsonProperty( "force_plugin_update" )
    public void setForcePluginUpdate( int forcePluginUpdate ) {
        this.forcePluginUpdate = forcePluginUpdate;
    }


    /**
     * Gets force ui update. Pass 1 to force a UI update.
     *
     * @return the force ui update
     */
    @JsonProperty( "force_ui_update" )
    public int getForceUiUpdate() {
        return forceUiUpdate;
    }


    /**
     * Sets force ui update. Pass 1 to force a UI update.
     *
     * @param forceUiUpdate the force ui update
     */
    @JsonProperty( "force_ui_update" )
    public void setForceUiUpdate( int forceUiUpdate ) {
        this.forceUiUpdate = forceUiUpdate;
    }


    /**
     * Gets finish update. Pass 1 to reboot the scanner and run the latest software update (only valid if automatic
     * updates are disabled).
     *
     * @return the finish update
     */
    @JsonProperty( "finish_update" )
    public int getFinishUpdate() {
        return finishUpdate;
    }


    /**
     * Sets finish update. Pass 1 to reboot the scanner and run the latest software update (only valid if automatic
     * updates are disabled).
     *
     * @param finishUpdate the finish update
     */
    @JsonProperty( "finish_update" )
    public void setFinishUpdate( int finishUpdate ) {
        this.finishUpdate = finishUpdate;
    }


    /**
     * Gets registration code for the scanner.
     *
     * @return the registration code for the scanner
     */
    @JsonProperty( "registration_code" )
    public String getRegistrationCode() {
        return registrationCode;
    }


    /**
     * Sets registration code for the scanner.
     *
     * @param registrationCode the registration code for the scanner
     */
    @JsonProperty( "registration_code" )
    public void setRegistrationCode( String registrationCode ) {
        this.registrationCode = registrationCode;
    }


    /**
     * Gets aws update interval. For Amazon Web Services scanners this will tell the scanner how often to check in with
     * its manager.
     *
     * @return the aws update interval
     */
    @JsonProperty( "aws_update_interval" )
    public int getAwsUpdateInterval() {
        return awsUpdateInterval;
    }


    /**
     * Sets aws update interval. For Amazon Web Services scanners this will tell the scanner how often to check in
     * with its manager.
     *
     * @param awsUpdateInterval the aws update interval
     */
    @JsonProperty( "aws_update_interval" )
    public void setAwsUpdateInterval( int awsUpdateInterval ) {
        this.awsUpdateInterval = awsUpdateInterval;
    }


    /**
     * Sets force plugin update. Pass 1 to force a plugin update.
     *
     * @param forcePluginUpdate the force plugin update
     */
    public ScannerEditSettings withForcePluginUpdate(int forcePluginUpdate) {
        this.forcePluginUpdate = forcePluginUpdate;
        return this;
    }


    /**
     * Sets force ui update. Pass 1 to force a UI update.
     *
     * @param forceUiUpdate the force ui update
     */
    public ScannerEditSettings withForceUiUpdate(int forceUiUpdate) {
        this.forceUiUpdate = forceUiUpdate;
        return this;
    }


    /**
     * Sets finish update. Pass 1 to reboot the scanner and run the latest software update (only valid if automatic
     * updates are disabled).
     *
     * @param finishUpdate the finish update
     */
    public ScannerEditSettings withFinishUpdate(int finishUpdate) {
        this.finishUpdate = finishUpdate;
        return this;
    }


    /**
     * Sets registration code for the scanner.
     *
     * @param registrationCode the registration code for the scanner
     */
    public ScannerEditSettings withRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
        return this;
    }


    /**
     * Sets aws update interval. For Amazon Web Services scanners this will tell the scanner how often to check in
     * with its manager.
     *
     * @param awsUpdateInterval the aws update interval
     */
    public ScannerEditSettings withAwsUpdateInterval(int awsUpdateInterval) {
        this.awsUpdateInterval = awsUpdateInterval;
        return this;
    }
}
